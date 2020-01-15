package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Console;



public class ConsoleDB extends ProdottoDB implements ConsoleDAO{
	
	
	public List<Console> doRetriveConsoleAllRange(int offset, int limit) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("SELECT id, immagine, prezzo, descrizione, codiceOfferta, modello, casaProduttrice FROM Console LIMIT ?, ?");
			ps.setInt(1, offset);
			ps.setInt(2, limit);
			ArrayList<Console> console = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Console p = new Console();
				p.setId(rs.getInt(1));
				p.setImmagine(rs.getString(2));
				p.setPrezzo(rs.getFloat(3));
				p.setDescrizione(rs.getString(4));
				p.setCodiceOfferta(rs.getInt(5));
				p.setModello(rs.getString(6));
				p.setCasaProduttrice(rs.getString(7));
				console.add(p);
			}
			return console;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Console findConsoleById(int id) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("SELECT id, immagine, prezzo, descrizione, codiceOfferta, modello, casaProduttrice FROM Console WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Console p = new Console();
				p.setId(rs.getInt(1));
				p.setImmagine(rs.getString(2));
				p.setPrezzo(rs.getFloat(3));
				p.setDescrizione(rs.getString(4));
				p.setCodiceOfferta(rs.getInt(5));
				p.setModello(rs.getString(6));
				p.setCasaProduttrice(rs.getString(7));
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	

	public Console retriveByModello(String against) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, immagine, prezzo, descrizione, codiceOfferta, modello, casaProduttrice FROM Console WHERE modello=? ");
			ps.setString(1, against);
			Console p = new Console();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				p.setId(rs.getInt(1));
				p.setImmagine(rs.getString(2));
				p.setPrezzo(rs.getFloat(3));
				p.setDescrizione(rs.getString(4));
				p.setCodiceOfferta(rs.getInt(5));
				p.setModello(rs.getString(6));
				p.setCasaProduttrice(rs.getString(7));
				return p;
				
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Console> retriveByCasaProduttrice(String casaProduttrice) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, immagine, prezzo, descrizione, codiceOfferta, modello, casaProduttrice FROM Console WHERE casaProduttrice=? ");
			ps.setString(1, casaProduttrice);
			
			ArrayList<Console> console = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Console p = new Console();
				p.setId(rs.getInt(1));
				p.setImmagine(rs.getString(2));
				p.setPrezzo(rs.getFloat(3));
				p.setDescrizione(rs.getString(4));
				p.setCodiceOfferta(rs.getInt(5));
				p.setModello(rs.getString(6));
				p.setCasaProduttrice(rs.getString(7));
				console.add(p);
			}
			return console;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public ArrayList<String>  doRetrieveLike(String against) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"Select modello FROM Console WHERE modello LIKE '%" + against + "%'");
			ResultSet rs = ps.executeQuery();
			ArrayList<String> list = new ArrayList<String>(); 
			if(!rs.next()) {
				return null;
			}
			do {
					list.add(rs.getString("modello"));
			}while(rs.next());			
				
			
			return list;
			}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public void createConsole(Console prodotto) {
		try (Connection con = ConPool.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO Console (id, immagine, prezzo, descrizione, codiceOfferta, modello, casaProduttrice) VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, prodotto.getId());
			ps.setString(2, prodotto.getImmagine());
			ps.setFloat(3, prodotto.getPrezzo());
			ps.setString(4, prodotto.getDescrizione());
			ps.setInt(2, prodotto.getCodiceOfferta());
			ps.setString(2, prodotto.getModello());
			ps.setString(2, prodotto.getCasaProduttrice());
			
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("INSERT error.");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void removeConsole(int codice) {
		try (Connection con = ConPool.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Console WHERE id=?");
			ps.setInt(1, codice);
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("DELETE error.");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
    
}

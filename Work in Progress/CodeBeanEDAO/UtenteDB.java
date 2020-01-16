package model.dao;

import java.sql.PreparedStatement;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.bean.Utente;
import model.bean.CartaDiCredito;

public class UtenteDB{

	
	
	//Memorizza l'utente passato come argomento nel database
	public void createUtente(Utente u) 
	{
			try (Connection con = ConPool.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO Utenti (username, email, cartaDiCredito, password, nome, cognome, provincia, cap, citta, via, numero, ruolo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getEmail());
			ps.setInt(3, u.getCartaDiCredito().getNumeroCarta());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getNome());
			ps.setString(6, u.getCognome());
			ps.setString(7, u.getProvincia());
			ps.setInt(8, u.getCap());
			ps.setString(9, u.getCitta());
			ps.setString(10, u.getVia());
			ps.setInt(11, u.getNumero());
			ps.setArray(12, (Array) u.getRuolo());
			
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("INSERT error.");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	//Rimuove l'utente, avente come username la stringa passata come argomento, dal database
	public void deleteUtente(String user) {
		try(Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM Utente WHERE username = ? ");
			ps.setString(1, user);
			if(ps.executeUpdate() != 1) {
				throw new RuntimeException("DELETE error.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Aggiorna le informazioni anagrafiche dell'utente (Email, indirizzo) nel database
	public void updateUtente(Utente u) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("UPDATE Utente SET email = ? AND password = ? AND provincia = ? AND cap = ? AND citta = ? AND via= ? AND numero = ? WHERE username = ?");
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(3, u.getProvincia());
			ps.setInt(4, u.getCap());
			ps.setString(4, u.getCitta());
			ps.setString(4, u.getVia());
			ps.setInt(4, u.getNumero());
			ps.setString(4, u.getUsername());
			if (ps.executeUpdate() != 1 ) {
				throw new RuntimeException("UPDATE error.");
			
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Aggiorna i ruoli dell'utente nel database
	public void updateRuoloUtente(Utente u) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("UPDATE Utente SET ruolo = ? WHERE username = ?");
			
			ps.setArray(1, (Array) u.getRuolo());
			ps.setString(2, u.getUsername());
			if (ps.executeUpdate() != 1 ) {
				throw new RuntimeException("UPDATE Ruolo error.");
			
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Restituisce l'utente avente come username la stringa passata come argomento
	@SuppressWarnings("unchecked")
	public Utente retriveByUsername(String user) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT username, email, cartaDiCredito, password, nome, cognome, provincia, cap, citta, via, numero, ruolo FROM Utente WHERE username=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Utente p = new Utente();
				p.setUsername(rs.getString(1));
				p.setEmail(rs.getString(2));
				
				if(rs.getInt(3) != 0)
					p.setCartaDiCredito(retriveByNumCarta(rs.getInt(3)));
				else
					p.setCartaDiCredito(null);
				
				p.setPassword(rs.getString(4));
				p.setNome(rs.getString(5));
				p.setCognome(rs.getString(6));
				p.setProvincia(rs.getString(7));
				p.setCap(rs.getInt(8));
				p.setCitta(rs.getString(9));
				p.setVia(rs.getString(10));
				p.setNumero(rs.getInt(11));
				p.setRuoli((ArrayList<String>) rs.getArray(12));
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Restituisce l'utente avete come email la stringa passata come argomento
	@SuppressWarnings("unchecked")
	public Utente retriveByEmail(String email) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT username, email, cartaDiCredito, password, nome, cognome, provincia, cap, citta, via, numero, ruolo FROM Utente WHERE email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Utente p = new Utente();
				p.setUsername(rs.getString(1));
				p.setEmail(rs.getString(2));
				
				if(rs.getInt(3) != 0)
					p.setCartaDiCredito(retriveByNumCarta(rs.getInt(3)));
				else
					p.setCartaDiCredito(null);
				
				p.setPassword(rs.getString(4));
				p.setNome(rs.getString(5));
				p.setCognome(rs.getString(6));
				p.setProvincia(rs.getString(7));
				p.setCap(rs.getInt(8));
				p.setCitta(rs.getString(9));
				p.setVia(rs.getString(10));
				p.setNumero(rs.getInt(11));
				p.setRuoli((ArrayList<String>) rs.getArray(12));
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Restituisce la carta di credito (cercandola per numCarta) associata all'utente 
	private CartaDiCredito retriveByNumCarta(int numCarta) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("SELECT numeroCarta, utenteUsername, utenteEmail, nome, cognome, scadenza, cvv FROM CARTA_DI_CREDITO WHERE numCarta=?");
			ps.setInt(1, numCarta);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				CartaDiCredito p = new CartaDiCredito();
				p.setNumeroCarta(rs.getInt(1));
				p.setUtenteUsername(rs.getString(2));
				p.setUtenteEmail(rs.getString(3));
				p.setNome(rs.getString(4));
				p.setCognome(rs.getString(5));
				p.setScadenzaDate(rs.getDate(6));
				p.setCvv(rs.getInt(7));
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	//Restituisce la lista degli utenti presenti nel database
	@SuppressWarnings("unchecked")
	public List<Utente> retriveAllUtenti() {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("SELECT username, email, cartaDiCredito, password, nome, cognome, provincia, cap, citta, via, numero, ruolo FROM Utente ");
			
			ArrayList<Utente> utenti = new ArrayList<Utente>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utente p = new Utente();
				p.setUsername(rs.getString(1));
				p.setEmail(rs.getString(2));
				
				if(rs.getInt(3) != 0)
					p.setCartaDiCredito(retriveByNumCarta(rs.getInt(3)));
				else
					p.setCartaDiCredito(null);
				
				p.setPassword(rs.getString(4));
				p.setNome(rs.getString(5));
				p.setCognome(rs.getString(6));
				p.setProvincia(rs.getString(7));
				p.setCap(rs.getInt(8));
				p.setCitta(rs.getString(9));
				p.setVia(rs.getString(10));
				p.setNumero(rs.getInt(11));
				p.setRuoli((ArrayList<String>) rs.getArray(12));
				utenti.add(p);
			}
			return utenti;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	

	

	

	
	
	
}

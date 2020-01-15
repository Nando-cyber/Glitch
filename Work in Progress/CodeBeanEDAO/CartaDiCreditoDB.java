package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.CartaDiCredito;



public class CartaDiCreditoDB implements CartaDiCreditoDAO{

	
	//Memorizza nel database la carta di credito passata come argomento
	public void createCartaDiCredito(CartaDiCredito carta) {
		try (Connection con = ConPool.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO CARTA_DI_CREDITO (numeroCarta, utenteUsername, utenteEmail, nome, cognome, scadenza) VALUES(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, carta.getNumeroCarta());
			ps.setString(2, carta.getUtenteUsername());
			ps.setString(3, carta.getUtenteEmail());
			ps.setString(4, carta.getNome());
			ps.setString(5, carta.getCognome());
			ps.setDate(6, carta.getScadenzaDate());

			
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("INSERT error.");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Rimuove la carta di credito avente "numCarta" come numero identificativo dal DB
	public void removeCartaDiCredito(int numCarta) {
		try (Connection con = ConPool.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM CARTA_DI_CREDITO WHERE numeroCarta=?");
			ps.setInt(1, numCarta);
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("DELETE error.");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Restituisce la lista di carte di credito associate all'utente avente come username "user" 
	public List<CartaDiCredito> retriveByUtente(String user) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT numeroCarta, utenteUsername, utenteEmail, nome, cognome, scadenza FROM CartaDiCredito WHERE utenteUsername=? ");
			ps.setString(1, user);
			
			ArrayList<CartaDiCredito> carta = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartaDiCredito p = new CartaDiCredito();
				p.setNumeroCarta(rs.getInt(1));
				p.setUtenteUsername(rs.getString(2));
				p.setUtenteEmail(rs.getString(3));
				p.setNome(rs.getString(4));
				p.setCognome(rs.getString(5));
				p.setScadenzaDate(rs.getDate(6));
				carta.add(p);
			}
			return carta;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Restituisce la carta di credito avente "numCarta" come numero identificativo della carta
	public CartaDiCredito retriveByNumCarta(int numCarta) {
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
	
}

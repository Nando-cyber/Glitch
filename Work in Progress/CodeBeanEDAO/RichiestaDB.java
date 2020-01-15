package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.Richiesta;

public class RichiestaDB implements RichiestaDAO{

	//Memorizza una richiesta passata come argomento nel database
		public void createRichiesta(Richiesta rc) {
			try (Connection con = ConPool.getConnection()) {
				
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO Richiesta (id, utenteEmail, utenteUsername, destinatario, descrizione, stato) VALUES(?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, rc.getId());
				ps.setString(2, rc.getUtenteEmail());
				ps.setString(3, rc.getUtenteUsername());
				ps.setString(4, rc.getDestinatario());
				ps.setString(5, rc.getDescrizione());
				ps.setBoolean(6, rc.getStato());

				if (ps.executeUpdate() != 1) {
					throw new RuntimeException("INSERT error.");
				}

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		//Rimuove una richiesta avente per id l'intero passato come argomento dal database
		public void deleteRichiesta(int id){
			try (Connection con = ConPool.getConnection()) {
				
				PreparedStatement ps = con.prepareStatement("DELETE FROM Richiesta WHERE id=?");
				ps.setInt(1, id);
				if (ps.executeUpdate() != 1) {
					throw new RuntimeException("DELETE error.");
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		//Restituisce una lista di richieste avente come mittente l'email dell'utente passato come argomento
		public List<Richiesta> retriveByMittente(String email) {
			try (Connection con = ConPool.getConnection()) {
				PreparedStatement ps = con.prepareStatement(
						"SELECT id, utenteEmail, utenteUsername, destinatario, descrizione, stato FROM Richiesta WHERE utenteEmail=? ");
				ps.setString(1, email);
				
				ArrayList<Richiesta> richieste = new ArrayList<>();
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Richiesta p = new Richiesta();
					p.setId(rs.getInt(1));
					p.setUtenteEmail(rs.getString(2));
					p.setUtenteUsername(rs.getString(3));
					p.setDestinatario(rs.getString(4));
					p.setDescrizione(rs.getString(5));
					p.setStato(rs.getBoolean(6));
					richieste.add(p);
				}
				return richieste;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		//Restituisce una richiesta avente per id l'intero passato come argomento
		public Richiesta retriveById(int id) {
			try (Connection con = ConPool.getConnection()) {
				PreparedStatement ps = con
						.prepareStatement("SELECT id, utenteEmail, utenteUsername, destinatario, descrizione, stato FROM Richiesta WHERE id=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					Richiesta p = new Richiesta();
					p.setId(rs.getInt(1));
					p.setUtenteEmail(rs.getString(2));
					p.setUtenteUsername(rs.getString(3));
					p.setDestinatario(rs.getString(4));
					p.setDescrizione(rs.getString(5));
					p.setStato(rs.getBoolean(6));
					return p;
				}
				return null;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		//Restituisce una lista di richieste avente per destinatario la stringa passata come argomento
		public List<Richiesta> retriveByDestinatario(String email) {
			try (Connection con = ConPool.getConnection()) {
				PreparedStatement ps = con.prepareStatement(
						"SELECT id, utenteEmail, utenteUsername, destinatario, descrizione, stato FROM Richiesta WHERE destinatario=? ");
				ps.setString(1, email);
				
				ArrayList<Richiesta> richieste = new ArrayList<>();
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Richiesta p = new Richiesta();
					p.setId(rs.getInt(1));
					p.setUtenteEmail(rs.getString(2));
					p.setUtenteUsername(rs.getString(3));
					p.setDestinatario(rs.getString(4));
					p.setDescrizione(rs.getString(5));
					p.setStato(rs.getBoolean(6));
					richieste.add(p);
				}
				return richieste;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	
}

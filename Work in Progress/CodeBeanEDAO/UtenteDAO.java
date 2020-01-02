package model;

import javax.ejb.Remote;

@Remote
public interface UtenteDAO {

	void createUtente(Utente u);
	void deleteUtente(String user);
	Utente updateUtente(Utente u);
	Utente retriveByUsername(String user);
	Utente retriveByEmail(String email);
}

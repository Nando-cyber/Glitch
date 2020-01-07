package model.dao;

import java.util.List;

import javax.ejb.Remote;

import model.bean.Utente;

@Remote
public interface UtenteDAO {

	//Rende persistente l'utente "u" passato come argomento
	void createUtente(Utente u);
	
	//Rimuove l'utente, avente come username la stringa passata come argomento, dal database
	void deleteUtente(String user);
	
	//Aggiorna l'utente "u" nel database
	Utente updateUtente(Utente u);
	
	//Restituisce l'utente avente come username la stringa passata come argomento
	Utente retriveByUsername(String user);
	
	//Restituisce l'utente avete come email la stringa passata come argomento
	Utente retriveByEmail(String email);
	
	//Restituisce la lista degli utenti presenti nel database
	List<Utente> retriveAllUtenti();
}

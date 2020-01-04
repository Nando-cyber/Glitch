package model;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RichiestaDAO{

	//Rende persistente una richiesta "rc"
	void createRichiesta(Richiesta rc);
	
	//Rimuove una richiesta avente per id l'intero passato come argomento
	void deleteRichiesta(int id);
	
	//Restituisce una lista di richieste avente come mittente l'email dell'utente passato come argomento
	List<Richiesta> retriveByMittente(String email);
	
	//Restituisce una richiesta avente per id l'intero passato come argomento
	Richiesta retriveById(int id);
}

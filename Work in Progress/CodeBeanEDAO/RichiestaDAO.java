package model.dao;

import java.util.List;
import model.bean.Richiesta;


public interface RichiestaDAO{

	//Memorizza una richiesta passata come argomento nel database
	void createRichiesta(Richiesta rc);
	
	//Rimuove una richiesta avente per id l'intero passato come argomento dal database
	void deleteRichiesta(int id);
	
	//Restituisce una lista di richieste avente come mittente l'email dell'utente passato come argomento
	List<Richiesta> retriveByMittente(String email);
	
	//Restituisce una richiesta avente per id l'intero passato come argomento
	Richiesta retriveById(int id);
	
	//Restituisce una lista di richieste avente per destinatario la stringa passata come argomento
	List<Richiesta> retriveByDestinatario(String email);
}

package model.dao;

import model.bean.Carrello;

public interface CarrelloDAO {

	//Restituisce il carrello dell'utente avente come username la stringa passata come argomento
	Carrello retriveByUtente(String user);
	
	//Memorizza il carrello passato come argomento nel database
	void createCarrello(Carrello cart);
	
	//Aggiorna la quantità dell'oggetto carrello nel database
	void doUpdate(int prodId, String utenteUsername, String utenteEmail, int quantita);
	
	//Rimuove l'oggetto carrello dell'utente avente come id l'intero passato come argomento 
	void doDelete(int prodId, String utenteUsername, String utenteEmail);
	
	//Rimuove tutti gli oggetti carrello dell'utente
	void removeCarrello(String utenteUsername, String utenteEmail);
	
}

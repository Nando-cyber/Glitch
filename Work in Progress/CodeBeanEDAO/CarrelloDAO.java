package model.dao;

import model.bean.Carrello;
import model.bean.ProdottoQuantita;

public interface CarrelloDAO {

	//Restituisce il carrello dell'utente avente come username la stringa passata come argomento
	Carrello retriveByUtente(String user);
	
	//Memorizza il carrello passato come argomento nel database
	//Se il carrello gi� esiste lo aggiorner� altrimenti lo creer� e lo memorizzer� nel database
	void createCarrello(Carrello cart);
	
	//Aggiorna la quantit� dell'oggetto carrello nel database
	void doUpdate(ProdottoQuantita p);
	
	//Rimuove l'oggetto carrello avente come id l'intero passato come argomento e come username dell'utente la stringa "utenteUsername"
	void doDelete(int prodId, String utenteUsername);
	
	//Rimuove tutti gli oggetti carrello associati all'utente avente come username la stringa passata per argomento
	void removeCarrello(String utenteUsername);
	
}

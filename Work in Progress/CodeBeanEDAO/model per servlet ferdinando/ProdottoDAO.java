package model;

import javax.ejb.Remote;

@Remote
public interface ProdottoDAO {

	//Rende persistente un prodotto "pr" passato come argomento
	void createProdotto(Prodotto l);
	
	//Rimuove un prodotto "pr" dal database
	void removeProdotto(Prodotto l);
	
	//Restituisce un prodotto avente come id l'intero passato come argomento
	Prodotto findProdottoById(int id);
}

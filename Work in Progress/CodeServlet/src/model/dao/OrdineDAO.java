package model.dao;

import java.util.List;

import model.bean.Ordine;

public interface OrdineDAO {

	//Rende persistente un ordine
	void createOrdine(Ordine ord);
	
	//Restituisce la lista di ordini effettuati dall'utente avente come username la stringa passata come argomento
	List<Ordine> retriveByUtente(String user);
	
	//Restituisce l'ordine avente per id l'intero passato come argomento
	Ordine retriveById(long id);
}

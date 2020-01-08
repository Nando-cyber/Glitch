package model.dao;

import javax.ejb.Local;


import model.bean.Carrello;

@Local
public interface CarrelloDAO {

	//Rende persistente il carrello "cart"
	void createCarrello(Carrello cart);
	
	//Rende persistenti gli aggiornamenti sul carrello
	void updateCarrello(Carrello cart);
	
	//Rimuove il carrello dell'utente con username "user" dal DataBase
	void removeCarrello(String user);
	
	//Restituisce il carrello del utente avente come username "user"
	Carrello retriveByUtente(String user);
}

package model;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CartaDiCreditoDAO{
	
	//Rende persistente la carta di credito "cdc"
	void createCartaDiCredito(CartaDiCredito cdc);
	
	//Rimuove la carta di credito avente "numCarta" come numero identificativo dal DB
	void deleteRichiesta(int numCarta);
	
	//Restituisce la carta di credito avente "numCarta" come numero identificativo della carta
	CartaDiCredito retriveByNumCarta(int numCarta);
	
	//Restituisce la lista di carte di credito associate all'utente avente come username "user" 
	public List<CartaDiCredito> retriveByUtente(String user);

}

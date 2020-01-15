package model.dao;

import java.util.List;
import model.bean.CartaDiCredito;


public interface CartaDiCreditoDAO{
	
	//Memorizza nel database la carta di credito passata come argomento
	void createCartaDiCredito(CartaDiCredito carta);
	
	//Rimuove la carta di credito avente "numCarta" come numero identificativo dal DB
	void removeCartaDiCredito(int numCarta);
	
	//Restituisce la carta di credito avente "numCarta" come numero identificativo della carta
	CartaDiCredito retriveByNumCarta(int numCarta);
	
	//Restituisce la lista di carte di credito associate all'utente avente come username "user" 
	List<CartaDiCredito> retriveByUtente(String user);

}

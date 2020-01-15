package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Console;


public interface ConsoleDAO extends ProdottoDAO{

	//Memorizza una console nel database
	void createConsole(Console prodotto);
	
	//Restituisce una lista limitata di console comprese tra i valori "min" e "max" passati come argomento
	List<Console> doRetriveConsoleAllRange(int offset, int limit);
	
	//Restituisce la console che ha come id l'intero passato come argomento
	Console findConsoleById(int id);
	
	//Restituisce la console avente come modello la stringa passata come argomento
	Console retriveByModello(String against);
	
	//Restituisce la lista di console aventi come casa produttrice la stringa passata come argomento
	List<Console> retriveByCasaProduttrice(String casaProduttrice);
	
	//Rimuove una console avente come id "codice" dal database
	void removeConsole(int codice);
	
	ArrayList<String>  doRetrieveLike(String against);
	
}

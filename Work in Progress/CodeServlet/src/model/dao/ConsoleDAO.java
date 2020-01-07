package model.dao;

import model.bean.Console;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ConsoleDAO extends ProdottoDAO{

	//Restituisce una lista di tutte le console presenti nel database
	List<Console> findAllConsole();
	
	//Restituisce una lista limitata di console comprese tra i valori "min" e "max" passati come argomento
	List<Console> doRetriveConsoleAllRange(int min, int max);
	
	//Restituisce la console che ha come id l'intero passato come argomento
	Console findConsoleById(int id);
	
	//Restituisce la console avente come modello la stringa passata come argomento
	Console retriveByModello(String modello);
	
	//Restituisce la lista di console aventi come casa produttrice la stringa passata come argomento
	List<Console> retriveByCasaProduttrice(String casaProduttrice);
	
	
}

package model.dao;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.bean.Console;



@Stateless
@LocalBean
public class ConsoleJPA extends ProdottoJPA implements ConsoleDAO{
	
	@Inject
	private EntityManager em;
	

    //Restituisce una lista di tutte le console presenti nel database
    public List<Console> findAllConsole() {
        TypedQuery<Console> query = em.createNamedQuery(Console.FIND_ALL, Console.class);
        return query.getResultList();
    }

    //Restituisce la console che ha come id l'intero passato come argomento
    public Console findConsoleById(int id) {
        TypedQuery<Console> query = em.createNamedQuery(Console.FIND_BY_ID, Console.class);
        query.setParameter("id", id); //parameters by name 
        return query.getSingleResult();
    }
    
    //Restituisce la console avente come modello la stringa passata come argomento
    public Console retriveByModello(String modello) {
        TypedQuery<Console> query = em.createNamedQuery(Console.FIND_BY_MODELLO, Console.class);
        query.setParameter("modello", modello); //parameters by name 
        return query.getSingleResult();
    }
    
    //Restituisce la lista di console aventi come casa produttrice la stringa passata come argomento
    public List<Console> retriveByCasaProduttrice(String casaProduttrice) {
        TypedQuery<Console> query = em.createNamedQuery(Console.FIND_BY_CASAPRODUTTRICE, Console.class);
        query.setParameter("casaProduttrice", casaProduttrice); //parameters by name 
        return query.getResultList();
    }
    
    //Restituisce una lista limitata di console comprese tra i valori "min" e "max" passati come argomento
    public List<Console> doRetriveConsoleAllRange(int min, int max)
    {
    	TypedQuery<Console> query = em.createNamedQuery(Console.FIND_ALL, Console.class);
    	query.setFirstResult(min);
    	query.setMaxResults(max);
        return query.getResultList();
    }
    
}

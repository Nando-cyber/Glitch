package model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



@Stateless
@LocalBean
public class ConsoleJPA extends ProdottoJPA implements ConsoleDAO{
	
	@Inject
	private EntityManager em;
	

    //Restituisce una lista di tutti i videogiochi presenti nel database
    public List<Console> findAllConsole() {
        TypedQuery<Console> query = em.createNamedQuery(Console.FIND_ALL, Console.class);
        return query.getResultList();
    }

    //restituisce il videogioco che ha come id l'intero passato come parametro
    public Console findConsoleById(int id) {
        TypedQuery<Console> query = em.createNamedQuery(Console.FIND_BYID, Console.class);
        query.setParameter("id", id); //parameters by name 
        return query.getSingleResult();
    }
    
    //Restituisce una lista di videogiochi compresi tra i valori "min" e "max" passati come parametri
    public List<Console> doRetriveConsoleAllRange(int min, int max)
    {
    	TypedQuery<Console> query = em.createNamedQuery(Console.FIND_ALL, Console.class);
    	query.setFirstResult(min);
    	query.setMaxResults(max);
        return query.getResultList();
    }
    
}

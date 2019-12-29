package com.example.demo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


@WebService
@Stateless
@LocalBean
public class ConsoleJPA implements ConsoleDAO{
	
	@Inject
	private EntityManager em;
	
	
	//Aggiunge un videogioco (passato come parametro) al database
	public void addConsole(Console l)
	{
		em.persist(l);
	}
	
	//Rimuove un videogioco (passato come parametro) dal database
	public void removeConsole(Console l)
	{
		em.remove(em.merge(l));
	}
	
	//Aggiorna le informazioni di un videogioco (passato come parametro) nel database
    public void updateConsole(Console l) {
        em.merge(l); 
    }


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

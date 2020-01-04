package model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class OrdineJPA implements OrdineDAO{

	@Inject
	private EntityManager em;


	//Rende persistente un ordine
	public void createOrdine(Ordine ord) {
		
		em.persist(ord);
		
	}
	
	//Restituisce l'ordine avente per id l'intero passato come argomento
	public Ordine retriveById(long id)
	{
		TypedQuery<Ordine> query = em.createNamedQuery(Ordine.FIND_BY_ID, Ordine.class);
        query.setParameter("id", id); //parameters by name 
        return query.getSingleResult();
	}

	//Restituisce la lista di ordini effettuati dall'utente avente come username la stringa passata come argomento
	public List<Ordine> retriveByUtente(String user) {
        TypedQuery<Ordine> query = em.createNamedQuery(Ordine.FIND_BY_USERNAME, Ordine.class);
        query.setParameter("username", user); //parameters by name 
        return query.getResultList();
    }
	
}

package model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class RichiestaJPA implements RichiestaDAO{

	@Inject
	private EntityManager em;

	//Rende persistente una richiesta "rc"
	public void createRichiesta(Richiesta rc)
	{
		em.persist(rc);
	}
	
	//Rimuove una richiesta avente per id l'intero passato come argomento
	public void deleteRichiesta(int id)
	{
		Richiesta daCanc=retriveById(id);
		em.remove(em.merge(daCanc));
	}
	
	//Restituisce una lista di richieste avente come mittente l'email dell'utente passato come argomento
	public List<Richiesta> retriveByMittente(String email) {
		
		TypedQuery<Richiesta> query = em.createNamedQuery(Richiesta.FIND_BY_EMAIL_MITTENTE, Richiesta.class);
        query.setParameter("email", email); //parameters by name 
        return query.getResultList();
	}

	//Restituisce una richiesta avente per id l'intero passato come argomento
	public Richiesta retriveById(int id) {
		
		TypedQuery<Richiesta> query = em.createNamedQuery(Richiesta.FIND_BY_ID, Richiesta.class);
        query.setParameter("id", id); //parameters by name 
        return query.getSingleResult();
	}
	
}

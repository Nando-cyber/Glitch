package model.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.bean.Utente;

@Stateless
@LocalBean
public class UtenteJPA implements UtenteDAO{

	@Inject
	private EntityManager em;

	//Rende persistente l'utente "u" passato come argomento
	public void createUtente(Utente u)
	{
		em.persist(u);
	}
	
	//Rimuove l'utente, avente come username la stringa passata come argomento, dal database
	public void deleteUtente(String user)
	{
		Utente daCanc=retriveByUsername(user);
		em.remove(em.merge(daCanc));
	}
	
	//Aggiorna l'utente "u" nel database
	public Utente updateUtente(Utente u)
	{
		em.merge(u);
		return u;
	}
	
	//Restituisce l'utente avente come username la stringa passata come argomento
	public Utente retriveByUsername(String user) {
		
		TypedQuery<Utente> query = em.createNamedQuery(Utente.FIND_BY_User, Utente.class);
        query.setParameter("username", user); //parameters by name 
        return query.getSingleResult();
	}
	
	//Restituisce l'utente avete come email la stringa passata come argomento
	public Utente retriveByEmail(String email) {
		
		TypedQuery<Utente> query = em.createNamedQuery(Utente.FIND_BY_Email, Utente.class);
        query.setParameter("email", email); //parameters by name 
        return query.getSingleResult();
	}
	
	//Restituisce la lista degli utenti presenti nel database
	public List<Utente> retriveAllUtenti()
	{
		TypedQuery<Utente> query = em.createNamedQuery(Utente.FIND_ALL, Utente.class);
        return query.getResultList();
	}
	
}

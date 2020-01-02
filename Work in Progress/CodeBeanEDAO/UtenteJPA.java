package model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class UtenteJPA implements UtenteDAO{

	@Inject
	private EntityManager em;

	
	public void createUtente(Utente u)
	{
		em.persist(u);
	}
	
	public void deleteUtente(String user)
	{
		Utente daCanc=retriveByUsername(user);
		em.remove(em.merge(daCanc));
	}
	
	public Utente updateUtente(Utente u)
	{
		em.merge(u);
		return u;
	}
	
	//permette di cercare un prodotto per id
	public Utente retriveByUsername(String user) {
		
		TypedQuery<Utente> query = em.createNamedQuery(Utente.FIND_BY_User, Utente.class);
        query.setParameter("username", user); //parameters by name 
        return query.getSingleResult();
	}
	
	public Utente retriveByEmail(String email) {
		
		TypedQuery<Utente> query = em.createNamedQuery(Utente.FIND_BY_Email, Utente.class);
        query.setParameter("email", email); //parameters by name 
        return query.getSingleResult();
	}
	
}

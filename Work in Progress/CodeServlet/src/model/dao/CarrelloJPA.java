package model.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.bean.Carrello;

@Stateless
@LocalBean
public class CarrelloJPA implements CarrelloDAO{

	@Inject
	private EntityManager em;
	
	//Rende persistente il carrello "cart"
	public void createCarrello(Carrello cart) {
		
		em.persist(cart);
		
	}
	
	//Rimuove il carrello dell'utente con username "user" dal DataBase
	public void removeCarrello(String user) {
		
		em.remove(em.merge(retriveByUtente(user)));
		
	}
	
	//Restituisce il carrello del utente avente come username "user"
	public Carrello retriveByUtente(String user) {
		TypedQuery<Carrello> query = em.createNamedQuery(Carrello.FIND_BY_UTENTE, Carrello.class);
        query.setParameter("utenteUsername", user); //parameters by name 
        return query.getSingleResult();
	}

	//Rende persistenti gli aggiornamenti sul carrello
	public void updateCarrello(Carrello cart) {
		em.merge(cart);
		
	}
	
}

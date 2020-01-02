package model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class ProdottoJPA implements ProdottoDAO{

	@Inject
	private EntityManager em;
	
	//Rende persistente un prodotto "pr" passato come argomento
	public void createProdotto(Prodotto pr) {
		
		em.persist(pr);
		
	}
	
	//Rimuove un prodotto "pr" dal database
	public void removeProdotto(Prodotto pr) {
		
		em.remove(em.merge(pr));
		
	}
	
	//Restituisce un prodotto avente come id l'intero passato come argomento
	public Prodotto findProdottoById(int id) {
		
		TypedQuery<Prodotto> query = em.createNamedQuery(Prodotto.FIND_BY_ID, Prodotto.class);
        query.setParameter("id", id); //parameters by name 
        return query.getSingleResult();
	}

}

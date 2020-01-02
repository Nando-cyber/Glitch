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
	
	//permette di aggiungere un prodotto al DB
	@Override
	public void addProdotto(Prodotto l) {
		
		em.persist(l);
		
	}
	
	//permette di rimuovere un prodotto da DB
	@Override
	public void removeProdotto(Prodotto l) {
		
		em.remove(em.merge(l));
		
	}
	
	//permette di cercare un prodotto per id
	@Override
	public Prodotto findProdottoById(int id) {
		
		TypedQuery<Prodotto> query = em.createNamedQuery(Prodotto.FIND_BYID, Prodotto.class);
        query.setParameter("id", id); //parameters by name 
        return query.getSingleResult();
	}

}

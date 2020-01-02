package model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class CartaDiCreditoJPA {

	@Inject
	private EntityManager em;

	
	public void createCartaDiCredito(CartaDiCredito cdc)
	{
		em.persist(cdc);
	}
	
	public void deleteRichiesta(int numCarta)
	{
		CartaDiCredito daCanc=retriveByNumCarta(numCarta);
		em.remove(em.merge(daCanc));
	}
	

	public CartaDiCredito retriveByNumCarta(int numCarta) {
		
		TypedQuery<CartaDiCredito> query = em.createNamedQuery(CartaDiCredito.FIND_BY_NUMCARTA, CartaDiCredito.class);
        query.setParameter("numeroCarta", numCarta); //parameters by name 
        return query.getSingleResult();
	}
	
	public List<CartaDiCredito> retriveByUtente(String user) {
		
		TypedQuery<CartaDiCredito> query = em.createNamedQuery(CartaDiCredito.FIND_BY_UTENTE, CartaDiCredito.class);
        query.setParameter("user", user); //parameters by name 
        return query.getResultList();
	}
	
}

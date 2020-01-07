package model.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.bean.CartaDiCredito;

@Stateless
@LocalBean
public class CartaDiCreditoJPA implements CartaDiCreditoDAO{

	@Inject
	private EntityManager em;

	//Rende persistente la carta di credito "cdc"
	public void createCartaDiCredito(CartaDiCredito cdc)
	{
		em.persist(cdc);
	}
	
	//Rimuove la carta di credito avente "numCarta" come numero identificativo dal DB
	public void deleteRichiesta(int numCarta)
	{
		CartaDiCredito daCanc=retriveByNumCarta(numCarta);
		em.remove(em.merge(daCanc));
	}
	
	//Restituisce la carta di credito avente "numCarta" come numero identificativo della carta
	public CartaDiCredito retriveByNumCarta(int numCarta) {
		TypedQuery<CartaDiCredito> query = em.createNamedQuery(CartaDiCredito.FIND_BY_NUMCARTA, CartaDiCredito.class);
        query.setParameter("numeroCarta", numCarta); //parameters by name 
        return query.getSingleResult();
	}
	
	//Restituisce la lista di carte di credito associate all'utente avente come username "user" 
	public List<CartaDiCredito> retriveByUtente(String user) {
		TypedQuery<CartaDiCredito> query = em.createNamedQuery(CartaDiCredito.FIND_BY_UTENTE, CartaDiCredito.class);
        query.setParameter("user", user); //parameters by name 
        return query.getResultList();
	}
	
}

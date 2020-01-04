package model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class OffertaJPA implements OffertaDAO{

	@Inject
	private EntityManager em;

	//Rende l'offerta "off" (passata come parametro) persistente
	public void createOfferta(Offerta off) {
		
		em.persist(off);
		
	}
	
	//Rimuove l'offerta avente come id l'intero passato come argomento, dal database
	public void deleteOfferta(int id)
	{
		em.remove(em.merge(retriveOffertaById(id)));
	}
	
	//Restituisce l'offerta avente come id l'intero passato come argomento
	public Offerta retriveOffertaById(int id) {
        TypedQuery<Offerta> query = em.createNamedQuery(Offerta.FIND_BY_CODICE, Offerta.class);
        query.setParameter("codice", id); //parameters by name 
        return query.getSingleResult();
    }
	
	//Restituisce la lista di offerte associate ad una categoria passata come argomento
	public List<Offerta> retriveByCategoria(String categoria) {
        TypedQuery<Offerta> query = em.createNamedQuery(Offerta.FIND_BY_CATEGORIA, Offerta.class);
        query.setParameter("categoria", categoria); //parameters by name 
        return query.getResultList();
    }
	
}

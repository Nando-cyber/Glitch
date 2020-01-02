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


	public void createOfferta(Offerta off) {
		
		em.persist(off);
		
	}
	
	public void deleteOfferta(int id)
	{
		em.remove(em.merge(retriveOffertaById(id)));
	}
	
	public Offerta retriveOffertaById(int id) {
        TypedQuery<Offerta> query = em.createNamedQuery(Offerta.FIND_BY_CODICE, Offerta.class);
        query.setParameter("codice", id); //parameters by name 
        return query.getSingleResult();
    }
	
	public List<Offerta> retriveByCategoria(String categoria) {
        TypedQuery<Offerta> query = em.createNamedQuery(Offerta.FIND_BY_CATEGORIA, Offerta.class);
        query.setParameter("categoria", categoria); //parameters by name 
        return query.getResultList();
    }
	
}

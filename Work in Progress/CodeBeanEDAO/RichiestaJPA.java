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

	
	public void createRichiesta(Richiesta rc)
	{
		em.persist(rc);
	}
	
	public void deleteRichiesta(int id)
	{
		Richiesta daCanc=retriveById(id);
		em.remove(em.merge(daCanc));
	}
	
	
	public List<Richiesta> retriveByMittente(String email) {
		
		TypedQuery<Richiesta> query = em.createNamedQuery(Richiesta.FIND_BY_EMAIL_MITTENTE, Richiesta.class);
        query.setParameter("email", email); //parameters by name 
        return query.getResultList();
	}

	public Richiesta retriveById(int id) {
		
		TypedQuery<Richiesta> query = em.createNamedQuery(Richiesta.FIND_BY_ID, Richiesta.class);
        query.setParameter("id", id); //parameters by name 
        return query.getSingleResult();
	}
	
}

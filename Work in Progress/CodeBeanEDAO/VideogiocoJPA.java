package model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


@Stateless
@LocalBean
public class VideogiocoJPA extends ProdottoJPA implements VideogiocoDAO {

	@Inject
	private EntityManager em;


    //Restituisce una lista di tutti i videogiochi presenti nel database
    public List<Videogioco> findAllVideogioco() {
        TypedQuery<Videogioco> query = em.createNamedQuery(Videogioco.FIND_ALL, Videogioco.class);
        return query.getResultList();
    }

    //restituisce il videogioco che ha come id l'intero passato come parametro
    public Videogioco findVideogiocoById(int id) {
        TypedQuery<Videogioco> query = em.createNamedQuery(Videogioco.FIND_BYID, Videogioco.class);
        query.setParameter("id", id); //parameters by name 
        return query.getSingleResult();
    }
    
    //Restituisce una lista di videogiochi compresi tra i valori "min" e "max" passati come parametri
    public List<Videogioco> doRetriveVideogiocoAllRange(int min, int max)
    {
    	TypedQuery<Videogioco> query = em.createNamedQuery(Videogioco.FIND_ALL, Videogioco.class);
    	query.setFirstResult(min);
    	query.setMaxResults(max);
        return query.getResultList();
    }
    
    
	
}

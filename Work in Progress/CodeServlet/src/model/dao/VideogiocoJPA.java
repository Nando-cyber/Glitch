package model.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.bean.Videogioco;


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
    
    //Restituisce una lista limitata di videogiochi compresi tra i valori "min" e "max" passati come parametri
    public List<Videogioco> doRetriveVideogiocoAllRange(int min, int max)
    {
    	TypedQuery<Videogioco> query = em.createNamedQuery(Videogioco.FIND_ALL, Videogioco.class);
    	query.setFirstResult(min);
    	query.setMaxResults(max);
        return query.getResultList();
    }
    
    //Restitusce una lista di videogiochi avente come nome la stringa passata come argomento
    public List<Videogioco> retriveByNome(String nome) {
        TypedQuery<Videogioco> query = em.createNamedQuery(Videogioco.FIND_BY_NOME, Videogioco.class);
        query.setParameter("nome", nome); //parameters by name 
        return query.getResultList();
    }
    
    //Restitusce una lista di videogiochi avente come genere la stringa passata come argomento
    public List<Videogioco> retriveByGenere(String genere) {
        TypedQuery<Videogioco> query = em.createNamedQuery(Videogioco.FIND_BY_GENERE, Videogioco.class);
        query.setParameter("genere", genere); //parameters by name 
        return query.getResultList();
    }
    
    //Restitusce una lista di videogiochi avente come piattaforma la stringa passata come argomento
    public List<Videogioco> retriveByPiattaforma(String piattaforma) {
        TypedQuery<Videogioco> query = em.createNamedQuery(Videogioco.FIND_BY_PIATTAFORMA, Videogioco.class);
        query.setParameter("piattaforma", piattaforma); //parameters by name 
        return query.getResultList();
    }
	
}

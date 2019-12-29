package com.example.demo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@WebService
@Stateless
@LocalBean
public class VideoDAO implements VideogiocoRemote{

	@Inject
	private EntityManager em;
	
	
	//Aggiunge un videogioco (passato come parametro) al database
	public void addVideogioco(Videogioco l)
	{
		em.persist(l);
	}
	
	//Rimuove un videogioco (passato come parametro) dal database
	public void removeVideogioco(Videogioco l)
	{
		em.remove(em.merge(l));
	}
	
	//Aggiorna le informazioni di un videogioco (passato come parametro) nel database
    public void updateVideogioco(Videogioco l) {
        em.merge(l); 
    }


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
	
}

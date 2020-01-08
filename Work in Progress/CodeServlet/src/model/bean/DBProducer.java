package model.bean;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DBProducer {

	@Produces
	@PersistenceContext (unitName = "GLITCH_PU")
	private EntityManager em;
}

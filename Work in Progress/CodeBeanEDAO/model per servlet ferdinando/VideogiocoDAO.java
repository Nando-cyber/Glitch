package model;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface VideogiocoDAO extends ProdottoDAO{
	
	List<Videogioco> findAllVideogioco();
	List<Videogioco> doRetriveVideogiocoAllRange(int min, int max);
	
	
	
}

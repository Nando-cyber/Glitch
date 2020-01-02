package model;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RichiestaDAO{

	void createRichiesta(Richiesta rc);
	void deleteRichiesta(int id);
	List<Richiesta> retriveByMittente(String email);
	Richiesta retriveById(int id);
}

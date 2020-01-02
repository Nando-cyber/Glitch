package model;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface OffertaDAO {

	void createOfferta(Offerta off);
	void deleteOfferta(int id);
	Offerta retriveOffertaById(int id);
	List<Offerta> retriveByCategoria(String categoria);
	
}

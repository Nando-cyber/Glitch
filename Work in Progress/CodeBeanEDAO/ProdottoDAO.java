package model;

import javax.ejb.Remote;

@Remote
public interface ProdottoDAO {

	void addProdotto(Prodotto l);
	void removeProdotto(Prodotto l);
	Prodotto findProdottoById(int id);
}

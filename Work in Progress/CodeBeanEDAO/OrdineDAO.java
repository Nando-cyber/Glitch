package model;

import java.util.List;

public interface OrdineDAO {

	void createOrdine(Ordine ord);
	List<Ordine> retriveByUtente(String user);
}

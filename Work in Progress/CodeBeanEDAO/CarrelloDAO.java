package model;

public interface CarrelloDAO {

	void createCarrello(Carrello cart);
	void updateCarrello(Carrello cart);
	void removeCarrello(String user);
	Carrello retriveByUtente(String user);
}

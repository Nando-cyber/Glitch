package model;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CartaDiCreditoDAO{
	
	void createCartaDiCredito(CartaDiCredito cdc);
	void deleteRichiesta(int numCarta);
	CartaDiCredito retriveByNumCarta(int numCarta);
	public List<CartaDiCredito> retriveByUtente(String user);

}

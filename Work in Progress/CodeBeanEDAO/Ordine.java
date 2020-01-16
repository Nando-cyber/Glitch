package model.bean;



import java.util.ArrayList;


public class Ordine{


	
	private String username;
	
	private ArrayList<ProdottiOrdine> prodottiAcquistati;
	
	//Costruttore vuoto
	public Ordine() {
	}
	
	//Costruisce l'oggetto "Ordine" passando l'username dell'utente, l'email e il suo carrello
	public Ordine(String username, ArrayList<ProdottiOrdine> prodottiAcquistati)
	{
		this.setUsername(username);
		this.setProdottiAcquistati(prodottiAcquistati);
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<ProdottiOrdine> getProdottiAcquistati() {
		return prodottiAcquistati;
	}

	public void setProdottiAcquistati(ArrayList<ProdottiOrdine> prodottiAcquistati) {
		this.prodottiAcquistati = prodottiAcquistati;
	}
	
	
	


}

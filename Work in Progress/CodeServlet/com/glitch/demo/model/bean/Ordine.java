package com.glitch.demo.model.bean;



import java.util.ArrayList;


public class Ordine{


	
	private String utenteUsername;
	private int ordineId;
	private ArrayList<ProdottiOrdine> prodottiAcquistati;
	
	//Costruttore vuoto
	public Ordine() {
	}
	
	//Costruisce l'oggetto "Ordine" passando come argomento l'id ordine, l'username e la lista di prodotti acquistati
	public Ordine(int ordineId, String utenteUsername, ArrayList<ProdottiOrdine> prodottiAcquistati)
	{
		this.setOrdineId(ordineId);
		this.setUtenteUsername(utenteUsername);
		this.setProdottiAcquistati(prodottiAcquistati);
		
	}

	//Costruisce l'oggetto ordine passando come argomento l'id ordine
	public Ordine(int ordineId)
	{
		this.ordineId=ordineId;
	}
	
	//Restituisce la lista dei prodotti acquistati
	public ArrayList<ProdottiOrdine> getProdottiAcquistati() {
		return prodottiAcquistati;
	}

	//Modifica la lista dei prodotti acquistati
	public void setProdottiAcquistati(ArrayList<ProdottiOrdine> prodottiAcquistati) {
		this.prodottiAcquistati = prodottiAcquistati;
	}

	//Restituisce l'id dell'ordine
	public int getOrdineId() {
		return ordineId;
	}

	//Modifica l'id dell'ordine
	public void setOrdineId(int ordineId) {
		this.ordineId = ordineId;
	}

	//Restituisce l'username associato all'ordine
	public String getUtenteUsername() {
		return utenteUsername;
	}

	//Modifica l'username associato all'ordine
	public void setUtenteUsername(String utenteUsername) {
		this.utenteUsername = utenteUsername;
	}
	
	
	


}

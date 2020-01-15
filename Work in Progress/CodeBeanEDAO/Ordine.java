package model.bean;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Ordine{


	
	private String username;
	private String email;
	private GregorianCalendar dataOrdinazione;	
	private float prezzoTot;
	private ArrayList<ProdottiOrdine> prodottiAcquistati;
	
	//Costruttore vuoto
	public Ordine() {
	}
	
	//Costruisce l'oggetto "Ordine" passando l'username dell'utente, l'email e il suo carrello
	public Ordine(String username, String email, Date dataOrdinazione, float prezzoTot,ArrayList<ProdottiOrdine> prodottiAcquistati)
	{
		this.username=username;
		this.email=email;
		this.dataOrdinazione.setTime(dataOrdinazione);
		this.prezzoTot=prezzoTot;
		this.prodottiAcquistati=prodottiAcquistati;
		
	}
	
	//Restituisce l'id dell'ordine
	public int getId()
	{
		return id;
	}

	//Restituisce la data dell'ordine effettuato
	public GregorianCalendar getDataOrdinazione() {
		return dataOrdinazione;
	}

	//Modifica la data dell'ordine effettuato
	public void setDataOrdinazione(GregorianCalendar dataOrdinazione) {
		this.dataOrdinazione = dataOrdinazione;
	}

	//Restituisce la collezione di prodotti acquistati con le loro quantità
	public Collection<ProdottoQuantita> getProdottiAcquistati() {
		return prodottiAcquistati;
	}

	//Permette la modifica dei prodotti acquistati con le relative quantità
	public void setProdottiAcquistati(Collection<ProdottoQuantita> prodottiAcquistati) {
		this.prodottiAcquistati = prodottiAcquistati;
	}

	public float getPrezzoTot() {
		return this.prezzoTot;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}

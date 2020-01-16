package model.bean;

import java.sql.Date;
import java.util.GregorianCalendar;


public class ProdottiOrdine {

	
	private String utenteUsername;
	private String utenteEmail;
	private String nome;
	private int quantita;
	private float prezzo;
	private GregorianCalendar dataOrdinazione;
	
	//Costruttore vuoto
	public ProdottiOrdine()
	{}
	
	//Costruisce ProdottiOrdine passando per argomento l'username dell'utente, l'email, il nome del prodotto, la quantità, il prezzo e la data di ordinazione
	public ProdottiOrdine(String utenteUsername, String utenteEmail, String nome, int quantita, float prezzo, Date dataOrdinazione)
	{
		
		this.setUtenteUsername(utenteUsername);
		this.setUtenteEmail(utenteEmail);
		this.setNome(nome);
		this.setQuantita(quantita);
		this.setPrezzo(prezzo);
		this.dataOrdinazione.setTime(dataOrdinazione);
	}
	
	//Restituisce la data di ordinazione sotto forma di oggetto "Date"
	public Date getDataOrdinazioneDate()
	{
		return (Date) dataOrdinazione.getTime();
	}
	
	//Modifica la data di ordinazione passando per argomento un oggetto "Date" contenente la nuova data
	public void setDataOrdinazioneDate(Date ord)
	{
		dataOrdinazione.setTime(ord);
	}

	//Restituisce l'email dell'utente associato al prodotto acquistato
	public String getUtenteEmail() {
		return utenteEmail;
	}

	//Modifica l'email dell'utente associato al prodotto acquistato
	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
	}

	//Restituisce il nome del prodotto acquistato
	public String getNome() {
		return nome;
	}

	//Modifica il nome del prodotto acquistato
	public void setNome(String nome) {
		this.nome = nome;
	}

	//Restituisce il prezzo del prodotto acquistato
	public float getPrezzo() {
		return prezzo;
	}

	//Modifica il prezzo del prodotto acquistato
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	//Restituisce la quantità del prodotto acquistato
	public int getQuantita() {
		return quantita;
	}

	//Modifica la quantita del prodotto acquistato
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	//Restituisce l'username dell'utente associato al prodotto acquistato
	public String getUtenteUsername() {
		return utenteUsername;
	}

	//Modifica l'username dell'utente associato al prodotto acquistato
	public void setUtenteUsername(String utenteUsername) {
		this.utenteUsername = utenteUsername;
	}

	//Restituisce la data di ordinazione sotto forma di "GregorianCalendar"
	public GregorianCalendar getDataOrdinazione() {
		return dataOrdinazione;
	}

	//Modifica la data di ordinazione passando un oggetto "GregorianCalendar"
	public void setDataOrdinazione(GregorianCalendar dataOrdinazione) {
		this.dataOrdinazione = dataOrdinazione;
	}

	
	
	
	
}

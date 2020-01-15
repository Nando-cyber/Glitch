package model.bean;

import java.sql.Date;
import java.util.GregorianCalendar;


public class ProdottiOrdine {

	private int ordineId;
	private String utenteUsername;
	private String utenteEmail;
	private String nome;
	private int quantita;
	private float prezzo;
	private GregorianCalendar dataOrdinazione;
	
	public ProdottiOrdine()
	{}
	
	public ProdottiOrdine(int ordineId, String utenteUsername, String utenteEmail, String nome, float prezzo, Date dataOrdinazione)
	{
		this.setOrdineId(ordineId);
		this.setUtenteUsername(utenteUsername);
		this.setUtenteEmail(utenteEmail);
		this.setNome(nome);
		this.setPrezzo(prezzo);
		this.dataOrdinazione.setTime(dataOrdinazione);
	}
	
	

	public String getUtenteEmail() {
		return utenteEmail;
	}

	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public int getOrdineId() {
		return ordineId;
	}

	public void setOrdineId(int ordineId) {
		this.ordineId = ordineId;
	}

	public String getUtenteUsername() {
		return utenteUsername;
	}

	public void setUtenteUsername(String utenteUsername) {
		this.utenteUsername = utenteUsername;
	}

	public GregorianCalendar getDataOrdinazione() {
		return dataOrdinazione;
	}

	public void setDataOrdinazione(GregorianCalendar dataOrdinazione) {
		this.dataOrdinazione = dataOrdinazione;
	}

	
	
	
	
}

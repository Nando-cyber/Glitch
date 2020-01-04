package model;


import static model.Ordine.FIND_BY_USERNAME;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = FIND_BY_USERNAME, query = "SELECT b FROM Ordine b WHERE b.username = :username")

public class Ordine {

	public static final String FIND_BY_USERNAME = "model.Ordine.FIND_BY_USERNAME";
	
	@Id
	private String username;
	@Id
	private String email;
	private Date dataOrdinazione= (Date) Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY).getTime();
	private Collection<ProdottoQuantita> prodottiAcquistati;
	
	public Ordine() {
	}
	
	public Ordine(String username, String email,Carrello cart)
	{
		this.username=username;
		this.email=email;
		this.setProdottiAcquistati(cart.getProdotti());

	}

	public Date getDataOrdinazione() {
		return dataOrdinazione;
	}

	public void setDataOrdinazione(Date dataOrdinazione) {
		this.dataOrdinazione = dataOrdinazione;
	}

	public Collection<ProdottoQuantita> getProdottiAcquistati() {
		return prodottiAcquistati;
	}

	public void setProdottiAcquistati(Collection<ProdottoQuantita> prodottiAcquistati) {
		this.prodottiAcquistati = prodottiAcquistati;
	}

	


}

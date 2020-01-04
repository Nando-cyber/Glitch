package model;


import static model.Ordine.FIND_BY_USERNAME;
import static model.Ordine.FIND_BY_ID;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
			@NamedQuery(name = FIND_BY_USERNAME, query = "SELECT b FROM Ordine b WHERE b.username = :username"),
			@NamedQuery(name = FIND_BY_ID, query = "SELECT b FROM Ordine b WHERE b.id = :id")
})

public class Ordine {

	public static final String FIND_BY_USERNAME = "model.Ordine.FIND_BY_USERNAME";
	public static final String FIND_BY_ID = "model.Ordine.FIND_BY_ID";
	
	@Id @GeneratedValue
	private long id;
	
	@Id
	private String username;
	@Id
	private String email;
	private Date dataOrdinazione= (Date) Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY).getTime();
	private Collection<ProdottoQuantita> prodottiAcquistati;
	
	//Costruttore vuoto
	public Ordine() {
	}
	
	//Costruisce l'oggetto "Ordine" passando l'username dell'utente, l'email e il suo carrello
	public Ordine(String username, String email,Carrello cart)
	{
		this.username=username;
		this.email=email;
		
		//Estrae i prodotti dal carrello e li memorizza nella collection "prodottiAcquistati"
		this.setProdottiAcquistati(cart.getProdotti());

	}
	
	//Restituisce l'id dell'ordine
	public Long getId()
	{
		return id;
	}

	//Restituisce la data dell'ordine effettuato
	public Date getDataOrdinazione() {
		return dataOrdinazione;
	}

	//Modifica la data dell'ordine effettuato
	public void setDataOrdinazione(Date dataOrdinazione) {
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

	


}

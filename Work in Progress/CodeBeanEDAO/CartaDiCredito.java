package model;

import static model.CartaDiCredito.FIND_BY_NUMCARTA;
import static model.CartaDiCredito.FIND_BY_UTENTE;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
        @NamedQuery(name = FIND_BY_NUMCARTA, query = "SELECT b FROM CartaDiCredito b WHERE b.numeroCarta = :numeroCarta"),
        @NamedQuery(name = FIND_BY_UTENTE, query = "SELECT b FROM CartaDiCredito b WHERE b.utenteUsername = :user")
      
})
public class CartaDiCredito {

	public static final String FIND_BY_NUMCARTA = "model.CartaDiCredito.FIND_BY_NUMCARTA";
	public static final String FIND_BY_UTENTE = "model.CartaDiCredito.FIND_BY_UTENTE";
	
	
	@Id
	private int numeroCarta;
	@Id
	private String utenteUsername;
	@Id
	private String utenteEmail;
	private String nome;
	private String cognome;
	private GregorianCalendar scadenza;
	private int cvv;
	
	//Costruttore vuoto
	public CartaDiCredito() {
	}
	
	//Costruisce una carta di credito passando come argomento il numero della carta, 
	//l'username dell'utente, l'email, nome, cognome, la scadenza e il cvv della carta di credito
	public CartaDiCredito(int numeroCarta,String utenteUsername,String utenteEmail, String nome, String cognome, GregorianCalendar scadenza, int cvv)
	{
		this.numeroCarta=numeroCarta;
		this.utenteUsername=utenteUsername;
		this.utenteEmail=utenteEmail;
		this.nome=nome;
		this.cognome=cognome;
		this.scadenza=scadenza;
		this.cvv=cvv;
	}

	//Restituisce l'username dell'utente associato alla carta di credito
	public String getUtenteUsername() {
		return utenteUsername;
	}
	//Modifica l'username dell'utente che ha inserito la carta
	public void setUtenteUsername(String username) {
		 this.utenteUsername = username;
	}
	//Restituisce il nome dell'utente che ha associato alla carta di credito
	public String getNome() {
		return nome;
	}

	//Modfifica il nome dell'utente associato alla carta
	public void setNome(String nome) {
		this.nome = nome;
	}

	//Restituisce la scadenza della carta di credito
	public GregorianCalendar getScadenza() {
		return scadenza;
	}

	//Modfifica la scadenza della carta di credito
	public void setScadenza(GregorianCalendar scadenza) {
		this.scadenza = scadenza;
	}

	//Restituisce il nome dell'utente associato alla carta di credito
	public String getCognome() {
		return cognome;
	}

	//Modfifica il cognome dell'utente associato alla carta di credito
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	//Restituisce il CVV della carta di credito
	public int getCvv() {
		return cvv;
	}

	//Modifica il CVV della carta di credito
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	//Restituisce l'email dell'utente associato alla carta di credito
	public String getUtenteEmail() {
		return utenteEmail;
	}
	
	//Modifica l'email dell'utente che ha associato alla carta di credito
	public void setUtenteEmail(String email) {
		this.utenteEmail = email;
	}

}

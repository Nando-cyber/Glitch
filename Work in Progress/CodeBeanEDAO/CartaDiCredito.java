package model;

import static model.CartaDiCredito.FIND_BY_NUMCARTA;
import static model.CartaDiCredito.FIND_BY_UTENTE;

import java.util.Date;

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
	private String utenteUsername;
	private String email;
	private String nome;
	private String cognome;
	private Date scadenza;
	private int cvv;
	
	public CartaDiCredito() {
	}
	
	public CartaDiCredito(int numeroCarta,String utenteUsername,String email, String nome, String cognome, Date scadenza, int cvv)
	{
		this.numeroCarta=numeroCarta;
		this.utenteUsername=utenteUsername;
		this.email=email;
		this.nome=nome;
		this.cognome=cognome;
		this.scadenza=scadenza;
		this.cvv=cvv;
		
		
	}

	public String getUtenteUsername() {
		return utenteUsername;
	}

	public void setUtenteUsername(String utenteUsername) {
		this.utenteUsername = utenteUsername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
}

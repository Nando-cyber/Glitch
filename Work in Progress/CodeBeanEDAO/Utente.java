package model;

import static model.Utente.FIND_ALL;
import static model.Utente.FIND_BY_User;
import static model.Utente.FIND_BY_Email;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.security.enterprise.credential.Password;


@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT x FROM Utente b"),
        @NamedQuery(name = FIND_BY_User, query = "SELECT b FROM Utente b WHERE b.username = :username"),
        @NamedQuery(name = FIND_BY_Email, query = "SELECT b FROM Utente b WHERE b.email = :email")
})
public class Utente {

	
	public static final String FIND_ALL = "model.Utente.FIND_ALL";
    public static final String FIND_BY_User = "model.Utente.FIND_BY_User";
    public static final String FIND_BY_Email = "model.Utente.FIND_BY_Email";
	private String username;
	private String email;
	private Password password;
	private String nome;
	private String cognome;
	private CartaDiCredito carta;
	private String provincia;
	private int cap;
	private String citta;
	private String via;
	private int numero;
	private String ruolo=null;
	
	public Utente() {}
	
	public Utente(String username, String email, Password password, String nome, String cognome, String provincia, int cap,String citta, String via, int numero)
	{
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setProvincia(provincia);
		this.setCap(cap);
		this.setCitta(citta);
		this.setVia(via);
		this.setNumero(numero);
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

	public Password getPassword()
	{
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta (String citta) {
		this.citta = citta;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public CartaDiCredito getCarta() {
		return carta;
	}

	public void setCarta(CartaDiCredito carta) {
		this.carta = carta;
	}
	
}

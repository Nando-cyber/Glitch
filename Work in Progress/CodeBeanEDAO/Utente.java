package model;

import static model.Utente.FIND_ALL;
import static model.Utente.FIND_BY_User;

import java.io.Serializable;
import java.util.ArrayList;

import static model.Utente.FIND_BY_Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.security.enterprise.credential.Password;


@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT x FROM Utente b"),
        @NamedQuery(name = FIND_BY_User, query = "SELECT b FROM Utente b WHERE b.username = :username"),
        @NamedQuery(name = FIND_BY_Email, query = "SELECT b FROM Utente b WHERE b.email = :email")
        
})
public class Utente implements Serializable{

	
	
	private static final long serialVersionUID = 9137639574472324144L;
	public static final String FIND_ALL = "model.Utente.FIND_ALL";
    public static final String FIND_BY_User = "model.Utente.FIND_BY_User";
    public static final String FIND_BY_Email = "model.Utente.FIND_BY_Email";
    
    @Id
    @Column(name="username", nullable=false, length=10)
	private String username;
    @Id
    @Column(name="email", nullable=false)
	private String email;
    
    @Column(name="cartaDiCredito", nullable=true)
    private CartaDiCredito cartaDiCredito;
    
    @Column(name="password", nullable=false, length=15)
	private Password password;
    
    @Column(name="nome", nullable=false)
	private String nome;
    
    @Column(name="cognome", nullable=false)
	private String cognome;
    
    @Column(name="provincia", nullable=false)
	private String provincia;
    
    @Column(name="cap", nullable=false)
	private int cap;
    
    @Column(name="citta", nullable=false)
	private String citta;
    
    @Column(name="via", nullable=false)
	private String via;
    
    @Column(name="numero", nullable=false)
	private int numero;
    
    @Column(name="ruolo", nullable=true)
	private ArrayList<String> ruolo;
	
	//Costruttore vuoto
	public Utente() {}
	
	//Costruisce l'obj "Utente" passando come argomento il suo username, email, password, nome, cognome,provincia,cap,citta,via e numero civico
	public Utente(String username, String email, Password password, String nome, String cognome, String provincia, int cap,String citta, String via, int numero)
	{
		this.username=username;
		this.email=email;
		this.password=password;
		this.nome=nome;
		this.cognome=cognome;
		this.provincia=provincia;
		this.cap=cap;
		this.citta=citta;
		this.via=via;
		this.numero=numero;
	}

	//Restituisce l'username dell'utente
	public String getUsername() {
		return username;
	}

	//Modifica l'username dell'utente
	public void setUsername(String username) {
		this.username = username;
	}

	//Restituisce l'email dell'utente
	public String getEmail() {
		return email;
	}

	//Modifica l'email dell'utente
	public void setEmail(String email) {
		this.email = email;
	}

	//Restituisce la password dell'utente
	public Password getPassword()
	{
		return password;
	}

	//Modifica la password dell'utente
	public void setPassword(Password password) {
		this.password = password;
	}

	//Restituisce il nome dell'utente
	public String getNome() {
		return nome;
	}

	//Modifica il nome dell'utente
	public void setNome(String nome) {
		this.nome = nome;
	}

	//Restituisce la provincia dell'utente
	public String getProvincia() {
		return provincia;
	}

	//Modifica la provincia dell'utente
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	//Restituisce il cognome dell'utente
	public String getCognome() {
		return cognome;
	}

	//Modifica il cognome dell'utente
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	//Restituisce il cap dell'utente
	public int getCap() {
		return cap;
	}

	//Modifica il cap dell'utente
	public void setCap(int cap) {
		this.cap = cap;
	}

	//Restituisce il numero civico dell'utente
	public int getNumero() {
		return numero;
	}

	//Modifica il numero civico dell'utente
	public void setNumero(int numero) {
		this.numero = numero;
	}

	//Restituisce la città dell'utente
	public String getCitta() {
		return citta;
	}

	//Modifica la città dell'utente
	public void setCitta (String citta) {
		this.citta = citta;
	}

	//Restituisce la via dell'utente
	public String getVia() {
		return via;
	}

	//Modifica la via dell'utente
	public void setVia(String via) {
		this.via = via;
	}

	//Restituisce la lista con i ruoli dell'utente
	public ArrayList<String> getRuolo() {
		return ruolo;
	}

	//Modifica il ruolo dell'utente, ritorna false se l'utente ha più di 3 ruoli o se è già presente quel ruolo in "utente"
	public Boolean setRuolo(String ruoloDaIns) {
		
		if(ruolo.size()>3)
		{
			return false;
		}
			
		else if (ruolo.contains(ruoloDaIns))
		{
			return false;
		}
			
		else{
			ruolo.add(ruoloDaIns);
			return true;
			}
	}
	
	//Rimuove il ruolo passato come argomento dalla lista di ruoli dell'utente
	public void removeRuolo(String ruoloDaRim)
	{
		ruolo.remove(ruoloDaRim);
	}

	//Restituisce la carta di credito dell'utente
	public CartaDiCredito getCartaDiCredito() {
		return cartaDiCredito;
	}

	//Modifica la via dell'utente
	public void setCartaDiCredito(CartaDiCredito cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}
	
}

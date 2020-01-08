package model;



import java.util.Collection;
import java.util.LinkedHashMap;

import static model.Carrello.FIND_BY_UTENTE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = FIND_BY_UTENTE, query = "SELECT b FROM Carrello b WHERE b.utenteUsername = :utenteUsername")

public class Carrello {

	public static final String FIND_BY_UTENTE = "model.Carrello.FIND_BY_UTENTE";
	
	
	@Id
	@Column(name="utenteUsername", nullable=false)
	private String utenteUsername;
	
	@Id
	@Column(name="utenteEmail", nullable=false)
	private String utenteEmail;
	
	
	@OneToMany
	private LinkedHashMap<Integer, ProdottoQuantita> prodotti = new LinkedHashMap<>();

	//Restituisce la Collection di prodotti nel carrello
	public Collection<ProdottoQuantita> getProdotti() {
		return prodotti.values();
	}

	//Restituisce un "prodottoQuantita" avente come id del prodotto "prodId" 
	public ProdottoQuantita get(int prodId) {
		return prodotti.get(prodId);
	}
	
	//Aggiorna la quantità del prodotto nel carrello
	public void updateQuantita(int prodId , int quantita) {
		ProdottoQuantita pr = prodotti.get(prodId);
		pr.setQuantita(quantita);
		prodotti.replace(prodId, pr);
		
	}

	//Inserisce un prodotto e la sua quantità nel carrello
	public void put(Prodotto prodotto, int quantita) {
		prodotti.put(prodotto.getId(), new ProdottoQuantita(prodotto, quantita,utenteUsername));
	}

	//Rimuove un prodotto avente "prodId" come id dal carrello
	public ProdottoQuantita remove(int prodId) {
		return prodotti.remove(prodId);
	}

	//Restituisce il prezzo totale(derivato dalla somma del prezzo del singolo prodotto moltiplicato per la sua quantità) dei prodotti nella collection 
	public String getPrezzoTotProdotti() {
		return String.format("%.2f", prodotti.values().stream().mapToDouble(p -> p.getPrezzoTot()).sum());
	}
	
	//Costruttore vuoto	
	public Carrello() {}
	
	//Costruisce un carrello passando l'username e l'email dell'utente
	public Carrello(String utenteUsername,String utenteEmail)
	{
		this.utenteUsername=utenteUsername;
		this.utenteEmail=utenteEmail;
		
	}
	
	//Restiuisce l'username dell'utente a cui è associato il carrello
	public String getUsername() {
		return utenteUsername;
	}
	

	//inserisce la username utente nel carrello
	public void setUsername(String utenteUsername) {
		this.utenteUsername = utenteUsername;
	}
	
	//inserisce l'email utente nel carrello
	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
	}

	//Restiuisce l'email dell'utente a cui è associato il carrello
	public String getUtenteEmail() {
		return utenteEmail;
	}
	
	//Controlla se il corrello esiste
	public boolean isEmpty() {
		if(utenteUsername.isEmpty()) {
			return true;
		}
		else return false;
	}
	
	
	

	
}

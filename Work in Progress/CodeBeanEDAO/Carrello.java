package model;



import java.util.Collection;
import java.util.LinkedHashMap;

import static model.Carrello.FIND_BY_UTENTE;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = FIND_BY_UTENTE, query = "SELECT b FROM Carrello b WHERE b.utenteUsername = :utenteUsername")

public class Carrello {

	public static final String FIND_BY_UTENTE = "model.Carrello.FIND_BY_UTENTE";
	
	@Id
	private String utenteUsername;
	@Id
	private String utenteEmail;
	
	
	private LinkedHashMap<Integer, ProdottoQuantita> prodotti = new LinkedHashMap<>();

	public Collection<ProdottoQuantita> getProdotti() {
		return prodotti.values();
	}

	public ProdottoQuantita get(int prodId) {
		return prodotti.get(prodId);
	}
	
	public void updateQuantita(int prodId , int quantita) {
		ProdottoQuantita pr = prodotti.get(prodId);
		pr.setQuantita(quantita);
		prodotti.replace(prodId, pr);
		
	}

	public void put(Prodotto prodotto, int quantita) {
		prodotti.put(prodotto.getId(), new ProdottoQuantita(prodotto, quantita));
	}

	public ProdottoQuantita remove(int prodId) {
		return prodotti.remove(prodId);
	}

	public String getPrezzoTotProdotti() {
		return String.format("%.2f", prodotti.values().stream().mapToDouble(p -> p.getPrezzoTot()).sum());
	}
	
		
	public Carrello() {}
	
	public Carrello(String utenteUsername)
	{
		this.utenteUsername=utenteUsername;
		
	}
	
	
	public String getUsername() {
		return utenteUsername;
	}
	
	//Controlla se un corrello esiste
	public boolean isEmpty() {
		if(utenteUsername.isEmpty()) {
			return true;
		}
		else return false;
	}
	
	
	

	
}

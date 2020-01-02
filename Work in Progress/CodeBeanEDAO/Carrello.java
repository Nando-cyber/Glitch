package model;



import java.util.Collection;
import java.util.LinkedHashMap;

import static model.Carrello.FIND_BY_UTENTE;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = FIND_BY_UTENTE, query = "SELECT b FROM Carrello b WHERE b.username = :username")

public class Carrello {

	public static final String FIND_BY_UTENTE = "model.Carrello.FIND_BY_UTENTE";
	
	@Id
	private String username;
	
	public static class ProdottoQuantita {
		private Prodotto prodotto;
		private int quantita;

		private ProdottoQuantita(Prodotto prodotto, int quantita) {
			this.prodotto = prodotto;
			this.quantita = quantita;
		}

		public int getQuantita() {
			return quantita;
		}

		public void setQuantita(int quantita) {
			this.quantita = quantita;
		}

		public Prodotto getProdotto() {
			return prodotto;
		}

		public double getPrezzoTot() {
			return quantita * prodotto.getPrezzo();
		}

	}
	
	private LinkedHashMap<Integer, ProdottoQuantita> prodotti = new LinkedHashMap<>();

	public Collection<ProdottoQuantita> getProdotti() {
		return prodotti.values();
	}

	public ProdottoQuantita get(int prodId) {
		return prodotti.get(prodId);
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
	
	public Carrello(String username)
	{
		this.username=username;
		
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	

	
}

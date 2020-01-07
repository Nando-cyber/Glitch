package model;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class ProdottoQuantita {
	
	@Id @GeneratedValue
	private long id;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private String utenteUsername;
	private Prodotto prodotto;
	private int quantita;

	public ProdottoQuantita(Prodotto prodotto, int quantita,String utenteUsername) {
		this.utenteUsername=utenteUsername;
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

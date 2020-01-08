package model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



public class ProdottoQuantita {
	
	@Id @GeneratedValue
	private long id;
	
	
	@Column(name="utenteUsername", nullable=false)
	private String utenteUsername;
	
	@Column(name="prodotto", nullable=false)
	private Prodotto prodotto;
	
	@Column(name="quantita", nullable=false)
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

	public String getUtenteUsername() {
		return utenteUsername;
	}

	public void setUtenteUsername(String utenteUsername) {
		this.utenteUsername = utenteUsername;
	}

}

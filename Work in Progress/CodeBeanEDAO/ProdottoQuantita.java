package model;

public class ProdottoQuantita {
	private Prodotto prodotto;
	private int quantita;

	public ProdottoQuantita(Prodotto prodotto, int quantita) {
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

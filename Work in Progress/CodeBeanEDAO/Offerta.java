package model;

public class Offerta {

	private int codice;
	private int sconto;
	private String categoria;
	
	public Offerta() {}
	
	public Offerta(int codice, int sconto,String categoria)
	{
		this.setCodice(codice);
		this.setSconto(sconto);
		this.setCategoria(categoria);
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}

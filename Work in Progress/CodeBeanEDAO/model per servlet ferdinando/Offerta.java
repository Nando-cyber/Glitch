package model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Offerta {

	@Id @GeneratedValue
	private int codice;
	private int sconto;
	private String categoria;
	
	public Offerta() {}
	
	public Offerta(int sconto,String categoria)
	{
		this.sconto = sconto;
		this.categoria = categoria;
	}

	public int getCodice() {
		return codice;
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

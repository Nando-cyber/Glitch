package com.example.demo;

import javax.persistence.Id;

public class Console extends Prodotto{

	private static final long serialVersionUID = 4476139777432739883L;
	
	@Id
	private int prodottoID;
	private String modello;
	private String casaProduttrice;
	
	public Console() {}
	
	public Console(int id,String immagine, double prezzo, String descrizione, int codiceOfferta,int prodottoID, String modello, String casaProduttrice)
	{
		super(id,immagine,prezzo,descrizione,codiceOfferta);
		this.prodottoID=prodottoID;
		this.setModello(modello);
		this.setCasaProduttrice(casaProduttrice);
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getCasaProduttrice() {
		return casaProduttrice;
	}

	public void setCasaProduttrice(String casaProduttrice) {
		this.casaProduttrice = casaProduttrice;
	}
	
	
	
}

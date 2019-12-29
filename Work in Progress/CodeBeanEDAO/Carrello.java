package com.example.demo;

public class Carrello {

	private int prodottoID;
	private String utenteUsername;
	private String utenteEmail;
	private int quantità;
	private double prezzoQuantità;
	
	public Carrello() {
		
	}
	
	public Carrello(int prodottoID, String utenteUsername, String utenteEmail, int quantità, double prezzoQuantità)
	{
		this.prodottoID=prodottoID;
		this.utenteUsername=utenteUsername;
		this.utenteEmail=utenteEmail;
		this.quantità=quantità;
		this.prezzoQuantità=prezzoQuantità;
		
	}
}

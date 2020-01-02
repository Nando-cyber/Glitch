package model;

public class Carrello {

	private int prodottoID;
	private String utenteUsername;
	private String utenteEmail;
	private int quantita;
	private double prezzoQuantita;
	
	public Carrello() {
		
	}
	
	public Carrello(int prodottoID, String utenteUsername, String utenteEmail, int quantita, double prezzoQuantita)
	{
		this.prodottoID=prodottoID;
		this.utenteUsername = utenteUsername;
		this.utenteEmail = utenteEmail;
		this.quantita = quantita;
		this.prezzoQuantita = prezzoQuantita;
		
	}
}

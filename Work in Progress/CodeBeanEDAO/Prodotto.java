package model.bean;



public class Prodotto{
	

	private int id;
	private String immagine;
	private float prezzo;
	private String descrizione;
	private int codiceOfferta;
	
	//Costruttore vuoto
	public Prodotto() {
	}
	
	//Costruisce un "Prodotto" passando come argomento il path dell'immagine, il prezzo e la descrizione
	public Prodotto(int id,String immagine, float prezzo, String descrizione,int codiceOfferta)
	{
		this.id=id;
		this.immagine=immagine;
		this.prezzo=prezzo;
		this.descrizione=descrizione;
		this.codiceOfferta=codiceOfferta;
	}
	
	//Restituisce l'id del prodotto
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	//Restituisce il path dell'immagine 
	public String getImmagine() {
		return immagine;
	}
	
	//Modifica il path dell'immagine
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	//Restituisce la descrizione del prodotto
	public String getDescrizione() {
		return descrizione;
	}
	
	//Modifica la descrizione del prodotto
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	//Restituisce il prezzo del prodotto
	public float getPrezzo() {
		return prezzo;
	}
	
	//Modifica il prezzo del prodotto
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getCodiceOfferta() {
		return codiceOfferta;
	}

	public void setCodiceOfferta(int codiceOfferta) {
		this.codiceOfferta = codiceOfferta;
	}
	
	
}

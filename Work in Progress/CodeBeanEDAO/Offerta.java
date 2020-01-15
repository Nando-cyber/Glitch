package model.bean;




public class Offerta{

	private int codice;
	private int sconto;
	private String categoria;
	private String nome;
	
    //Restituisce il nome dell'offerta
	public String getNome() {
		return nome;
	}
	
	//Modifica il nome dell'offerta
	public void setNome(String nome) {
		this.nome = nome;
	}

	//Costruttore vuoto
	public Offerta() {}
	
	//Costruisce un oggetto "offerta" passando come argomento il suo codice, lo sconto e la categoria
	public Offerta(int sconto,String categoria)
	{
		this.sconto=sconto;
		this.categoria=categoria;
	}

	//Restituisce il codice identificativo dell'offerta
	public int getCodice() {
		return codice;
	}

	//Restituisce il valore dello sconto
	public int getSconto() {
		return sconto;
	}

	//Modifica il valore dello sconto
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	//Restituisce la categoria a cui è applicato lo sconto
	public String getCategoria() {
		return categoria;
	}

	//Modifica la categoria a cui è applicato lo sconto
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}

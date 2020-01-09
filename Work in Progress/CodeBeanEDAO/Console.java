package model;

import static model.Console.FIND_ALL;
import static model.Console.FIND_BY_ID;
import static model.Console.FIND_BY_MODELLO;

import java.io.Serializable;

import static model.Console.FIND_BY_CASAPRODUTTRICE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT x FROM Console b"),
        @NamedQuery(name = FIND_BY_ID, query = "SELECT b FROM Console b WHERE b.id = :id"),
        @NamedQuery(name = FIND_BY_MODELLO, query = "SELECT b FROM Console b WHERE b.modello = :modello"),
        @NamedQuery(name = FIND_BY_CASAPRODUTTRICE, query = "SELECT b FROM Console b WHERE b.casaProduttrice = :casaProduttrice")
})
public class Console extends Prodotto{

	private static final long serialVersionUID = 4476139777432739883L;
	
	public static final String FIND_ALL = "model.Console.FIND_ALL";
    public static final String FIND_BY_ID = "model.Console.FIND_BYID";
    public static final String FIND_BY_MODELLO = "model.Console.FIND_BY_MODELLO";
    public static final String FIND_BY_CASAPRODUTTRICE = "model.Console.FIND_BY_CASAPRODUTTRICE";
	
    @Column(name="modello", nullable=false)
	private String modello;
    
    @Column(name="casaProduttrice", nullable=false)
	private String casaProduttrice;
	
	//Costruttore vuoto
	public Console() {}
	
	//Costruisce un oggetto "Console" passando come argomento il path dell'immagine,il prezzo, la descrizione, il modello e la casa produttrice	
	public Console(String immagine, double prezzo, String descrizione, String modello, String casaProduttrice)
	{
		super(immagine,prezzo,descrizione);
		this.setModello(modello);
		this.setCasaProduttrice(casaProduttrice);
	}

	//Restituisce il modello della console
	public String getModello() {
		return modello;
	}

	//Modifica il modello della console
	public void setModello(String modello) {
		this.modello = modello;
	}

	//Restituisce la casa produttrice della console
	public String getCasaProduttrice() {
		return casaProduttrice;
	}

	//modifica la casa produttrice della console
	public void setCasaProduttrice(String casaProduttrice) {
		this.casaProduttrice = casaProduttrice;
	}
	
	
	
}

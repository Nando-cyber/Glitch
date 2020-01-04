package model;

import static model.Console.FIND_ALL;
import static model.Console.FIND_BY_ID;
import static model.Console.FIND_BY_MODELLO;
import static model.Console.FIND_BY_CASAPRODUTTRICE;

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
	
    
	private String modello;
	private String casaProduttrice;
	
	public Console() {}
	
	public Console(String immagine, double prezzo, String descrizione, String modello, String casaProduttrice)
	{
		super(immagine,prezzo,descrizione);
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

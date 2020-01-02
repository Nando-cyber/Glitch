package model;

import static model.Console.FIND_ALL;
import static model.Console.FIND_BYID;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT x FROM Console b"),
        @NamedQuery(name = FIND_BYID, query = "SELECT b FROM Console b WHERE b.id = :id")
})
public class Console extends Prodotto{

	private static final long serialVersionUID = 4476139777432739883L;
	
	public static final String FIND_ALL = "model.Console.FIND_ALL";
    public static final String FIND_BYID = "model.Console.FIND_BYID";
	
	
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

package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static model.Prodotto.FIND_ALL;
import static model.Prodotto.FIND_BY_ID;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT b FROM Prodotto b"),
        @NamedQuery(name = FIND_BY_ID, query = "SELECT b FROM Libro b WHERE b.id = :id")
})
public class Prodotto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "model.Prodotto.FIND_ALL";
    public static final String FIND_BY_ID = "model.Prodotto.FINDBYID";
	
	
	@Id @GeneratedValue
	private Integer id;
	private String immagine;
	private double prezzo;
	private String descrizione;
	
	
	public Prodotto() {
	}
	
	public Prodotto(String immagine, double prezzo, String descrizione)
	{
		this.immagine=immagine;
		this.prezzo=prezzo;
		this.descrizione=descrizione;
	}
	
	
	public String getImmagine() {
		return immagine;
	}
	
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
}

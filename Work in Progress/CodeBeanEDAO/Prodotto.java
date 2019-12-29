package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static com.example.demo.Prodotto.FIND_ALL;
import static com.example.demo.Prodotto.FIND_BYID;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT b FROM Prodotto b"),
        @NamedQuery(name = FIND_BYID, query = "SELECT b FROM Libro b WHERE b.id = :id")
})
public class Prodotto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "com.example.demo.Prodotto.FIND_ALL";
    public static final String FIND_BYID = "com.example.demo.Prodotto.FINDBYID";
	
	
	@Id @GeneratedValue
	private Integer id;
	private String immagine;
	private double prezzo;
	private String descrizione;
	private Integer codiceOfferta;
	
	
	public Prodotto() {
	}
	
	public Prodotto(String immagine, double prezzo, String descrizione, int codiceOfferta)
	{
		this.immagine=immagine;
		this.prezzo=prezzo;
		this.descrizione=descrizione;
		this.codiceOfferta=codiceOfferta;
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
	
	public Integer getCodiceOfferta() {
		return codiceOfferta;
	}
	
	public void setCodiceOfferta(Integer codiceOfferta) {
		this.codiceOfferta = codiceOfferta;
	}
	
	
}

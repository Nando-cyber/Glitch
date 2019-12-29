package com.example.demo;

import static com.example.demo.Videogioco.FIND_ALL;
import static com.example.demo.Videogioco.FIND_BYID;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT x FROM Videogioco b"),
        @NamedQuery(name = FIND_BYID, query = "SELECT b FROM Videogioco b WHERE b.id = :id")
})

public class Videogioco extends Prodotto{


	private static final long serialVersionUID = -6046814043777851758L;
	
	public static final String FIND_ALL = "com.example.demo.Videogioco.FIND_ALL";
    public static final String FIND_BYID = "com.example.demo.Videogioco.FIND_BYID";
    
	
	private String nome;
	private String genere;
	private String piattaforma;
	
	public Videogioco() {}
	
	public Videogioco(String immagine, double prezzo, String descrizione, int codiceOfferta,String nome, String genere, String piattaforma)
	{
		super(immagine,prezzo,descrizione,codiceOfferta);
		this.setNome(nome);
		this.setGenere(genere);
		this.setPiattaforma(piattaforma);
	}

	
	public String getPiattaforma() {
		return piattaforma;
	}

	public void setPiattaforma(String piattaforma) {
		this.piattaforma = piattaforma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
}
package model;

import static model.Videogioco.FIND_ALL;
import static model.Videogioco.FIND_BYID;
import static model.Videogioco.FIND_BY_NOME;
import static model.Videogioco.FIND_BY_GENERE;
import static model.Videogioco.FIND_BY_PIATTAFORMA;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT x FROM Videogioco b"),
        @NamedQuery(name = FIND_BYID, query = "SELECT b FROM Videogioco b WHERE b.id = :id"),
        @NamedQuery(name = FIND_BY_NOME, query = "SELECT b FROM Videogioco b WHERE b.nome = :nome"),
        @NamedQuery(name = FIND_BY_GENERE, query = "SELECT b FROM Videogioco b WHERE b.genere = :genere"),
        @NamedQuery(name = FIND_BY_PIATTAFORMA, query = "SELECT b FROM Videogioco b WHERE b.piattaforma = :piattaforma")
})

public class Videogioco extends Prodotto{


	private static final long serialVersionUID = -6046814043777851758L;
	
	public static final String FIND_ALL = "model.Videogioco.FIND_ALL";
    public static final String FIND_BYID = "model.Videogioco.FIND_BYID";
    public static final String FIND_BY_NOME = "model.Videogioco.FIND_BY_NOME";
    public static final String FIND_BY_GENERE = "model.Videogioco.FIND_BY_GENERE";
    public static final String FIND_BY_PIATTAFORMA = "model.Videogioco.FIND_BY_PIATTAFORMA";

	
	private String nome;
	private String genere;
	private String piattaforma;
	
	//Costruttore vuoto
	public Videogioco() {}
	
	//Costruisce un obj "Videogioco" passando come argomento il path dell'immagine, il prezzo, la descrizione, il nome, il genere e la piattaforma
	public Videogioco(String immagine, double prezzo, String descrizione, String nome, String genere, String piattaforma)
	{
		super(immagine,prezzo,descrizione);
		this.setNome(nome);
		this.setGenere(genere);
		this.setPiattaforma(piattaforma);
	}

	//Restituisce la piattaforma del videogioco
	public String getPiattaforma() {
		return piattaforma;
	}

	//Modifica la piattaforma del videogioco
	public void setPiattaforma(String piattaforma) {
		this.piattaforma = piattaforma;
	}

	//Restituisce il nome del videogioco
	public String getNome() {
		return nome;
	}

	//Modifica il nome del videogioco
	public void setNome(String nome) {
		this.nome = nome;
	}

	//Restituisce il genere del videogioco
	public String getGenere() {
		return genere;
	}

	//Modifica il nome del videogioco
	public void setGenere(String genere) {
		this.genere = genere;
	}
}

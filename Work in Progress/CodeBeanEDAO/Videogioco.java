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
	
	public Videogioco() {}
	
	public Videogioco(String immagine, double prezzo, String descrizione, String nome, String genere, String piattaforma)
	{
		super(immagine,prezzo,descrizione);
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

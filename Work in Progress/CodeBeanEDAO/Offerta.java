package model;

import static model.Offerta.FIND_ALL;
import static model.Offerta.FIND_BY_CODICE;
import static model.Offerta.FIND_BY_CATEGORIA;


import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT x FROM Offerta b"),
        @NamedQuery(name = FIND_BY_CODICE, query = "SELECT b FROM Offerta b WHERE b.codice = :codice"),
        @NamedQuery(name = FIND_BY_CATEGORIA, query = "SELECT b FROM Offerta b WHERE b.categoria = :categoria")
        
})
public class Offerta {

	public static final String FIND_ALL = "model.Offerta.FIND_ALL";
    public static final String FIND_BY_CODICE = "model.Offerta.FIND_BY_CODICE";
    public static final String FIND_BY_CATEGORIA = "model.Offerta.FIND_BY_CATEGORIA";
    
	private int codice;
	private int sconto;
	private String categoria;
	
	public Offerta() {}
	
	public Offerta(int codice, int sconto,String categoria)
	{
		this.setCodice(codice);
		this.setSconto(sconto);
		this.setCategoria(categoria);
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}

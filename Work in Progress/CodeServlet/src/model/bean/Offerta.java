package model.bean;

import static model.bean.Offerta.FIND_ALL;
import static model.bean.Offerta.FIND_BY_CODICE;
import static model.bean.Offerta.FIND_BY_CATEGORIA;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT x FROM Offerta b"),
        @NamedQuery(name = FIND_BY_CODICE, query = "SELECT b FROM Offerta b WHERE b.codice = :codice"),
        @NamedQuery(name = FIND_BY_CATEGORIA, query = "SELECT b FROM Offerta b WHERE b.categoria = :categoria")
        
})
public class Offerta {

	public static final String FIND_ALL = "model.bean.Offerta.FIND_ALL";
    public static final String FIND_BY_CODICE = "model.bean.Offerta.FIND_BY_CODICE";
    public static final String FIND_BY_CATEGORIA = "model.bean.Offerta.FIND_BY_CATEGORIA";
    
    @Id @GeneratedValue
	private int codice;
    private String nome;
	private int sconto;
	private String categoria;
	
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
	//restituisce il nome dell'offerta
	public String getNome() {
		return nome;
	}
	//Inserisce il nome dell'offerta
	public void setNome(String nome) {
		this.nome = nome;
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

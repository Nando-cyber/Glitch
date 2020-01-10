package model.bean;

import static model.bean.Offerta.FIND_ALL;
import static model.bean.Offerta.FIND_BY_CODICE;

import java.io.Serializable;

import static model.bean.Offerta.FIND_BY_CATEGORIA;

import javax.persistence.Column;
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
public class Offerta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1219194802069073185L;
	public static final String FIND_ALL = "model.Offerta.FIND_ALL";
    public static final String FIND_BY_CODICE = "model.Offerta.FIND_BY_CODICE";
    public static final String FIND_BY_CATEGORIA = "model.Offerta.FIND_BY_CATEGORIA";
    
    @Id @GeneratedValue
    @Column(name="codice", nullable=false)
	private int codice;
    
    @Column(name="sconto", nullable=false)
	private int sconto;
    
    @Column(name="categoria", nullable=false)
	private String categoria;
    
    
    @Column(name="nome", nullable=false)
	private String nome;
	
    //Restituisce il nome dell'offerta
	public String getNome() {
		return nome;
	}
	
	//Modifica il nome dell'offerta
	public void setNome(String nome) {
		this.nome = nome;
	}

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

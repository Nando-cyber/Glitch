package model.bean;

import static model.bean.Richiesta.FIND_BY_EMAIL_MITTENTE;
import static model.bean.Richiesta.FIND_BY_DESTINATARIO;
import static model.bean.Richiesta.FIND_BY_ID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
        @NamedQuery(name = FIND_BY_EMAIL_MITTENTE, query = "SELECT b FROM Richiesta b WHERE b.utenteEmail = :email"),
        @NamedQuery(name = FIND_BY_ID, query = "SELECT b FROM Richiesta b WHERE b.id = :id"),
        @NamedQuery(name = FIND_BY_DESTINATARIO, query = "SELECT b FROM Richiesta b WHERE b.destinatario = :destinatario")
})
public class Richiesta {

	public static final String FIND_BY_EMAIL_MITTENTE = "model.Richiesta.FIND_BY_EMAIL_MITTENTE";
	public static final String FIND_BY_ID = "model.Richiesta.FIND_BY_ID";
	public static final String FIND_BY_DESTINATARIO = "model.Richiesta.FIND_BY_DESTINATARIO";
	
	@Id @GeneratedValue
	private int id;
	@Id
	private String utenteEmail;
	private String utenteUsername;
	private String destinatario;
	private String descrizione;
	private Boolean stato=false;
	
	//Costruttore vuoto
	public Richiesta() {
		
	}
	
	//Costruisce un oggetto "Richiesta" passando come argomento l'email dell'utente, l'username, il destinatario e la descrizione
	public Richiesta(String utenteEmail,String utenteUsername, String destinatario, String descrizione)
	{
		this.setUtenteEmail(utenteEmail);
		this.setUtenteUsername(utenteUsername);
		this.setDestinatario(destinatario);
		this.setDescrizione(descrizione);
	}

	//Restituisce l'email dell'utente
	public String getUtenteEmail() {
		return utenteEmail;
	}

	//Modifica l'email dell'utente
	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
	}

	//Restituisce l'username dell'utente
	public String getUtenteUsername() {
		return utenteUsername;
	}

	//Modifica l'username dell'utente
	public void setUtenteUsername(String utenteUsername) {
		this.utenteUsername = utenteUsername;
	}

	//Restituisce l'email del destinatario
	public String getDestinatario() {
		return destinatario;
	}

	//Modifica l'email del destinatario
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	//Restituisce la descrizione della richiesta
	public String getDescrizione() {
		return descrizione;
	}

	//Modifica la descrizione della richiesta
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	//Restituisce lo stato della richiesta 
	public Boolean getStato() {
		return stato;
	}

	//Modifica lo stato della richiesta
	public void setStato(Boolean stato) {
		this.stato = stato;
	}
}

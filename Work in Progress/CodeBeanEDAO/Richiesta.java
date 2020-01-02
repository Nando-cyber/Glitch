package model;

import static model.Richiesta.FIND_BY_EMAIL_MITTENTE;
import static model.Richiesta.FIND_BY_ID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
        @NamedQuery(name = FIND_BY_EMAIL_MITTENTE, query = "SELECT b FROM Richiesta b WHERE b.utenteEmail = :email"),
        @NamedQuery(name = FIND_BY_ID, query = "SELECT b FROM Richiesta b WHERE b.id = :id")
})
public class Richiesta {

	public static final String FIND_BY_EMAIL_MITTENTE = "model.Richiesta.FIND_BY_EMAIL_MITTENTE";
	public static final String FIND_BY_ID = "model.Richiesta.FIND_BY_ID";
	
	@Id @GeneratedValue
	private int id;
	private String utenteEmail;
	private String utenteUsername;
	private String destinatario;
	private String descrizione;
	private Boolean stato=false;
	
	public Richiesta() {
		
	}
	
	public Richiesta(int id, String utenteEmail,String utenteUsername, String destinatario, String descrizione)
	{
		this.id=id;
		this.setUtenteEmail(utenteEmail);
		this.setUtenteUsername(utenteUsername);
		this.setDestinatario(destinatario);
		this.setDescrizione(descrizione);
	}

	public String getUtenteEmail() {
		return utenteEmail;
	}

	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
	}

	public String getUtenteUsername() {
		return utenteUsername;
	}

	public void setUtenteUsername(String utenteUsername) {
		this.utenteUsername = utenteUsername;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Boolean getStato() {
		return stato;
	}

	public void setStato(Boolean stato) {
		this.stato = stato;
	}
}

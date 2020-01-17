package model.bean;



import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Ordine{


	private String utenteUsername;
	private int ordineId;
	private ArrayList<ProdottiOrdine> prodottiAcquistati;
	private GregorianCalendar dataOrdinazione;
	
	//Costruttore vuoto
	public Ordine() {
	}
	
	//Costruisce l'oggetto "Ordine" passando come argomento l'id ordine, l'username e la lista di prodotti acquistati
	public Ordine(int ordineId, String utenteUsername, ArrayList<ProdottiOrdine> prodottiAcquistati, GregorianCalendar dataOrdinazione)
	{
		this.setOrdineId(ordineId);
		this.setUtenteUsername(utenteUsername);
		this.setProdottiAcquistati(prodottiAcquistati);
		this.setDataOrdinazione(dataOrdinazione);
		
	}

	//Costruisce l'oggetto ordine passando come argomento l'id ordine
	public Ordine(int ordineId)
	{
		this.ordineId=ordineId;
	}
	
	//Restituisce la data di ordinazione sotto forma di oggetto "Date"
	public Date getDataOrdinazioneDate()
	{
		return (Date) dataOrdinazione.getTime();
	}
		
	//Modifica la data di ordinazione passando per argomento un oggetto "Date" contenente la nuova data		
	public void setDataOrdinazioneDate(Date ord)
	{
		dataOrdinazione.setTime(ord);
	}
	
	//Restituisce la data di ordinazione sotto forma di "GregorianCalendar"
	public GregorianCalendar getDataOrdinazione() {
		return dataOrdinazione;
	}

	//Modifica la data di ordinazione passando un oggetto "GregorianCalendar"
	public void setDataOrdinazione(GregorianCalendar dataOrdinazione) {
		this.dataOrdinazione = dataOrdinazione;
	}
	
	
	//Restituisce la lista dei prodotti acquistati
	public ArrayList<ProdottiOrdine> getProdottiAcquistati() {
		return prodottiAcquistati;
	}

	//Modifica la lista dei prodotti acquistati
	public void setProdottiAcquistati(ArrayList<ProdottiOrdine> prodottiAcquistati) {
		this.prodottiAcquistati = prodottiAcquistati;
	}

	//Restituisce l'id dell'ordine
	public int getOrdineId() {
		return ordineId;
	}

	//Modifica l'id dell'ordine
	public void setOrdineId(int ordineId) {
		this.ordineId = ordineId;
	}

	//Restituisce l'username associato all'ordine
	public String getUtenteUsername() {
		return utenteUsername;
	}

	//Modifica l'username associato all'ordine
	public void setUtenteUsername(String utenteUsername) {
		this.utenteUsername = utenteUsername;
	}
	
	
	


}

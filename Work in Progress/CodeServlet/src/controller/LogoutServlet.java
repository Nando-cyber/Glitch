
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Carrello;
import model.dao.CarrelloDAO;
import model.dao.CarrelloDB; 



/* LogoutServlet effettua la disconnessione dell'utente e il salvataggio dei suoi dati
 * */

@WebServlet("/LogoutServlet")
public class LogoutServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CarrelloDAO carDAO = new CarrelloDB() ;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//Si prende il Carrello dell'Utente dalla sessione 
		//e si rimuovono entrambi da quest'ultima
		Carrello car = (Carrello)request.getSession().getAttribute("carrello");
		
		request.getSession().removeAttribute("utente");
		request.getSession().removeAttribute("carrello");
		
		//Si aggiorna il bean Carrello in DB nel caso ci siano state eventuali modifiche
		carDAO.createCarrello(car);
		
		//Si ritorna alla pagina iniziale del sito, disconnessi
		String dest = request.getHeader("referer");
		
		//Da completare quando le servlet sono concluse
		
		if (dest == null || dest.contains("/Logout") || dest.contains("/AcquistoServlet") || dest.contains("/GestioneCarrelloServlet")  
				|| dest.contains("/GestioneOffertaServlet") || dest.contains("/RegistrazioneServlet") || dest.contains("/LoginServlet") 
				|| dest.contains("/GestioneProdottoServlet") || dest.contains("/GestioneProfiloServlet") || dest.contains("/GestioneRuoloServlet") ||  dest.contains("/InserimentoCartaServlet") ||
				dest.contains("/RedirectCarrello") || dest.contains("/RedirectPaginaPersonale") || dest.contains("/RichiestaAssistenzaServlet") ||
				 dest.contains("/RiepilogoOrdineServlet") || dest.contains("/RispostaAssistenzaSrvlet") ||dest.contains("/VisualizzazioneEmailServlet") ||
				dest.contains("/VisualizzazioneUtenteRuoli") ||dest.trim().isEmpty()) {
			dest = "BaseServlet";
		}
		response.sendRedirect(dest);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

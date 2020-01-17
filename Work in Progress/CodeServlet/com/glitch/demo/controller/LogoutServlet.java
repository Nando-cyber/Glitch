
package com.glitch.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glitch.demo.model.bean.Carrello;
import com.glitch.demo.model.dao.CarrelloDAO;
import com.glitch.demo.model.dao.CarrelloDB; 



/* LogoutServlet effettua la disconnessione dell'utente e il salvataggio dei suoi dati
 * */

@WebServlet("/Logout")
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
		
		/*if (dest == null || dest.contains("/Logout") || dest.contains("/InsertProduct") || dest.contains("/AdminUtenti")  
				|| dest.contains("/CarrelloServlet") || dest.contains("/RegistrazioneServlet") || dest.contains("/Login") 
				|| dest.contains("/RemoveProduct") || dest.contains("/Carrello") || dest.contains("/Gestione") ||  dest.contains("/GestioneClienti") ||
				dest.contains("/UpdateProduct") ||dest.trim().isEmpty()) {
			dest = "BaseServlet";
		}
		response.sendRedirect(dest);*/
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

package com.glitch.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glitch.demo.model.bean.Utente;
import com.glitch.demo.model.bean.ValidazioneUtente;
import com.glitch.demo.model.dao.UtenteDAO;
import com.glitch.demo.model.dao.UtenteDB;

/**
 * GestioneRuoloServlet permette di gestire l'inserimento di un ruolo 
 * o la sua eliminazione d aparte del gestore Account
 */
@WebServlet("/GestioneRuoloServlet")
public class GestioneRuoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO uDAO = new UtenteDB();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestioneRuoloServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Si prende dalla request il parametro "operazione", l'utente dalla Sessione e
		// il ruolo dalla request
		String operazione = request.getParameter("operazione");
		Utente u = uDAO.retriveByUsername(request.getParameter("userUtente"));
		String ruolo = request.getParameter("ruolo");
		
		//Si verifica che il formato di ruolo sia corretto altrimenti si lancia un'eccezione
		if(!ValidazioneUtente.checkRuolo(ruolo)) {
			throw new MyServletException("Formato Ruolo non corretto");
		}
		
		//si verifica che "operazione" sia un "aggiunta" o "rimozione"
		if(operazione.equalsIgnoreCase("aggiunta")) {
			
			//Se � un'aggiunta, si assegna il ruolo all'utente selezionato
			if(u.setRuolo(ruolo)) {
				
				//Se l'assegnamento avviene con successo si aggiorna l'utente nel DB
				uDAO.updateUtente(u);
				//Si ritornano da DB tutti gli utenti presenti
				List<Utente> utenti = uDAO.retriveAllUtenti();
				//Si settano nella request in modo da poterli mostrare nella view
				request.getSession().setAttribute("listaUtenti", utenti);

			}else {
				//Se l'assegnamento non avviene con successo,
				//viene l'anciata un'eccezione con relativo messaggio
				throw new MyServletException("L'utente selezionato ha gi� questo ruolo.");
			}
		}else {
			// Se invece � una rimozione, si procede a rimuovere il ruolo dall'utente
			u.removeRuolo(ruolo);
			//Si aggiorna l'utente
			uDAO.updateUtente(u);
			//Si ritornano da DB tutti gli utenti presenti
			List<Utente> utenti = uDAO.retriveAllUtenti();
			//Si settano nella request in modo da poterli mostrare nella view
			request.getSession().setAttribute("listaUtenti", utenti);

		}
		
		//Si esegue la forward alla pagina GestioneRuolo
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/GestioneRuolo.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

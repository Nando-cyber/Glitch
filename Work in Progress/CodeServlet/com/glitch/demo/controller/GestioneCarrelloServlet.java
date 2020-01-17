package com.glitch.demo.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glitch.demo.model.bean.Carrello;
import com.glitch.demo.model.bean.Prodotto;
import com.glitch.demo.model.dao.CarrelloDAO;
import com.glitch.demo.model.dao.CarrelloDB;
import com.glitch.demo.model.dao.OrdineDAO;
import com.glitch.demo.model.dao.OrdineDB;
import com.glitch.demo.model.dao.ProdottoDAO;
import com.glitch.demo.model.dao.ProdottoDB;

/**
 * GestioneCarrelloServlet permette di gestire le opeerazioni connesse al carrello, 
 * ovvero rimozione prodotto dal carrello, modifica quantit� prodotto nel carrello 
 * e inserimento dei prodotti nel carrello
 */
@WebServlet("/GestioneCarrelloServlet")
public class GestioneCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdineDAO oDAO = new OrdineDB();
	private CarrelloDAO cDAO = new CarrelloDB();
	private ProdottoDAO pDAO = new ProdottoDB() ;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestioneCarrelloServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//prendo il parametro "operazione" dalla rquest e controllo se corrisponde ad una rimozione,
		//una modifica o inserimento
		String operazione = request.getParameter("operazione");
		Carrello car = (Carrello) request.getSession().getAttribute("carrello");
		if(operazione.equalsIgnoreCase("inserimento")) {

			//se � un inserimetno si procede all'aggiunto di un prodotto nel carrello
			//si prende l'id del prodotto e la quantit� da request 
			//e si prende da DB il prodotto con l'id corrispondente
			Prodotto p = pDAO.findProdottoById(Integer.parseInt(request.getParameter("prodId")));
			int quantita = Integer.parseInt(request.getParameter("quantita"));

			//si inserisce il prodotto nel carrello
			car.put(p, quantita);

			//si aggiorna il carrello dell'utente
			cDAO.createCarrello(car);

			//si settano nella sessione il Carrello si torna al catalogo
			request.getSession().setAttribute("carrello", car );
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/Catalogo.jsp");
			requestDispatcher.forward(request, response);

		}else if( operazione.equalsIgnoreCase("rimozione")) {

			// se è una rimozione si procede a rimuovere il prodotto indicato nel carrello

			//si rimuove da carrello il prodotto con l'Id preso dalla request
			car.remove( Integer.parseInt(request.getParameter("prodottoID") ));

			//si aggiorna il carrello in DB
			cDAO.doDelete(Integer.parseInt(request.getParameter("prodottoID")), car.getUsername());

			//si salva il carrello modificato nella sessione e si ritorna alla pagina carrello
			request.getSession().setAttribute("carrello", car );
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/Carrello.jsp");
			requestDispatcher.forward(request, response);

		}else {

			//se � una modifica della quantit� di un prodotto

			//si procede ad aggiornare la quantit� del prodotto indicato dall'id preso dalla request
			car.updateQuantita(Integer.parseInt(request.getParameter("prodottoID")), 
					Integer.parseInt( request.getParameter("quantita")));

			//si aggiorna il carrello in DB
			cDAO.doUpdate(car.get(Integer.parseInt(request.getParameter("prodottoID"))));

			//si setta il carrello modificato nella sessione 
			request.getSession().setAttribute("carrello", car );
			
			//Si esegue la forward alla pagina Carrello del sito
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/Carrello.jsp");
			requestDispatcher.forward(request, response);

		}


		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/AcquistoCompletato.jsp");
		requestDispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

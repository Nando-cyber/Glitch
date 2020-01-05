package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrello;
import model.CarrelloDAO;
import model.CarrelloJPA;
import model.Ordine;
import model.OrdineDAO;
import model.OrdineJPA;
import model.Prodotto;
import model.ProdottoDAO;
import model.ProdottoJPA;
import model.Utente;

/**
 * GestioneCarrelloServlet permette di gestire le opeerazioni connesse al carrello, 
 * ovvero rimozione prodotto dal carrello, modifica quantità prodotto nel carrello 
 * e inserimento dei prodotti nel carrello
 */
@WebServlet("/GestioneCarrelloServlet")
public class GestioneCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdineDAO oDAO = new OrdineJPA();
	private CarrelloDAO cDAO = new CarrelloJPA();
	private ProdottoDAO pDAO = new ProdottoJPA();
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
		Utente u = (Utente) request.getSession().getAttribute("utente");

		if(operazione.equalsIgnoreCase("inserimento")) {

			//se è un inserimetno si procede all'aggiunto di un prodotto nel carrello
			//si prende l'id del prodotto e la quantità da request 
			//e si prende da DB il prodotto con l'id corrispondente
			Prodotto p = pDAO.findProdottoById(Integer.parseInt(request.getParameter("prodId")));
			int quantita = Integer.parseInt(request.getParameter("quantita"));

			//si inserisce il prodotto nel carrello
			car.put(p, quantita);

			//si aggiorna il carrello dell'utente
			cDAO.updateCarrello(car);

			//si settano nella sessione il Carrello si torna al catalogo
			request.getSession().setAttribute("carrello", car );
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/Catalogo.jsp");
			requestDispatcher.forward(request, response);

		}else if( operazione.equalsIgnoreCase("rimozione")) {

			// seè è una rimozine si procede a rimuovere il prodotto indicato nel carrello

			//si rimuove da carrello il prodotto con l'Id preso dalla request
			car.remove( Integer.parseInt(request.getParameter("prodottoID") ));

			//si aggiorna il carrello in DB
			cDAO.updateCarrello(car);

			//si salva il carrello modificato nella sessione e si ritorna alla pagina carrello
			request.getSession().setAttribute("carrello", car );
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/Carrello.jsp");
			requestDispatcher.forward(request, response);

		}else {

			//se è una modifica della quantità di un prodotto

			//si procede ad aggiornare la quantità del prodotto indicato dall'id preso dalla request
			car.updateQuantita(Integer.parseInt(request.getParameter("prodottoID")), 
					Integer.parseInt( request.getParameter("quantita")));

			//si aggiorna il carrello in DB
			cDAO.updateCarrello(car);

			//si setta il carrello modificato nella sessione 
			request.getSession().setAttribute("carrello", car );
			
			//Si esegue la forward alla pagina Carrello del sito
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/Carrello.jsp");
			requestDispatcher.forward(request, response);

		}


		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/AcquistoCompletato.jsp");
		requestDispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

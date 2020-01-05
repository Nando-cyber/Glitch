package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Console;
import model.ConsoleDAO;
import model.ConsoleJPA;
import model.Offerta;
import model.OffertaDAO;
import model.OffertaJPA;
import model.ValidazioneOfferta;
import model.Videogioco;
import model.VideogiocoDAO;
import model.VideogiocoJPA;


/**
 * Servlet implementation class GestioneOffertaServlet
 */
@WebServlet("/GestioneOffertaServlet")
public class GestioneOffertaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OffertaDAO oDAO = new OffertaJPA();
	private ConsoleDAO cDAO = new ConsoleJPA();
	private VideogiocoDAO vDAO = new VideogiocoJPA();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestioneOffertaServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Si prende il valore del parametro "operazione" e si verifica se equivale ad "inserimento"
		String caso = request.getParameter("operazione");
		if(caso.equalsIgnoreCase("inserimento")) {

			//se l'equalsIgnoreCase() restituisce true si rende persistente l'offerta in DB

			String nome = request.getParameter("nome");
			String sconto = request.getParameter("sconto");
			String categoria =  request.getParameter("categoria");
			if(!ValidazioneOfferta.checkNome(nome)) {
				throw new MyServletException("Nome offerta non corretta.");
			}			
			if(!ValidazioneOfferta.checkPercentualeSconto(sconto)) {
				throw new MyServletException("Percentuale sconto non corretta.");
			}
			if(!ValidazioneOfferta.checkCategoria(categoria)) {
				throw new MyServletException("Categoria offerta non corretta.");
			}
			
			//si crea il bean Offerta e si settano i dati
			Offerta offerta = new Offerta();
			
			offerta.setNome(nome);
			offerta.setSconto(Integer.parseInt(sconto));
			offerta.setCategoria(categoria);

			//si salva in DB
			oDAO.createOfferta(offerta);

			//ora aggiungiamo l'offerta alla categoria a cui si riferisce
			int percSconto;
			
			if( (offerta.getCategoria()).equalsIgnoreCase("Console")) {

				//se si riferisce ad una console, le prendo tutte da DB ed applico loro lo
				//sconto sul prezzo
				List<Console> console = cDAO.findAllConsole();
				
				for( Console c: console) {

					percSconto = offerta.getSconto();
					double prezzo = c.getPrezzo();

					double elimSconto = (prezzo * percSconto)/100;
					prezzo = prezzo - elimSconto;
					c.setPrezzo(prezzo);

				}

			}else {
				//se si riferisce ad un videogioco, li prendo tutti da DB ed applico loro lo
				//sconto sul prezzo
				List<Videogioco> videogioco = vDAO.findAllVideogioco();


				for( Videogioco v : videogioco) {

					percSconto = offerta.getSconto();
					double prezzo = v.getPrezzo();

					double elimSconto = (prezzo * percSconto)/100;
					prezzo = prezzo - elimSconto;
					v.setPrezzo(prezzo);

				}
			}
		}else {
			//in questo caso il parametro "operazione" contiene "rimozione"
			//e quindi si procede alla rimozione dell'offerta

			//si prende dalla request l'id dell'offerta da eliminare
			int code = Integer.parseInt( request.getParameter("offId") );

			//si prende da DB l'offerta con quell'id
			Offerta o = oDAO.retriveOffertaById(code);

			//si rimuove da DB il prodotto
			oDAO.deleteOfferta(code);	

			//ora eliminiamo l'offerta alla categoria a cui si riferiva
			if( (o.getCategoria()).equalsIgnoreCase("Console")) {

				//se si riferisce ad una console, le prendo tutte da DB ed elimino loro lo
				//sconto 
				List<Console> console = cDAO.findAllConsole();

				for( Console c: console) {

					int sconto = o.getSconto();
					double prezzo = c.getPrezzo();

					double elimSconto = (prezzo * sconto)/100;
					prezzo = prezzo + elimSconto;
					c.setPrezzo(prezzo);

				}

			}else {
				//se si riferisce ad un videogioco, li prendo tutti da DB ed elimino loro lo
				//sconto 
				List<Videogioco> videogioco = vDAO.findAllVideogioco();


				for( Videogioco v : videogioco) {

					int sconto = o.getSconto();
					double prezzo = v.getPrezzo();

					double elimSconto = (prezzo * sconto)/100;
					prezzo = prezzo + elimSconto;
					v.setPrezzo(prezzo);

				}
			}
		}
		//Si esegue la forward alla pagina GestioneOfferte del sito
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/GestioneOfferte.jsp");
		requestDispatcher.forward(request, response);
	}






	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

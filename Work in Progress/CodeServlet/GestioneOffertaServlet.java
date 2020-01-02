package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Console;
import model.ConsoleDAO;
import model.ConsoleJPA;
import model.Offerta;
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

			//se l'equalsIgnoreCase() restituisce true si procede all'inserimento 
			//di una offerta in DB


			int sconto = Integer.parseInt(request.getParameter("sconto"));
			String categoria =  request.getParameter("categoria");


			//si crea il bean Offerta e si settano i dati
			Offerta offerta = new Offerta();

			offerta.setSconto(sconto);
			offerta.setCategoria(categoria);

			//si salva il bean in DB
			oDAO.addOfferta(offerta); //si inserisce in DB

			//ora aggiungiamo l'offerta alla categoria a cui si riferisce

			if( (offerta.getCategoria()).equalsIgnoreCase("Console")) {

				//se si riferisce ad una console, le prendo tutte da DB ed applico loro lo
				//sconto sul prezzo
				List<Console> console = cDAO.findAllConsole();

				for( Console c: console) {

					sconto = offerta.getSconto();
					double prezzo = c.getPrezzo();

					double elimSconto = (prezzo * sconto)/100;
					prezzo = prezzo - elimSconto;
					c.setPrezzo(prezzo);

				}

			}else {
				//se si riferisce ad un videogioco, li prendo tutti da DB ed applico loro lo
				//sconto sul prezzo
				List<Videogioco> videogioco = vDAO.findAllVideogioco();


				for( Videogioco v : videogioco) {

					sconto = offerta.getSconto();
					double prezzo = v.getPrezzo();

					double elimSconto = (prezzo * sconto)/100;
					prezzo = prezzo - elimSconto;
					v.setPrezzo(prezzo);

				}
			}
		}


	}else {
		//in questo caso il parametro "operazione" contiene "rimozione"
		//e quindi si procede alla rimozione dell'offerta

		//si prende dalla request l'id dell'offerta da eliminare
		int code = Integer.parseInt( request.getParameter("offId") );

		//si prende da DB l'offerta con quell'id
		Offerta o = oDAO.findOffertaById(code);

		//si rimuove da DB il prodotto
		oDAO.removeOfferta(o);		

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

}




/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doGet(request, response);
}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Console;
import model.bean.Prodotto;
import model.bean.ValidazioneConsole;
import model.bean.ValidazioneVideogioco;
import model.bean.Videogioco;
import model.dao.ConsoleDAO;
import model.dao.ConsoleDB;
import model.dao.ProdottoDAO;
import model.dao.ProdottoDB;
import model.dao.VideogiocoDAO;
import model.dao.VideogiocoDB;


/**
 * GestioneProdottoServlet permette di gestire i prodotti al gestore catalogo. Inserisce o rimuove un prodotto da DB
 */
@WebServlet("/GestioneProdottoServlet")
public class GestioneProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideogiocoDAO vDAO = new VideogiocoDB();
	private ProdottoDAO pDAO = new ProdottoDB(); 
	private ConsoleDAO cDAO = new ConsoleDB();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestioneProdottoServlet() {
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
			//di un prodotto in DB

			String prod = request.getParameter("Videogioco");
			String prod1 = request.getParameter("Console");
			String imm =  request.getParameter("urlImm");
			String descrizione = request.getParameter("descr");
			String prezzo = request.getParameter("prezzo");



			//si verifica se � una console o un videogioco ( se uno dei due parametri - "Videogioco"
			// o "Console" - � nullo/vuoto, verr� fatto l'inserimento dell'altro
			if(prod1 == null && prod != null) {

				// in questo caso � un videogioco e si prendono i dati dalla request
				String nome =  request.getParameter("nome");
				String genere =  request.getParameter("genere");
				String piattaforma = request.getParameter("piatt");
				
				//si controlla la correttezza del formato dei dati
				
				if(!ValidazioneVideogioco.checkImmagine(imm)) {

					throw new MyServletException("Formato Url Immagine Videogioco non corretto.");
				}
				if(!ValidazioneVideogioco.checkDescrizione(descrizione)) {

					throw new MyServletException("Descrizione Videogioco non corretto.");
				}
				if(!ValidazioneVideogioco.checkPrezzo(prezzo)) {

					throw new MyServletException("Formato Prezzo Videogioco non corretto.");
				}
				if(!ValidazioneVideogioco.checkNome(nome)) {

					throw new MyServletException("Formato Nome Videogioco non corretto.");
				}
				if(!ValidazioneVideogioco.checkGenere(genere)) {

					throw new MyServletException("Formato Genere Videogioco non corretto.");
				}
				if(!ValidazioneVideogioco.checkPiattaforma(piattaforma)) {

					throw new MyServletException("Formato Piattaforma Videogioco non corretto.");
				}


				//si crea un bean Videogioco e si inseriscono i dati

				Videogioco vid = new Videogioco();

				vid.setNome(nome);
				vid.setGenere(genere);
				vid.setImmagine(imm);
				vid.setDescrizione(descrizione);
				vid.setPrezzo(Float.parseFloat(prezzo));
				vid.setPiattaforma(piattaforma);
				vDAO.createVideogioco(vid); //si inserisce in DB

			}else {

				//in questo caso � una Console e si prendono i dati dalla request

				String modello = request.getParameter("modello");
				String casaProduttrice = request.getParameter("produttore");
				
				//si controlla la correttezza del formato dei dati
				
				if(!ValidazioneConsole.checkImmagine(imm)) {

					throw new MyServletException("Formato Url Immagine Console non corretto.");
				}
				if(!ValidazioneConsole.checkDescrizione(descrizione)) {

					throw new MyServletException("Descrizione Console non corretto.");
				}
				if(!ValidazioneConsole.checkPrezzo(prezzo)) {

					throw new MyServletException("Formato Prezzo Console non corretto.");
				}
				if(!ValidazioneConsole.checkModello(modello)) {

					throw new MyServletException("Formato Modello Console non corretto.");
				}
				if(!ValidazioneConsole.checkCasaProduttrice(casaProduttrice)) {

					throw new MyServletException("Formato Casa Produttrice Console non corretto.");
				}
				
				
				//si crea un bean Console e si inseriscono i dati
				Console cons = new Console();

				cons.setModello(modello);
				cons.setCasaProduttrice(casaProduttrice);
				cons.setImmagine(imm);
				cons.setDescrizione(descrizione);
				cons.setPrezzo(Float.parseFloat(prezzo));
				cDAO.createConsole(cons); //si inserisce in DB 

			}


		}else {
			//in questo caso il parametro "operazione" contiene "rimozione"
			//e quindi si procede alla rimozione del prodotto

			//si prende dalla request l'id del prootto da eliminare
			int code = Integer.parseInt( request.getParameter("prodId") );

			//si prende da DB il prodotto con quell'id
			Prodotto p = pDAO.findProdottoById(code);

			//si rimuove da DB il prodotto
			pDAO.removeProdotto(p.getId());			
		}
		//Si esegue la forward alla pagina GestioneProdotti del sito
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/GestioneProdotti.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

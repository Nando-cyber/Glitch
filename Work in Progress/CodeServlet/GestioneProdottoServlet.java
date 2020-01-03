package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Console;
import model.ConsoleDAO;
import model.ConsoleJPA;
import model.Prodotto;
import model.ProdottoDAO;
import model.ProdottoJPA;
import model.Videogioco;
import model.VideogiocoDAO;
import model.VideogiocoJPA;

/**
 * GestioneProdottoServlet permette di gestire i prodotti al gestore catalogo. Inserisce o rimuove un prodotto da DB
 */
@WebServlet("/GestioneProdottoServlet")
public class GestioneProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideogiocoDAO vDAO = new VideogiocoJPA();
	private ProdottoDAO pDAO = new ProdottoJPA(); 
	private ConsoleDAO cDAO = new ConsoleJPA();
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
			float prezzo = Float.parseFloat( request.getParameter("prezzo"));



			//si verifica se è una console o un videogioco ( se uno dei due parametri - "Videogioco"
			// o "Console" - è nullo/vuoto, verrà fatto l'inserimento dell'altro
			if(prod1 == null && prod != null) {
				
				// in questo caso è un videogioco e si prendono i dati dalla request
				String nome =  request.getParameter("nome");
				String genere =  request.getParameter("genere");
				String piattaforma = request.getParameter("piatt");
				
				//si crea un bean Videogioco e si inseriscono i dati
				
				Videogioco vid = new Videogioco();

				vid.setNome(nome);
				vid.setGenere(genere);
				vid.setImmagine(imm);
				vid.setDescrizione(descrizione);
				vid.setPrezzo(prezzo);
				vid.setPiattaforma(piattaforma);
				vDAO.createProdotto(vid); //si inserisce in DB

			}else {

				//in questo caso è una Console e si prendono i dati dalla request

				String modello = request.getParameter("modello");
				String casaProduttrice = request.getParameter("produttore");
				
				//si crea un bean Console e si inseriscono i dati
				Console cons = new Console();

				cons.setModello(modello);
				cons.setCasaProduttrice(casaProduttrice);
				cons.setImmagine(imm);
				cons.setDescrizione(descrizione);
				cons.setPrezzo(prezzo);
				cDAO.createProdotto(cons); //si inserisce in DB 

			}


		}else {
			//in questo caso il parametro "operazione" contiene "rimozione"
			//e quindi si procede alla rimozione del prodotto
			
			//si prende dalla request l'id del prootto da eliminare
			int code = Integer.parseInt( request.getParameter("prodId") );
			
			//si prende da DB il prodotto con quell'id
			Prodotto p = pDAO.findProdottoById(code);
			
			//si rimuove da DB il prodotto
			pDAO.removeProdotto(p);			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

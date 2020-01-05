package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ordine;
import model.Richiesta;
import model.RichiestaDAO;
import model.RichiestaJPA;
import model.Utente;

/**
 *AcquistoServlet permette la gestione dell'acuisto dei prodotti inseriti nel carrello
 */
@WebServlet("/AcquistoServlet")
public class AcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RichiestaDAO rDAO = new RichiestaJPA(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcquistoServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Si prendono dalla Session Utente e Ordine
		Utente u  = (Utente) request.getSession().getAttribute("utente");
		Ordine o = (Ordine) request.getSession().getAttribute("ordine");
		//Si verifica che l'Utente abbia una carta di credito
		if(u.getCartaDiCredito() == null) {
			
			//In caso di assenza si esegue la forword alla pagina InserimentoCarta
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/InserimentoCarta.jsp");
			requestDispatcher.forward(request, response);
		}
		
		else {
			
			//Altrimenti si procede alla compilazione automatica di una mail di conferma ordine
			Richiesta mail = new Richiesta();
			
			//Si settano i dati relativi alla Richiesta
			mail.setDestinatario(u.getEmail());
			mail.setStato(false);
			mail.setUtenteEmail("generatedAutomaticMailOrder@live.com");
			mail.setUtenteUsername("GeneratedAutomaticOrder");
			mail.setDescrizione("L'ordine da lei effettuato in data :" + 
					o.getDataOrdinazione().toString() + "è andato a buon fine."
					+ " Verrà avvisato della spedizione il prima possibile."
					+ "/n Grazie di aver scelto GLITCH!"  );
			
			//Si rende il bean persistente
			rDAO.createRichiesta(mail);
			
			//Si setta un attributo "email" a true nella request per mostrare un pop up di invio email
			request.setAttribute("email", true);
			
			//Si esegue la forward alla pagina Home del sito
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

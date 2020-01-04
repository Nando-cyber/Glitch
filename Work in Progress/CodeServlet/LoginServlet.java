package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrello;
import model.CarrelloDAO;
import model.CarrelloJPA;
import model.Utente;
import model.UtenteDAO;
import model.UtenteJPA;


/* LoginServlet gestisce l'accesso al sito. 
 * Verfifica se i dati dell'utente che vuole effettuare l'accesso siano presenti in DB
 * */


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final UtenteDAO utenteDAO = new UtenteJPA();
	private CarrelloDAO carDAO = new CarrelloJPA();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Si prendono i dati inseriti nel form di login
		
		String username = request.getParameter("login");
		String password = request.getParameter("password");
		Utente utente = null;
		
		//Se questi non sono nulli, si verifica la sua presenza in DB
		
		if (username != null && password != null) {
			utente = utenteDAO.retriveByUsername(username);
		}
		
		//Se non è presente, si lancia un'eccezione
		if (utente == null) {
			throw new MyServletException("Username e/o password non validi.");
		}
		
		//Altrimenti si setta il bean Utente nella Sessione
		request.getSession().setAttribute("utente", utente);
		
		//Si fa restituire il carrello dell'utente che vuole effettuare l'accesso
		Carrello carrello = carDAO.retriveByUtente(utente.getUsername());
		
		//Se il carello è vuoto, lo si crea settandogli i dati dell'Utente a cui è connesso
		if(carrello.isEmpty()) {
			carrello.setUsername(utente.getUsername());
		}
		
		//E si setta il bean Carrello nella Sessione
		request.getSession().setAttribute("carrello", carrello);
		
		//Si ritorna alla pagina iniziale
		String dest = request.getHeader("referer");
		if (dest == null || dest.contains("/Login") || dest.trim().isEmpty()) {
			dest = ".";
		}
		response.sendRedirect(dest);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

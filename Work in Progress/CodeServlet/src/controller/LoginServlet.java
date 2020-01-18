package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Carrello;
import model.bean.Utente;
import model.dao.CarrelloDAO;
import model.dao.CarrelloDB;
import model.dao.UtenteDAO;
import model.dao.UtenteDB; 

/* LoginServlet gestisce l'accesso al sito. 
 * Verfifica se i dati dell'utente che vuole effettuare l'accesso siano presenti in DB
 * */


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UtenteDAO utenteDAO = new UtenteDB();
	private CarrelloDAO carDAO = new CarrelloDB();
       
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utente utente = null;
		
		//Se questi non sono nulli, si verifica la sua presenza in DB
		
		if (username != null && password != null) {
			utente = utenteDAO.retriveByUsername(username);
		}
		
		//Se non � presente, si lancia un'eccezione
		if (utente == null || !utente.getPassword().equals(password)) {
			throw new MyServletException("Username e/o password non validi.");
		}
		
		System.out.println(utente.getEmail());
		
		//Altrimenti si setta il bean Utente nella Sessione
		request.getSession().setAttribute("utente", utente);
		
		//Si fa restituire il carrello dell'utente che vuole effettuare l'accesso
		Carrello carrello = new Carrello();
		carrello = carDAO.retriveByUtente(utente.getUsername());
		
		//Se il carello � vuoto, lo si crea settandogli i dati dell'Utente a cui � connesso
		if(carrello.isEmpty()) {
			
			carrello.setUsername(utente.getUsername());
			carrello.setUtenteEmail(utente.getEmail());
			
		}
		System.out.println(carrello.getUtenteEmail());
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

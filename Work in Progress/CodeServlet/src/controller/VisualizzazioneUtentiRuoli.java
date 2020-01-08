package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Utente;
import model.dao.UtenteDAO;
/**
 * VisualizzazioneUtentiRuoli restituisce alla pagina GestioneAccount la lista utenti 
 * per visualizzare gli utenti a cui aggiungere o rimuovere un ruolo
 */
@WebServlet("/VisualizzazioneUtentiRuoli")
public class VisualizzazioneUtentiRuoli extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	@EJB
    private UtenteDAO uDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzazioneUtentiRuoli() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Si prendono da DB tutti gli utenti
		List<Utente> listUtente = uDAO.retriveAllUtenti();
		
		//Si setta la ListaUtenti nella request
		request.setAttribute("listaUtenti", listUtente);
		
		//Si esegue la forward alla pagina di GestioneAccount
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/GestioneAccount.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

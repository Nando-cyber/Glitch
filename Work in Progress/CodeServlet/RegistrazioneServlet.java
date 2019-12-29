package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrello;


@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtenteDAO utenteDAO = new UtenteDAO();
    private ValidazioneUtente vu = new ValidazioneUtente();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("utente") != null) {
			throw new MyServletException("Utente loggato.");
		}
		
		String username = request.getParameter("username");
		if ( !vu.checkUsername(username)) {
			throw new MyServletException("Username Errato.");
		}
		
		String password = request.getParameter("password");
		if ( !vu.checkPassword(password)) {
			throw new MyServletException("Password Errata.");
		}
		
		String nome = request.getParameter("nome");
		if ( !vu.checkNome(nome)) {
			throw new MyServletException("Nome Errato.");
		}
		
		String cognome = request.getParameter("cognome");
		if ( !vu.checkCognome(cognome)) {
			throw new MyServletException("Cognome Errato.");
		}
		
		String email = request.getParameter("email");
		if ( !vu.checkEmail(email)) {
			throw new MyServletException("E-Mail Errata.");
		}
		
		String provincia = request.getParameter("provincia");
		if ( !vu.checkProvincia(provincia)) {
			throw new MyServletException("Provincia Errata.");
		}
		
		String CAP = request.getParameter("CAP");
		if ( !vu.checkCAP(CAP)) {
			throw new MyServletException("CAP Errato.");
		}
		
		String citta = request.getParameter("citta");
		if ( !vu.checkCitta(citta)) {
			throw new MyServletException("Città Errata.");
		}
		
		String strada = request.getParameter("strada");
		if ( !vu.checkStrada(strada)) {
			throw new MyServletException("Strada Errata.");
		}
		
		String numero = request.getParameter("numero");
		if ( !vu.checkNumero(numero)) {
			throw new MyServletException("Numero Errato.");
		}
		
		Utente u = new Utente(nome, cognome, username, password, email, provincia, CAP, citta, strada, numero);
		
		utenteDAO.addUtente(u);
		
		request.getSession().setAttribute("utente", u);
		
		Carrello carrello = new Carrello();
		
		carrello.setUsername(utente.getUsername());
		carrello.setEmail(utente.getEmail());
		
		request.getSession().setAttribute("carrello", carrello);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

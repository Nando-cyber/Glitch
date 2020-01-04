package controller;

import java.io.IOException;

import javax.security.enterprise.credential.Password;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarrelloDAO;
import model.CarrelloJPA;
import model.Utente;
import model.UtenteDAO;
import model.UtenteJPA;
import model.ValidazioneUtente;

/**
 * Servlet implementation class GestioneProfiloServlet
 */
@WebServlet("/GestioneProfiloServlet")
public class GestioneProfiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO uDAO = new UtenteJPA();
	private CarrelloDAO cDAO = new CarrelloJPA();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestioneProfiloServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String operazione = request.getParameter("operazione");
		Utente u = (Utente) request.getSession().getAttribute("utente");
		if(!operazione.equalsIgnoreCase("rimozione")) {

			uDAO.deleteUtente(u.getUsername());
			request.getSession().removeAttribute("utente");

			cDAO.removeCarrello(u.getUsername());
			request.getSession().removeAttribute("carrello");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
			requestDispatcher.forward(request, response);

		}else {

			String password = request.getParameter("password");

			if(!password.isEmpty()) {
				if ( !ValidazioneUtente.checkPassword(password)) {
					throw new MyServletException("Formato Password Errata.");
				}
				
				Password p = new Password(password);
				u.setPassword(p);				
				
			}

			String email = request.getParameter("email");

			if(!email.isEmpty()) {
				if ( !ValidazioneUtente.checkEmail(email)) {
					throw new MyServletException("Formato E-Mail Errata.");
				}
				u.setEmail(email);
			}

			String provincia = request.getParameter("provincia");
			String CAP = request.getParameter("CAP");
			String citta = request.getParameter("citta");
			String strada = request.getParameter("strada");
			String numero = request.getParameter("numero");
			
			if(!provincia.isEmpty() && !CAP.isEmpty() && !citta.isEmpty() && !strada.isEmpty() && !numero.isEmpty()) {
				if ( !ValidazioneUtente.checkProvincia(provincia)) {
					throw new MyServletException("Formato Provincia Errata.");
				}
				if ( !ValidazioneUtente.checkCap(CAP)) {
					throw new MyServletException("Formato CAP Errato.");
				}
				if ( !ValidazioneUtente.checkCitta(citta)) {
					throw new MyServletException("Formato Città Errata.");
				}
				if ( !ValidazioneUtente.checkVia(strada)) {
					throw new MyServletException("Formato Strada Errata.");
				}
				if ( !ValidazioneUtente.checkNumero(numero)) {
					throw new MyServletException("Formato Numero Errato.");
				}
				u.setProvincia(provincia);
				u.setCap(Integer.parseInt(CAP));
				u.setCitta(citta);
				u.setVia(strada);
				u.setNumero(Integer.parseInt(numero));
				

			}else {
				throw new MyServletException("L'indirizzo deve essere completo");
			}
			
			uDAO.updateUtente(u);
			request.getSession().setAttribute("utente", u);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/ProfiloUtente.jsp");
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

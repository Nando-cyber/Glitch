package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Carrello;
import model.bean.Utente;
import model.bean.ValidazioneUtente;
import model.dao.CarrelloDAO;
import model.dao.CarrelloDB;
import model.dao.UtenteDAO;
import model.dao.UtenteDB;

/**
 * GestioneProfiloServlet permette la gestione della modifica dei dati profilo dell'Utente,
 * ovvero, e-mail, password e indirizzo(provincia, CAP, citt�, strada,numero) oppure 
 * una rimozione profilo Utente
 */
@WebServlet("/GestioneProfiloServlet")
public class GestioneProfiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO uDAO = new UtenteDB(); 
	private CarrelloDAO cDAO = new CarrelloDB();
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
		
		//Si prende il parametro "operazione" dalla request e l'Utente dalla Sessione
		String operazione = request.getParameter("operazione");
		Utente u = (Utente) request.getSession().getAttribute("utente");
		Carrello car = (Carrello) request.getSession().getAttribute("carrello");
		//Si verifica se "operazione" � una rimozione o modifica
		if(operazione.equalsIgnoreCase("rimozione")) {
			// Se � una rimozione si procede a rimuovere l'utente e il suo carrello 
			//da DB e Sessione
			uDAO.deleteUtente(u.getUsername());
			request.getSession().removeAttribute("utente");

			cDAO.removeCarrello(u.getUsername());
			request.getSession().removeAttribute("carrello");
			
			//Si esegue la forword alla pagina Home del sito
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/HomePage.jsp");
			requestDispatcher.forward(request, response);

		}else {
			
			//Se si tratta di una mosifica si prendono i dati dalla request e si verificano se sono
			//vuoti o meno. Se sono vuoti vuol dire che l'utente non voglia che vengano modificati
			String password = request.getParameter("password");

			if(!password.isEmpty()) {
				//Se i dati non sono vuoti, si procede alla verifica del formato che in caso
				//di non correttezza lancia un'eccezione
				if ( !ValidazioneUtente.checkPassword(password)) {
					throw new MyServletException("Formato Password Errata.");
				}
				
				//Altrimenti si prosegue alla modifica del dato nell'Utente
				u.setPassword(password);				
				
			}
			// si fa lo stesso anche per il campo e-mail
			String email = request.getParameter("email");

			if(!email.isEmpty()) {
				if ( !ValidazioneUtente.checkEmail(email)) {
					throw new MyServletException("Formato E-Mail Errata.");
				}
				u.setEmail(email);
				car.setUtenteEmail(email);
				
			}

			String provincia = request.getParameter("provincia");
			String CAP = request.getParameter("CAP");
			String citta = request.getParameter("citta");
			String strada = request.getParameter("via");
			String numero = request.getParameter("numero");
			// Mentre per l'indirizzo tutti i campi devono essere compilati, in caso contrario, se
			//anche un campo � nullo non viene modificato.
			if(!provincia.isEmpty() && !CAP.isEmpty() && !citta.isEmpty() && !strada.isEmpty() && !numero.isEmpty()) {
				
				//Si procede come con i campi precedenti
				if ( !ValidazioneUtente.checkProvincia(provincia)) {
					throw new MyServletException("Formato Provincia Errata.");
				}
				if ( !ValidazioneUtente.checkCap(CAP)) {
					throw new MyServletException("Formato CAP Errato.");
				}
				if ( !ValidazioneUtente.checkCitta(citta)) {
					throw new MyServletException("Formato Citta Errata.");
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
				

			}
			//Si aggiorna l'utente nel DB
			uDAO.updateUtente(u);
			cDAO.doUpdateEmail(u, car);
			//Si assegna l'utente aggiornato alla sessione
			request.getSession().setAttribute("utente", u);
			request.getSession().setAttribute("carrello", car);
			
			//Si esegue la forward alla pagina ProfiloUtente
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/PaginaPersonale.jsp");
			requestDispatcher.forward(request, response);
			}

		}




	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

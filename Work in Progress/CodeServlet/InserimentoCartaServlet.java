package controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CartaDiCredito;
import model.CartaDiCreditoDAO;
import model.CartaDiCreditoJPA;
import model.Utente;
import model.UtenteDAO;
import model.UtenteJPA;
import model.ValidazioneCartaDiCredito;
import model.ValidazioneUtente;

/**
 * 
 */
@WebServlet("/InserimentoCartaServlet")
public class InserimentoCartaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartaDiCreditoDAO cartaDAO = new CartaDiCreditoJPA();
    private UtenteDAO uDAO = new UtenteJPA();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoCartaServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente u = (Utente) request.getSession().getAttribute("utente");
		
		String numero = request.getParameter("numero");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String scadenzaMese = request.getParameter("scadenzaMese");
		String scadenzaAnno = request.getParameter("scadenzaAnno");
		String CVV = request.getParameter("cvv");
		
		if ( !ValidazioneCartaDiCredito.checkNumeroIdentificativo(numero)) {
			throw new MyServletException("Formato Numero Identificativo Carta Errato.");
		}
		if ( !ValidazioneCartaDiCredito.checkNome(nome)) {
			throw new MyServletException("Formato Nome Intestatario Carta Errato.");
		}
		if ( !ValidazioneCartaDiCredito.checkCognome(cognome)) {
			throw new MyServletException("FormatoCognome Intestatario Carta Errato.");
		}
		if ( !ValidazioneCartaDiCredito.checkScadenzaMese(scadenzaMese)) {
			throw new MyServletException("Formato Scadenza Carta Errato.");
		}
		if ( !ValidazioneCartaDiCredito.checkScadenzaAnno(scadenzaAnno)) {
			throw new MyServletException("Formato Scadenza Carta Errato.");
		}
		if ( !ValidazioneCartaDiCredito.checkCVV(CVV)) {
			throw new MyServletException("Formato CVV Carta Errato.");
		}
		
		CartaDiCredito carta = new CartaDiCredito();
		
		carta.setUtenteUsername(u.getUsername());
		carta.setUtenteEmail(u.getEmail());
		carta.setNome(nome);
		carta.setCognome(cognome);
		
		GregorianCalendar scadenza = new GregorianCalendar();
		scadenza.set(Integer.parseInt(scadenzaAnno), Integer.parseInt(scadenzaMese), 1);
		carta.setScadenza(scadenza);
		
		carta.setCvv(Integer.parseInt(CVV));
		
		cartaDAO.createCartaDiCredito(carta);
		
		u.setCartaDiCredito(carta);
		uDAO.updateUtente(u);
		
		request.getSession().setAttribute("utente", u);
		

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/RiepilogoOrdine.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

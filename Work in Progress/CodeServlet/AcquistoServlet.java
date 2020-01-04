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
 * Servlet implementation class AcquistoServlet
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
		
		Utente u  = (Utente) request.getSession().getAttribute("utente");
		Ordine o = (Ordine) request.getSession().getAttribute("ordine");
		if(u.getCartaDiCredito() == null) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/InserimentoCarta.jsp");
			requestDispatcher.forward(request, response);
		}
		
		else {
			
			Richiesta mail = new Richiesta();
			mail.setDestinatario(u.getEmail());
			mail.setStato(false);
			mail.setUtenteEmail("generatedAutomaticMailOrder@live.com");
			mail.setUtenteUsername("GeneratedAutomaticOrder");
			mail.setDescrizione("L'ordine da lei effettuato in data :" + 
					o.getDataOrdinazione().toString() + "è andato a buon fine."
					+ " Verrà avvisato della spedizione il prima possibile."
					+ "/n Grazie di aver scelto GLITCH!"  );
			
			rDAO.createRichiesta(mail);
			
			request.setAttribute("email", true);
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

package controller;


import java.util.List;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*BaseServlet permette di inizializzare il catalogo nella home del sito 
* in modo da mostrare i prodotti offerti
* */

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideogiocoDAO videoDAO = new VideogiocoDAO();
    private ConsoleDAO consoleDAO = new ConsoleDAO();

    public BaseServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Si fa restituire dal database i primi 20 videogiochi e console e 
		//vengono inseriti nella request
		
		List<Videogioco> videogiochi = videoDAO.doRetrieveAllRange(0, 20);
		request.setAttribute("videogiochi", videogiochi);
		
		List<Console> console = consoleDAO.doRetrieveAllRange(0, 20);
		request.setAttribute("console", console);
		
		//Si passano la request con i dati precedentemente settati e la response
		//alla home.jsp che provvederà a mostrare i prodotti
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
		requestDispatcher.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

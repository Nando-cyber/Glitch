package controller;


import java.util.List;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideogiocoDAO videoDAO = new VideogiocoDAO();
    private ConsoleDAO consoleDAO = new ConsoleDAO();

    public BaseServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Videogioco> videogiochi = videoDAO.doRetrieveAll(0, 20);
		request.setAttribute("videogiochi", videogiochi);
		
		List<Console> console = consoleDAO.doRetrieveAll(0, 20);
		request.setAttribute("console", console);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
		requestDispatcher.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

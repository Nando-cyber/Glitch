package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Console;
import model.bean.Videogioco;
import model.dao.ConsoleDAO;
import model.dao.ConsoleDB;
import model.dao.VideogiocoDAO;
import model.dao.VideogiocoDB;

/**
 * Servlet implementation class RedirectGestoreOfferte
 */
@WebServlet("/RedirectGestoreOfferte")
public class RedirectGestoreOfferte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConsoleDAO cDAO = new ConsoleDB();
	private VideogiocoDAO vDAO = new VideogiocoDB();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectGestoreOfferte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Console> consoles = cDAO.findAllConsole();
		List<Videogioco> videogiochi = vDAO.findAllVideogioco();
		
		request.getSession().setAttribute("Consoles", consoles);
		request.getSession().setAttribute("Videogiochi", videogiochi);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/GestioniOfferte.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

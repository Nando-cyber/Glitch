package controller;

import java.io.IOException;
import java.util.ArrayList;

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


@WebServlet("/RicercaProdott")
public class RicercaProdotto  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VideogiocoDAO vDAO = new VideogiocoDB();
	private ConsoleDAO cDAO = new ConsoleDB();
       

    public RicercaProdotto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("cerca");
		ArrayList<Videogioco> vid = (ArrayList<Videogioco>) vDAO.retriveByNome(nome);
		//System.out.println("xxxx " +vid.get(0));
		Console cons =  cDAO.retriveByModello(nome);
		
		if(vid == null) {
			request.getSession().setAttribute("ricerca", cons);
		}
		else {
			request.getSession().setAttribute("ricerca", vid);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/RicercaProdotto.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

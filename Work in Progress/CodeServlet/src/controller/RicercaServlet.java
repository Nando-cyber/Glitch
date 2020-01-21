package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ConsoleDAO;
import model.dao.ConsoleDB;
import model.dao.VideogiocoDAO;
import model.dao.VideogiocoDB;

@WebServlet("/RicercaServlet")
public class RicercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideogiocoDAO vDAO = new VideogiocoDB();
	private ConsoleDAO cDAO = new ConsoleDB();
    private ArrayList<String> listV = new ArrayList<String>();
    private ArrayList<String> listC = new ArrayList<String>(); 

    public RicercaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("input");
		ArrayList<String> result = dammiProdotti(input);
		response.setContentType("application/json");
		
		if(result != null) {
			Iterator<String> iterator = result.iterator();
			
			String str = "[";
			while(iterator.hasNext()) {
				String s = iterator.next();
				str = str.concat("{\"name\":").concat("\"" + s + "\"").concat("},");
			}
			int lastPos = str.lastIndexOf(",");
			String finished = str.substring(0,lastPos);
			String suggerimenti = finished.concat("]");
			
			response.getWriter().append(suggerimenti);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private ArrayList<String> dammiProdotti(String input){
		listV = vDAO.doRetrieveLike(input);
		listC = cDAO.doRetrieveLikeModello(input);
		Iterator<String> i = listV.iterator();
		System.out.println(i.next());
		while(i.hasNext()) {
			listC.add(i.next());
		}
		return listC;
	}

}

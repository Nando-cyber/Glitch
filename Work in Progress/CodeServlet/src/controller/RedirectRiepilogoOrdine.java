package controller;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Carrello;
import model.bean.Ordine;
import model.bean.Utente;

@WebServlet("/RedirectRiepilogoOrdineServlet")
public class RedirectRiepilogoOrdine extends HttpServlet{

	private static final long serialVersionUID = 1L;
   
	public RedirectRiepilogoOrdine() {
        super();
       
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente u = (Utente) request.getSession().getAttribute("utente");
		
		Ordine ordine = new Ordine(u.getUsername(), new GregorianCalendar(new Locale("it", "IT")));
		
		ordine.setProdottiOrdine((Carrello) request.getSession().getAttribute("carrello"));
		
		if(u.getCartaDiCredito() == null) {
			request.setAttribute("carta", null);
		}else {
			request.setAttribute("carta", u.getCartaDiCredito());
		}
		
		request.getSession().setAttribute("ordine", ordine);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/PaginaPagamenti.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
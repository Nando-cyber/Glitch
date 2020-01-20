package Glitch.Test;

import static org.junit.Assert.*;


import java.io.IOException;

import javax.servlet.ServletException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.LoginServlet;
import controller.MyServletException;

import model.bean.Utente;

public class LoginServletTest {

	static MockHttpServletRequest request;
	static MockHttpServletResponse response;
	static LoginServlet servlet;
	
	@Before
	public void setUp() throws Exception {
		request= new MockHttpServletRequest();
		response=new MockHttpServletResponse();
		servlet= new LoginServlet();
		DatabaseHelper.initializeDatabase();
	}

	@After
	public void tearDown() throws Exception {
		request=null;
		response=null;
		DatabaseHelper.resetDatabase();
	}

	//Test (successo: user e password presenti nel database)
	@Test
	public void testLoginServlet() throws ServletException, IOException, MyServletException {
		request.addParameter("username", "Sandro98");
		request.addParameter("password", "12345678CVb");

		servlet.doPost(request, response);
		
		boolean result;

		Utente u=(Utente) request.getSession().getAttribute("utente");
	
		if(u!=null)
			result=true;
		else
			result=false;
		
		assertEquals(result, true);
	}
	
	//Test (fallimento: user e password non presenti nel database)
	@Test
	public void testLoginServletFail() throws ServletException, IOException, MyServletException{
		request.addParameter("username", "Sandro98");
		request.addParameter("password", "12345678CVb");

		servlet.doPost(request, response);
		
		boolean result;

		Utente u=(Utente) request.getSession().getAttribute("utente");
	
		if(u!=null)
			result=false;
		else
			result=true;
		
		assertEquals(result, true);
	}

}

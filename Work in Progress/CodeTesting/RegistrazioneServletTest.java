package Glitch.Test;

import static org.junit.Assert.*;


import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.MyServletException;
import controller.RegistrazioneServlet;
import model.bean.Utente;
import model.dao.UtenteDAO;
import model.dao.UtenteDB;


public class RegistrazioneServletTest {

	
	static MockHttpServletRequest request;
	static MockHttpServletResponse response;
	static RegistrazioneServlet servlet;
	
	@Before
	public void setUp() throws Exception {
		request= new MockHttpServletRequest();
		response=new MockHttpServletResponse();
		servlet= new RegistrazioneServlet();
		DatabaseHelper.initializeDatabase();
	}

	@After
	public void tearDown() throws Exception {
		request=null;
		response=null;
		DatabaseHelper.resetDatabase();
	}

	@Test
	public void testRegistrazioneServletConSuccesso() throws ServletException, IOException, MyServletException{
		
		request.addParameter("username", "Sandro98");
		request.addParameter("password", "12345678Cvb");
		request.addParameter("nome", "Sandro");
		request.addParameter("cognome", "Mutone");
		request.addParameter("email", "s.mutone@studenti.unisa.it");
		request.addParameter("provincia", "Napoli");
		request.addParameter("CAP", "80033");
		request.addParameter("citta", "Cicciano");
		request.addParameter("via", "Cavalieri di malta");
		request.addParameter("numero", "39");
		servlet.doPost(request, response);
		
		UtenteDAO user=new UtenteDB();
		Utente u= user.retriveByUsername("thelegends");
		boolean result;
		
		if(u!=null)
			result=true;
		else
			result=false;
		
		assertEquals(result, true);

	}

	

}

package it.mercurya.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestEnte
 */
@WebServlet("/TestEnte")
public class TestEnte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * TEST ISENABLED()
		 */
		/*EnteImpl ei=new EnteImpl();
		boolean b=ei.isEnabled("ProLocoLazio@gmail.com");
		if(b==true)
			System.out.println("CIAO");*/
		
		EnteImpl ei=new EnteImpl();
		Ente e=new Ente();
		e=ei.getEntebyUtente_email("ProLocoLazio@gmail.com");
		System.out.println("Email: "+e.getEmail()+" Nome: "+e.getNome()+" Pass: "+e.getPassword());
		
	}
}

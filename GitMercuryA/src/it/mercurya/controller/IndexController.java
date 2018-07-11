package it.mercurya.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.mercurya.model.Evento;
import it.mercurya.model.EventoImpl;
import it.mercurya.model.RegioneImpl;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		// se passi TRUE stampa solo eventi non scaduti e eventi abilitati
		// se passi FALSE stampa eventi non scaduti indifferentemente da abilitati o meno
		session.setAttribute("lista_eventi_non_scaduti", new EventoImpl().getEventiNonScaduti(true));
		session.setAttribute("lista_regioni", new RegioneImpl().getAllRegioni());
		
		
        response.sendRedirect("index.jsp");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

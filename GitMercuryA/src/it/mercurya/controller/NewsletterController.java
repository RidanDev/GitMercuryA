package it.mercurya.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.mercurya.model.Comune;
import it.mercurya.model.ComuneImpl;
import it.mercurya.model.Provincia;
import it.mercurya.model.ProvinciaImpl;

/**
 * Servlet implementation class NewsletterController
 * gianluca
 */
@WebServlet("/NewsletterController")
public class NewsletterController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsletterController()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// doGet(request, response);
		HttpSession hs = request.getSession();
		ArrayList<Provincia> listaP = new ArrayList<>();
		ArrayList<Comune> listaC = new ArrayList<>();
		PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("regione"));

		listaP = new ProvinciaImpl().getAllProvincieByIdRegione(Integer.parseInt(request.getParameter("regione")));
		out.println(request.getParameter("regione"));

		
		hs.setAttribute("province", listaP);
		
		if (request.getParameter("provincia") != null)
		{
			listaC = new ComuneImpl().getAllComuniByProvincia(Integer.parseInt(request.getParameter("provincia")));
			
			hs.setAttribute("comune", listaC);	
		}
		
		response.sendRedirect("view/test.jsp");

	}
	

}

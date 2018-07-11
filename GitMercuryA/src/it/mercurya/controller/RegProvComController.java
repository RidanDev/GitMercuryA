package it.mercurya.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mercurya.model.Comune;
import it.mercurya.model.Provincia;
import it.mercurya.model.ProvinciaImpl;
import it.mercurya.model.RegioneImpl;


@WebServlet("/RegProvCom")
public class RegProvComController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String id_regione=request.getParameter("id_reg");
		
		
		System.out.println("L'id della regione selezionata è: " + id_regione);
		
		// otteniamo le provincie della regione selezionata
		ProvinciaImpl ri = new ProvinciaImpl();
		ArrayList<Provincia> list = ri.getAllProvincieByIdRegione(Integer.parseInt(id_regione));
		
		for(Provincia p: list) {
			out.println("<option value=" + p.getId() + ">" + p.getNome() + "</option>");
		}
		
		/*
		if(regione.equals("toscana")) {
			
			for (String element : provTosc)
			{
				
				out.println("<option>"+element+"</option>");
				
			}
		}
		if(regione.equals("liguria")) {
					
					for (String element : provLig)
					{
						
						out.println("<option>"+element+"</option>");
						
					}
				}
	if(regione.equals("marche")) {
				
				for (String element : provMar)
				{
					
					out.println("<option>"+element+"</option>");
					
				}
			}
		
		*/
		
		
		
		
		
	}

}

package it.mercurya.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegProvCom")
public class RegProvComController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String regione=request.getParameter("reg");
		
		
		
		
		String[] provTosc= {"firenze","pisa","livorno","lucca"};
		String[] provLig= {"genova","savona","imperia","la spezia"};
		String[] provMar= {"ancona","macerata","ascoli","pesaro"};
		
		
		
		if(regione.equals("toscana")) {
			
			for (String element : provTosc)
			{
				
				out.println("<option>"+element+"</prov>");
				
			}
		}
		if(regione.equals("liguria")) {
					
					for (String element : provLig)
					{
						
						out.println("<option>"+element+"</prov>");
						
					}
				}
	if(regione.equals("marche")) {
				
				for (String element : provMar)
				{
					
					out.println("<option>"+element+"</prov>");
					
				}
			}
		
		
		
		
		
		
		
	}

}

package it.mercurya.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestComune
 */
@WebServlet("/TestComune")
public class TestComune extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComuneImpl cImp=new ComuneImpl();
		/*
		 * TEST ALLCOMUNI
		 * 
		 * 
		ArrayList<Comune> c=new ArrayList<>();
		c.addAll(cImp.getAllComuni());
		for(Comune co:c) {
			System.out.println(co.getNome());
		}*/
		
		/*
		 * TEST BYID
		 * 
		 * 
		 */
//		Comune c=cImp.getComuneById(58091);
		//System.out.println("id: "+c.getId()+ " nome: "+c.getNome()+" id provincia: "+c.getProvincia_id().getNome());
		
		/*
		 * TEST BYPROVINCIA
		 */
		ArrayList<Comune> l=cImp.getAllComuniByProvincia("Roma");
		for(Comune co:l) {
				System.out.println(co.getNome());
			}
	}
}

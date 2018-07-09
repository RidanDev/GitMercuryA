package it.mercurya.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TEST
 */
@WebServlet("/TEST")
public class TEST_PROVINCIAeREGIONE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TEST_PROVINCIAeREGIONE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// TEST RICEZIONE DATI DA TABELLA PROVINCIA e REGIONE
		ProvinciaImpl pi = new ProvinciaImpl();
		
		Provincia p = pi.getProvinciaById(15);
		
		
		System.out.println("ID: " + p.getId());
		System.out.println("Nome provincia: " + p.getNome());
		
		
		System.out.println("ID Regione in cui sta la provincia: " + p.getRegione_id().getId());
		System.out.println("Nome Regione in cui sta la provincia: " + p.getRegione_id().getNome());
		
		
		// ***********************************************************************************************
		
		/*
		
		System.out.println("**************************************** TUTTE LE REGIONI");
		// tutte le regioni
		RegioneImp ri = new RegioneImp();
		ArrayList<Regione> listRegioni = ri.getAllRegioni();
	
		for(int i=0;i<listRegioni.size();i++){
			System.out.println("ID REGIONE: " + listRegioni.get(i).getId());
			System.out.println("NOME REGIONE: " + listRegioni.get(i).getNome());
		}
		
		
		
		System.out.println("**************************************** TUTTE LE PROVINCIE");
		// tutte le regioni
		ArrayList<Provincia> listProvicie = pi.getAllProvincie();
	
		for(int i=0;i<listProvicie.size();i++){
			System.out.println("ID REGIONE: " + listProvicie.get(i).getId());
			System.out.println("NOME REGIONE: " + listProvicie.get(i).getNome());
		}
		
		
		*/
		
		System.out.println("**************************************** PROVINCIE DEL LAZIO");
		// tutte le regioni
		ArrayList<Provincia> listProvicie = pi.getAllProvincieByNomeRegione("Lazio");
	
		for(int i=0;i<listProvicie.size();i++){
			System.out.println("ID REGIONE: " + listProvicie.get(i).getId());
			System.out.println("NOME REGIONE: " + listProvicie.get(i).getNome());
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

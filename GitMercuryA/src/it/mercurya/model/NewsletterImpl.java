package it.mercurya.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.mercurya.dao.Dao;

public class NewsletterImpl implements NewsletterUtility{
	
	private Connection conn=Dao.getConnection();
	private Statement st=null;
	private ResultSet rst=null;
	private Newsletter newsletter=null;
	private ArrayList<Newsletter> newsletterList;
	
	@Override
	public ArrayList<Newsletter> getallNewsletter() {
		// TODO Auto-generated method stub
		
		newsletterList= new ArrayList<Newsletter>();
		
		try {
			
			st=conn.createStatement();
			rst=st.executeQuery("select * from Newsletter");
			
			while(rst.next()) {
				
				newsletter= new Newsletter();
				newsletter.getUtentebyemail(rst.getString("Utente_email"));
				newsletterList.add(newsletter);
				
			}
			
		}
		
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return newsletterList;
		
	}
	
	
	@Override
	public Newsletter getNewsletterbyUtente(String Utente_email) {
		// TODO Auto-generated method stub
		
		try {
			
			st=conn.createStatement();
			rst=st.executeQuery("select * from Newsletter where Utente_email = '"+Utente_email+"'");
			
			if (rst.first()) {
				
				newsletter = new Newsletter();
				newsletter.getUtentebyemail(rst.getString("Utente_email"));
				newsletterList.add(newsletter);
				
			} 
			
			else{	
				
				newsletter = new Newsletter();
				//newsletter.("unavaible");
				
				
			}
			
			while(rst.next()) {
	
				
				
			}
				
				
		}
		
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	@Override
	public Newsletter getNewsletterbyGenere(Genere Genere_nome) {
		// TODO Auto-generated method stub
		
		return null;
	}
	@Override
	public Newsletter getNewsletterbyRegione(Regione Regione_nome) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Newsletter getNewletterbyProvincia(Provincia Provincia_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Newsletter getNewsletterbyComune(Comune Comune_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Newsletter signingtoNewsletter(String Utente_email, Genere Genere_nome, Regione Regione_nome,
			Provincia Provincia_id, Comune Comune_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

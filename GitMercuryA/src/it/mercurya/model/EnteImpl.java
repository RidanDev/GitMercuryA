package it.mercurya.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.mercurya.dao.Dao;

/* Chiara*/
public class EnteImpl implements EnteUtility{
	
	private Ente ente = null;
	private Connection conn=Dao.getConnection();;
	private PreparedStatement st = null;
	private ResultSet rst = null;
	
	
	
	public boolean isEnabled(String email) {
		boolean b = false;
		try {
			st=conn.prepareStatement("Select isEnabled from Ente where Utente_email = ?" );
			st.setString(1, email);
			rst= st.executeQuery();
			rst.next();
			b = rst.getBoolean("isEnabled");
		 } catch (SQLException e) {
				e.printStackTrace();
		 }
		return b;
		
	}
	
	/* se tutto ok torna 0 else return -1*/
	

	/*public int cancellaEvento(Date inizio, Date fine, Genere Genere_nome, Ente Ente_Utente_email, Comune Comune_id ) {
		int valore = 0;
		return valore;
		
	}*/
	public Ente getEntebyUtente_email(String email) {
		Ente enteX = new Ente();
		try {
			st=conn.prepareStatement("select * from Ente, utente, ruolo where ente.Utente_email = ? and utente.email=ente.Utente_email and ruolo.nome=utente.Ruolo_nome");
			st.setString(1, email);
			rst= st.executeQuery();
			rst.next();
			Utente utente=new Utente();
			utente.setEmail(rst.getString("Utente_email"));
			Ruolo ruolo=new Ruolo();
			ruolo.setNome("Ruolo_nome");
			utente.setRuolo_nome(ruolo);
			
			String nomeX= rst.getString("nome");
			String passX = rst.getString("password");
			String telX = rst.getString("telefono");
			String ragSocX = rst.getString("ragSociale");
			String pIvaX= rst.getString("pIVA");
		
			enteX.setUtente_email(utente);
			enteX.setNome(nomeX);
			enteX.setPassword(passX);
			enteX.setTelefono(telX);
			enteX.setRagSociale(ragSocX);
			enteX.setpIva(pIvaX);
			
		  } catch (SQLException e) {
			e.printStackTrace();
			
		}
		return enteX;
		
	}

}

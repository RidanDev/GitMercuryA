package it.mercurya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.mercurya.dao.Dao;


public class AmministratoreImpl implements AmministratoreUtility{
	private Amministratore admin = null;
	private Connection conn=Dao.getConnection();
	private PreparedStatement st = null;
	private ResultSet rst = null;
	
	 public Amministratore getAmministratoreByEmail(String email) {
	 Amministratore admin = new Amministratore();
     try {
 			st=conn.prepareStatement("select Utente_email from Amministratore where Utente_email = ?");
 			st.setString(1, email);
 			rst= st.executeQuery();
 			rst.next();
 			
			admin.setUtente_email(rst.getString("Utente_email"));
			admin.setPassword(rst.getString("password"));
 			
      } catch (SQLException e) {
			e.printStackTrace();
			
		}
    	 return admin;
	
}
}



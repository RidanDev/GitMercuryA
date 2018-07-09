package it.mercurya.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.mercurya.dao.Dao;


public class AmministratoreImpl implements AmministratoreUtility{

	@Override
	public Amministratore getAmministratoreByEmail(String email) {
		
		Connection conn = null;
		Amministratore admin = null;
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from utente, amministratore where amministratore.Utente_email=Utente.email AND email=\"" + email + "\"");
			if (rs.next()) {
				admin = new Amministratore();
				admin.setEmail(email);
				
				
				RuoloImpl ri = new RuoloImpl();
				Ruolo ruolo = ri.getRuoloByName(rs.getString("Ruolo_nome"));
				admin.setRuolo_nome(ruolo);
				
				//otteniamo anche la password
				admin.setPassword(rs.getString("password"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return admin;
	}

	
}



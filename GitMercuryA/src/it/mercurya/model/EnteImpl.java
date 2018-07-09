package it.mercurya.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.mercurya.dao.Dao;

public class EnteImpl implements EnteUtility{

	@Override
	public Ente getEnteByEmail(String email) {
		Connection conn = null;
		Ente ente = null;
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from utente, ente where ente.Utente_email=Utente.email AND email=\"" + email + "\"");
			if (rs.next()) {
				ente = new Ente();
				ente.setEmail(email);
				
				
				RuoloImpl ri = new RuoloImpl();
				Ruolo ruolo = ri.getRuoloByName(rs.getString("Ruolo_nome"));
				ente.setRuolo_nome(ruolo);
				
				//otteniamo anche gli altri campi
				ente.setNome(rs.getString("nome"));
				ente.setRagSociale(rs.getString("ragSociale"));
				ente.setpIva(rs.getString("pIva"));
				ente.setPassword(rs.getString("password"));
				ente.setTelefono(rs.getString("telefono"));
				
				
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
		
		return ente;
	}
	
}

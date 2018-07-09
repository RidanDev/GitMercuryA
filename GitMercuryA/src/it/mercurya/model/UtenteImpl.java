package it.mercurya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.mercurya.dao.Dao;

public class UtenteImpl implements UtenteUtility{
	

	@Override
	public Utente getUtenteByEmail(String email) {
		Connection conn = null;
		Utente r = null;
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from utente where email=\"" + email + "\"");
			if (rs.next()) {
				r = new Utente();
				r.setEmail(email);
				
				
				RuoloImpl ri = new RuoloImpl();
				Ruolo ruolo = ri.getRuoloByName(rs.getString("Ruolo_nome"));
				r.setRuolo_nome(ruolo);
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
		
		return r;
	}

	@Override
	public int deleteUtenteByEmail(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Utente> getAllUtenti() {
		Connection conn = null;
		ArrayList<Utente> rlist = new ArrayList<Utente>();
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from utente");
			while (rs.next()) {
				Utente r = new Utente();
				
				r.setEmail(rs.getString("email"));
				
				RuoloImpl ri = new RuoloImpl();
				Ruolo ruolo = ri.getRuoloByName(rs.getString("Ruolo_nome"));
				r.setRuolo_nome(ruolo);
				
				
				rlist.add(r);
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
		
		return rlist;
	}

	@Override
	public int addUtente(String email, Ruolo r) {
		Connection conn = null;
		int return_code = -1; // 0=OK, -1=ERRORE
		try {
			conn = Dao.getConnection();
			

		    PreparedStatement prep = conn.prepareStatement("INSERT INTO utente VALUES(?, ?)");
		    prep.setString(1, email);
		    prep.setString(2, r.getNome());
		    
		    prep.executeUpdate();
		    conn.commit();
			
		    
		    return_code = 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return return_code;
	}

	
	
}

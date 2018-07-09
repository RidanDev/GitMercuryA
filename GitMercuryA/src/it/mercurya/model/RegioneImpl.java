package it.mercurya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.mercurya.dao.Dao;

public class RegioneImpl implements RegioneUtility{

	@Override
	public Regione getRegioneById(int id) {
		Connection conn = null;
		Regione r = null;
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from regione where id=" + id);
			if (rs.next()) {
				r = new Regione();
				r.setId(id);
				r.setNome(rs.getString("nome"));
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
	public ArrayList<Regione> getAllRegioni() {
		Connection conn = null;
		ArrayList<Regione> rlist = new ArrayList<Regione>();
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from regione");
			while (rs.next()) {
				Regione r = new Regione();
				r.setId(rs.getInt("id"));
				r.setNome(rs.getString("nome"));
				
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
	public int deleteRegioneById(int id) {
		Connection conn = null;
		int return_code = -1; // 0=OK, -1=ERRORE
		try {
			conn = Dao.getConnection();
			
				
			PreparedStatement prep = conn.prepareStatement("DELETE from regione WHERE id = ?");
		    prep.setLong(1, id);
		    
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

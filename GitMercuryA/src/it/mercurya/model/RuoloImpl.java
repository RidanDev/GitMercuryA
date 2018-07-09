package it.mercurya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.mercurya.dao.Dao;


public class RuoloImpl implements RuoloUtility {



	@Override
	public Ruolo getRuoloByName(String nome) {
		Connection conn = null;
		Ruolo ruolo = null;
		try {
			conn = Dao.getConnection();
			
			PreparedStatement st = conn.prepareStatement("select * from ruolo where nome=?");
			st.setString(1, nome);
			ResultSet rst = st.executeQuery();
			
			if(rst.first()){
				ruolo=new Ruolo();
				ruolo.setNome(rst.getString("nome"));
			}
			conn.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ruolo;
	}
}

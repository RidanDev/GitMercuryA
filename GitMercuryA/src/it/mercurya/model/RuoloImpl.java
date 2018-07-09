package it.mercurya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.mercurya.dao.Dao;

public class RuoloImpl implements RuoloUtility {

	private Connection conn = Dao.getConnection();
	private PreparedStatement st;
	private ResultSet rst;
	Ruolo ruolo;

	@Override
	public Ruolo getRuoloByName(String nome) {
		try {
			st = conn.prepareStatement("select * from ruolo where nome=?");
			st.setString(1, nome);
			rst = st.executeQuery();
			rst.first();
			ruolo=new Ruolo();
			ruolo.setNome(rst.getString("nome"));
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

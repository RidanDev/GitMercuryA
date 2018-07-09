package it.mercurya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.mercurya.dao.Dao;

public class GenereImpl implements GenereUtility{

	
	
	@Override
	public Genere getGenereByName(String nome) {
		
		Connection conn = null;
		Genere g = null;
		
		try {
			
			conn = Dao.getConnection();
			
			PreparedStatement st = conn.prepareStatement("select * from genere where nome=?");
			st.setString(1, nome);
			
			ResultSet rst = st.executeQuery();
			
			if(rst.first()){
				g=new Genere();
				g.setNome(rst.getString("nome"));
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
		
		return g;
	
	}

	@Override
	public ArrayList<Genere> getAllGeneri() {
		
		Connection conn = null;
		ArrayList<Genere> glist = null;
		try {
			conn = Dao.getConnection();
			
			PreparedStatement st = conn.prepareStatement("select * from genere");
			ResultSet rst = st.executeQuery();
			
			while(rst.next()){
				
				if(glist==null)
					glist = new ArrayList<Genere>();
				
				
				Genere g=new Genere();
				g.setNome(rst.getString("nome"));
				
				glist.add(g);
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
		
		return glist;
	}

}

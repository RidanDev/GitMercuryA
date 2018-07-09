package it.mercurya.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.mercurya.dao.Dao;



public class ProvinciaImpl implements ProvinciaUtility{

	@Override
	public Provincia getProvinciaById(int id) {
		Connection conn = null;
		Provincia p = null;
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from provincia where id=" + id);
			if (rs.next()) {
				p = new Provincia();
				p.setId(id);
				p.setNome(rs.getString("nome"));
				
				RegioneImpl ri = new RegioneImpl();
				Regione r = ri.getRegioneById(rs.getInt("Regione_id"));
				
				p.setRegione_id(r);
				
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
		
		return p;
	}

	@Override
	public ArrayList<Provincia> getAllProvincie() {
		Connection conn = null;
		ArrayList<Provincia> plist = new ArrayList<Provincia>();
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from provincia");
			while (rs.next()) {
				Provincia p = new Provincia();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				
				Regione r = new Regione();
				RegioneImpl im = new RegioneImpl();
				r = im.getRegioneById(rs.getInt("Regione_id"));

				p.setRegione_id(r);
				
				plist.add(p);
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
		
		return plist;
	}

	@Override
	public int deleteProvinciaById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Provincia> getAllProvincieByIdRegione(int id_regione) {
		Connection conn = null;
		ArrayList<Provincia> plist = new ArrayList<Provincia>();
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from provincia where provincia.Regione_id="+id_regione);
			while (rs.next()) {
				Provincia p = new Provincia();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				
				Regione r = new Regione();
				RegioneImpl im = new RegioneImpl();
				r = im.getRegioneById(rs.getInt("Regione_id"));

				p.setRegione_id(r);
				
				plist.add(p);
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
		
		return plist;
	}

}

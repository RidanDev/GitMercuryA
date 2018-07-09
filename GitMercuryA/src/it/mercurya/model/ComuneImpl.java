package it.mercurya.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.mercurya.dao.Dao;

public class ComuneImpl implements ComuneUtility {

	@Override
	public Comune getComuneById(int id) {
		Connection conn = null;
		Comune c = null;
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from comune where id=" + id);
			if (rs.next()) {
				c = new Comune();
				c.setId(id);
				c.setNome(rs.getString("nome"));
				
				ProvinciaImpl pi = new ProvinciaImpl();
				Provincia p = pi.getProvinciaById(rs.getInt("Provincia_id"));
				
				c.setProvincia_id(p);
				
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
		
		return c;
	}

	@Override
	public ArrayList<Comune> getAllComuni() {
		Connection conn = null;
		ArrayList<Comune> clist = new ArrayList<Comune>();
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from comune");
			while (rs.next()) {
				Comune c = new Comune();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				
				Provincia p = new Provincia();
				ProvinciaImpl im = new ProvinciaImpl();
				p = im.getProvinciaById(rs.getInt("Provincia_id"));

				c.setProvincia_id(p);
				
				clist.add(c);
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
		
		return clist;
	}

	@Override
	public ArrayList<Comune> getAllComuniByProvincia(String nome_provincia) {
		Connection conn = null;
		ArrayList<Comune> clist = new ArrayList<Comune>();
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from comune, provincia where comune.Provincia_id=Provincia.id AND Provincia.nome=\"" + nome_provincia + "\"");
			while (rs.next()) {
				Comune c = new Comune();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				
				Provincia p = new Provincia();
				ProvinciaImpl pm = new ProvinciaImpl();
				p = pm.getProvinciaById(rs.getInt("Provincia_id"));

				c.setProvincia_id(p);
				
				clist.add(c);
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
		
		return clist;
	}

	@Override
	public int deleteComuneById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package it.mercurya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.mercurya.dao.Dao;

public class ComuneImpl implements ComuneUtility {

	private Connection conn = Dao.getConnection();
	private PreparedStatement st;
	private ResultSet rst;
	private Comune c;

	@Override
	public Comune getComuneById(int id) {
		try {
			st = conn.prepareStatement("select * from comune c where id=?");
			st.setInt(1, id);
			rst = st.executeQuery();
			rst.first();
			c=new Comune();
			c.setId(rst.getInt("id"));
			c.setNome(rst.getString("nome"));
			Provincia p = new Provincia();
			ProvinciaImpl pI=new ProvinciaImpl();
			p=pI.getProvinciaById(rst.getInt("Provincia_id"));
			c.setProvincia_id(p);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
	}

	@Override
	public int deleteComuneById(int id) {
		try {
			st = conn.prepareStatement("delete from comune where id=?");
			st.setString(1, String.valueOf(id));
			st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Comune> getAllComuni() {
		ArrayList<Comune> listaComuni=new ArrayList<>();
		try {
			st = conn.prepareStatement("select * from comune");
			rst = st.executeQuery();
			while (rst.next()) {
				c=new Comune();
				c.setId(rst.getInt("id"));
				c.setNome(rst.getString("nome"));
				Provincia p = new Provincia();
				ProvinciaImpl pI=new ProvinciaImpl();
				p=pI.getProvinciaById(rst.getInt("Provincia_id"));
				c.setProvincia_id(p);
				listaComuni.add(c);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaComuni;
	}

	@Override
	public ArrayList<Comune> getAllComuniByProvincia(String provincia) {
		ArrayList<Comune> listaComuni=new ArrayList<>();
		try {
			st = conn.prepareStatement("select * from comune, provincia where comune.Provincia_id=provincia.id and provincia.nome=?");
			st.setString(1, provincia); 
			rst = st.executeQuery();
			while (rst.next()) {
				c=new Comune();
				c.setId(rst.getInt("id"));
				c.setNome(rst.getString("nome"));
				Provincia p=new Provincia();
				ProvinciaImpl pI=new ProvinciaImpl();
				p=pI.getProvinciaById(rst.getInt("Provincia_id"));
				c.setProvincia_id(p);
				listaComuni.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaComuni;
	}
/*
	@Override
	public int addComune(int id, String name, Provincia provincia) {
		int r=0;
		try {
			PreparedStatement pst=conn.prepareStatement("insert into comune(id, nome, Provincia_id) values(?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, provincia.getId());
			r=pst.executeUpdate();
			conn.commit();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public int changeComune(String nome, Provincia p) {
		// TODO Auto-generated method stub
		return 0;
	}*/

}

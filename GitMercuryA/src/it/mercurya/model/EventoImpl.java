package it.mercurya.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.mercurya.dao.Dao;

public class EventoImpl implements EventoUtility {

	@Override
	public Evento getEventoById(java.sql.Date inizio, java.sql.Date fine, String Genere_nome, String Ente_Utente_email, int Comune_id) {
		Connection conn = null;
		Evento c = null;
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			
			String query = "select * from evento, comune, ente, genere WHERE evento.Genere_nome = Genere.nome AND evento.Ente_Utente_email = ente.Utente_email AND evento.Comune_id = comune.id AND evento.inizio='" + inizio + "' AND evento.fine='" + fine + "' AND evento.Genere_nome='" + Genere_nome + "' AND evento.Ente_Utente_email='" + Ente_Utente_email + "' AND evento.Comune_id=" + Comune_id;
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				
				c = new Evento();
				
				c.setNome(rs.getString("nome"));
				c.setInizio(rs.getDate("inizio"));
				c.setFine(rs.getDate("fine"));
				c.setEnabled(rs.getBoolean("isEnabled"));
				
				
				GenereImpl gi = new GenereImpl();
				c.setGenere_nome(gi.getGenereByName(Genere_nome));
				
				EnteImpl ei = new EnteImpl();
				c.setEnte_Utente_email(ei.getEnteByEmail(Ente_Utente_email));
				
				ComuneImpl ci = new ComuneImpl();
				c.setComune_id(ci.getComuneById(Comune_id));
				
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
	public ArrayList<Evento> getAllEventi() {
		Connection conn = null;
		ArrayList<Evento> clist = new ArrayList<Evento>();
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			
			String query = "select * from evento";
					
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				
				Evento c = new Evento();
				
				c.setNome(rs.getString("nome"));
				c.setInizio(rs.getDate("inizio"));
				c.setFine(rs.getDate("fine"));
				c.setEnabled(rs.getBoolean("isEnabled"));
				
				
				GenereImpl gi = new GenereImpl();
				c.setGenere_nome(gi.getGenereByName(rs.getString("Genere_nome")));
				
				EnteImpl ei = new EnteImpl();
				c.setEnte_Utente_email(ei.getEnteByEmail(rs.getString("Ente_Utente_email")));
				
				ComuneImpl ci = new ComuneImpl();
				c.setComune_id(ci.getComuneById(rs.getInt("Comune_id")));
				
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
	public ArrayList<Evento> getEventiByCustomQuery(String query) {
		Connection conn = null;
		ArrayList<Evento> clist = new ArrayList<Evento>();
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				
				Evento c = new Evento();
				
				c.setNome(rs.getString("nome"));
				c.setInizio(rs.getDate("inizio"));
				c.setFine(rs.getDate("fine"));
				c.setEnabled(rs.getBoolean("isEnabled"));
				
				
				GenereImpl gi = new GenereImpl();
				c.setGenere_nome(gi.getGenereByName(rs.getString("Genere_nome")));
				
				EnteImpl ei = new EnteImpl();
				c.setEnte_Utente_email(ei.getEnteByEmail(rs.getString("Ente_Utente_email")));
				
				ComuneImpl ci = new ComuneImpl();
				c.setComune_id(ci.getComuneById(rs.getInt("Comune_id")));
				
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
	public ArrayList<Evento> getEventiNonScaduti() {
		return getEventiByCustomQuery("SELECT * FROM evento WHERE CURDATE()<=fine");
	}
	
}

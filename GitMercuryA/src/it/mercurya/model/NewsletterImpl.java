package it.mercurya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.mercurya.dao.Dao;

public class NewsletterImpl implements NewsletterUtility{

	@Override
	public ArrayList<Newsletter> getAllNewsletter() {
		
		Connection conn = null;
		ArrayList<Newsletter> clist = new ArrayList<Newsletter>();
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			
			String query = "select * from newsletter";
					
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				
				Newsletter c = new Newsletter();
				
				c.setUtente_email(new UtenteImpl().getUtenteByEmail(rs.getString("Utente_email")));
				c.setGenere_nome(new GenereImpl().getGenereByName(rs.getString("Genere_nome")));
				
				// controlliamo se l'opzione sulla regione c'è (-1 significa non è settata l'opzione)
				// se c'è regione, allora sono inclusi automaticamente anche le notifiche riguardanti provincie e comuni di quella regione
				// se c'è provincia (quindi regione_id = -1), allora sono inclusi automaticamente le notifiche relative ai comuni di quella provincia 
				// se c'è comune (quindi regione_id = -1 e provincia_id = -1), allora solo il comune selezionato
				
				if(rs.getInt("Regione_id") != -1){ // allora sono inclusi automaticamente tutte le provincie e comuni di quella regione
					c.setRegione_id(new RegioneImpl().getRegioneById(rs.getInt("Regione_id")));
				}
				if(rs.getInt("Provincia_id") != -1){ // allora sono inclusi automaticamente tutti i comuni di quella provincia
					c.setProvincia_id(new ProvinciaImpl().getProvinciaById(rs.getInt("Provincia_id")));
				}
				if(rs.getInt("comune_id") != -1){ // // allora solo quel comune interessa
					c.setComune_id(new ComuneImpl().getComuneById(rs.getInt("Comune_id")));
				}// altrimenti se tutti sono uguali a -1, significa che non ci sono preferenze sulla zona
				
				
				c.setCadenza(rs.getString("cadenza"));
				c.setDataProxEmail(rs.getDate("dataProxEmail"));
				
				
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
	public int insertNewsletter(Newsletter newsletter) {
		Connection conn = null;
		int return_code = -1; // 0=OK, -1=ERRORE, -2=utente già presente come ente/amministratore
		
		
		try {
			conn = Dao.getConnection();
			
			Utente u = new UtenteImpl().getUtenteByEmail(newsletter.getUtente_email().getEmail());
			PreparedStatement prep = conn.prepareStatement("INSERT INTO newsletter (Utente_email, Genere_nome, Regione_id, Provincia_id, Comune_id, cadenza, dataProxEmail) VALUES(?, ?, ?, ?, ?, ?, ?)");
		    prep.setString(1, newsletter.getUtente_email().getEmail());
		    prep.setString(2, newsletter.getGenere_nome().getNome());
		    prep.setInt(3, newsletter.getRegione_id().getId());
		    prep.setInt(4, newsletter.getProvincia_id().getId());
		    prep.setInt(5, newsletter.getComune_id().getId());
		    prep.setString(6, newsletter.getCadenza());
		    prep.setDate(7, newsletter.getDataProxEmail());
		    prep.executeUpdate();
		    conn.commit();
			return_code=0;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return return_code;
		
	}
}
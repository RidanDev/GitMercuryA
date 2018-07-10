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
				}else if(rs.getInt("Provincia_id") != -1){ // allora sono inclusi automaticamente tutti i comuni di quella provincia
					c.setProvincia_id(new ProvinciaImpl().getProvinciaById(rs.getInt("Provincia_id")));
				}else if(rs.getInt("comune_id") != -1){ // // allora solo quel comune interessa
					c.setComune_id(new ComuneImpl().getComuneById(rs.getInt("Comune_id")));
				}// altrimenti se tutti sono uguali a -1, significa che non ci sono preferenze sulla zona
				
				
				c.setCadenza(rs.getInt("cadenza"));
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
	public int insertNewsletter(String email, String genere, int regione_id, int provincia_id, int comune_id, int cadenza, java.sql.Date dataProxEmail) {
		Connection conn = null;
		int return_code = -1; // 0=OK, -1=ERRORE, -2=utente già presente come ente/amministratore
		
		boolean posso_inserire = false; // posso inserire solamente se non ci sono enti/amministratori con quella email
		
		try {
			conn = Dao.getConnection();
			
			// dobbamo mantenere integrità nel db, quindi creiamo i dati necessari prima
			UtenteImpl ui = new UtenteImpl();
			Utente u = ui.getUtenteByEmail(email);
			
			
			if(u==null){ // utente con quella email non esiste nel db
				Ruolo r = new RuoloImpl().getRuoloByName("iscritto"); //vediamo se esite il ruolo nel db
				
				if(r != null && ui.addUtente(email, r)==0) // inserito correttamente un nuovo utente
					posso_inserire = true;
				
			}else if (u.getRuolo_nome().getNome().toLowerCase().equals("ente") == false && 
					u.getRuolo_nome().getNome().toLowerCase().equals("amministratore") == false){ // in questo caso c'è già quella email nel db -> controlliamo che non sia ente o amministratore
					
				posso_inserire = true;
			
			}else{
				return_code = -2;
			}
			
			if(posso_inserire == true){
				
				
			    PreparedStatement prep = conn.prepareStatement("INSERT INTO newsletter (Utente_email, Genere_nome, Regione_id, Provincia_id, Comune_id, cadenza, dataProxEmail) VALUES(?, ?, ?, ?, ?, ?, ?)");
			    prep.setString(1, email);
			    prep.setString(2, genere);
			    prep.setInt(3, regione_id);
			    prep.setInt(4, provincia_id);
			    prep.setInt(5, comune_id);
			    prep.setInt(6, cadenza);
			    prep.setDate(7, dataProxEmail);
			    
			    prep.executeUpdate();
			    conn.commit();
				
			    
			    return_code = 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

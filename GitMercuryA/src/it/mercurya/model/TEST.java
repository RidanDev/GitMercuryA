package it.mercurya.model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TEST
 */
@WebServlet("/TEST")
public class TEST extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	
	
	void test_provincia_by_id(){
		// TEST RICEZIONE DATI DA TABELLA PROVINCIA e REGIONE
		ProvinciaImpl pi = new ProvinciaImpl();
		
		Provincia p = pi.getProvinciaById(15);
		
		
		System.out.println("ID: " + p.getId());
		System.out.println("Nome provincia: " + p.getNome());
		
		
		System.out.println("ID Regione in cui sta la provincia: " + p.getRegione_id().getId());
		System.out.println("Nome Regione in cui sta la provincia: " + p.getRegione_id().getNome());
	}
	
	void test_all_regioni(){
		System.out.println("**************************************** TUTTE LE REGIONI");
		// tutte le regioni
		RegioneImpl ri = new RegioneImpl();
		ArrayList<Regione> listRegioni = ri.getAllRegioni();
	
		for(int i=0;i<listRegioni.size();i++){
			System.out.println("ID REGIONE: " + listRegioni.get(i).getId());
			System.out.println("NOME REGIONE: " + listRegioni.get(i).getNome());
		}
	}
	
	void test_all_provincie(){
		
		ProvinciaImpl pi = new ProvinciaImpl();
				
		System.out.println("**************************************** TUTTE LE PROVINCIE");
		
		// tutte le regioni
		ArrayList<Provincia> listProvicie = pi.getAllProvincie();
	
		for(int i=0;i<listProvicie.size();i++){
			System.out.println("ID REGIONE: " + listProvicie.get(i).getId());
			System.out.println("NOME REGIONE: " + listProvicie.get(i).getNome());
		}
	}
	
	void test_provincie_by_regione(){
		
		
		ProvinciaImpl pi = new ProvinciaImpl();
				
				
		System.out.println("**************************************** PROVINCIE DEL LAZIO");
		// tutte le regioni
		ArrayList<Provincia> listProvicie = pi.getAllProvincieByIdRegione(12);
	
		for(int i=0;i<listProvicie.size();i++){
			System.out.println("ID REGIONE: " + listProvicie.get(i).getId());
			System.out.println("NOME REGIONE: " + listProvicie.get(i).getNome());
		}
	}
	
	void test_comune_provincia_regione(){
		ComuneImpl im = new ComuneImpl();
		
		Comune c = im.getComuneById(5001);
		System.out.println("ID comune: " + c.getId());
		System.out.println("Nome comune: " + c.getNome());
		
		
		
		Provincia p = c.getProvincia_id();
		System.out.println("ID provincia: " + p.getId());
		System.out.println("Nome provincia: " + p.getNome());
		
		
		Regione r = p.getRegione_id();
		System.out.println("ID regione: " + r.getId());
		System.out.println("Nome regione: " + r.getNome());
	}
	
	void test_comune(){
		ComuneImpl im = new ComuneImpl();
		Comune c = im.getComuneById(4097);
		System.out.println("ID comune: " + c.getId());
		System.out.println("Nome comune: " + c.getNome());
	}
	
	void test_regione(){
		RegioneImpl ri = new RegioneImpl();
		Regione r = ri.getRegioneById(4);
		System.out.println("ID Regione: " + r.getId());
		System.out.println("Nome Regione: " + r.getNome());
		
	}
	
	void test_provincia(){
		ProvinciaImpl pi = new ProvinciaImpl();
		Provincia p = pi.getProvinciaById(8);
		System.out.println("ID Provincia: " + p.getId());
		System.out.println("Nome Provincia: " + p.getNome());
	}
	
	void test_ruolo(){
		RuoloImpl ri = new RuoloImpl();
		Ruolo r = ri.getRuoloByName("Amministratore");
		if(r==null)
			System.out.println("Ruolo non trovato");
		else
			System.out.println("Nome ruolo: " + r.getNome());
	}
	
	void test_utente(){
		UtenteImpl ui = new UtenteImpl();
		Utente u = ui.getUtenteByEmail("ProLocoLazio@gmail.com");
		if(u==null){
			System.out.println("Utente non trovato");
		}else{
			System.out.println("E-mail: " + u.getEmail());
			System.out.println("Ruolo: " + u.getRuolo_nome().getNome());
		}
	}
	
	void test_amministratore(){
		AmministratoreImpl ui = new AmministratoreImpl();
		Amministratore u = ui.getAmministratoreByEmail("prova@prova.com");
		if(u==null){
			System.out.println("Amministratore non trovato");
		}else{
			System.out.println("E-mail: " + u.getEmail());
			System.out.println("Ruolo: " + u.getRuolo_nome().getNome());
			System.out.println("Password: " + u.getPassword());
		}
	}
	
	void test_ente(){
		EnteImpl ui = new EnteImpl();
		Ente u = ui.getEnteByEmail("ProLocoLazio@gmail.com");
		if(u==null){
			System.out.println("Ente non trovato");
		}else{
			System.out.println("E-mail: " + u.getEmail());
			System.out.println("Nome: " + u.getNome());
			System.out.println("ragSociale: " + u.getRagSociale());
			System.out.println("pIva: " + u.getpIva());
			System.out.println("Password: " + u.getPassword());
			System.out.println("Telefono: " + u.getTelefono());
			System.out.println("Ruolo: " + u.getRuolo_nome().getNome());
		}
	}
	
	void test_genere(){
		GenereImpl ri = new GenereImpl();
		Genere r = ri.getGenereByName("film");
		if(r==null)
			System.out.println("Genere non trovato");
		else
			System.out.println("Nome genere: " + r.getNome());
		
		
		
		System.out.println("***************************");
		
		ArrayList<Genere> list = ri.getAllGeneri();
		
		for(int i=0;i<list.size();i++){
			System.out.println("Nome genere: " + list.get(i).getNome());
		}
		
		
	}
	
	void print_evento(Evento e){
		System.out.println("Nome evento: " + e.getNome());
		System.out.println("Inizio evento: " + e.getInizio());
		System.out.println("Fine evento: " + e.getFine());
		/////
		Genere g = e.getGenere_nome();
		System.out.println("Genere evento: " +g.getNome());
		/////
		Ente ente = e.getEnte_Utente_email();
		System.out.println("Email ente: " + ente.getEmail());
		System.out.println("Nome ente: " + ente.getNome());
		System.out.println("ragSociale ente: " + ente.getRagSociale());
		System.out.println("pIva ente: " + ente.getpIva());
		System.out.println("Password ente: " + ente.getPassword());
		System.out.println("Telefono ente: " + ente.getTelefono());
		System.out.println("Ruolo ente: " + ente.getRuolo_nome().getNome());
		/////
		Comune c = e.getComune_id();
		System.out.println("ID comune: " + c.getId());
		System.out.println("Nome comune: " + c.getNome());
		
		Provincia p = c.getProvincia_id();
		System.out.println("ID provincia: " + p.getId());
		System.out.println("Nome provincia: " + p.getNome());
		
		Regione r = p.getRegione_id();
		System.out.println("ID regione: " + r.getId());
		System.out.println("Nome regione: " + r.getNome());
		/////
		System.out.println("Abilitato: " + e.isEnabled());
		
	}
	
	void test_evento() throws ParseException{
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date inizio = new java.sql.Date(df.parse("2018-07-05").getTime());
		java.sql.Date fine = new java.sql.Date(df.parse("2018-07-19").getTime());
		
		
		EventoImpl ei = new EventoImpl();
		Evento e = ei.getEventoById(inizio, fine, "film", "ProLocoToscana@gmail.com", 48017);
		
		if(e==null){
			System.out.println("Evento non trovato");
		}else{
			print_evento(e);
			
		}
		
	}
	
	void test_all_eventi(){
		EventoImpl ei = new EventoImpl();
		ArrayList<Evento> elist = ei.getAllEventi();
		
		for(int i=0;i<elist.size();i++){
			print_evento(elist.get(i));
			
			System.out.println("________________________________________");
		}
		
	}
	void test_eventi_by_custom_query(){
		String query = "select * from evento where Genere_nome='film'";
		
		EventoImpl ei = new EventoImpl();
		ArrayList<Evento> elist = ei.getEventiByCustomQuery(query);
		
		for(int i=0;i<elist.size();i++){
			print_evento(elist.get(i));
			
			System.out.println("________________________________________");
		}
	}
	
	void test_eventi_non_scaduti(boolean solo_eventi_abilitati){
		EventoImpl ei = new EventoImpl();
		ArrayList<Evento> elist = ei.getEventiNonScaduti(solo_eventi_abilitati);
	
		if(elist.size()>0){
			for(int i=0;i<elist.size();i++){
				print_evento(elist.get(i));
				
				System.out.println("________________________________________");
			}
		}else{
			System.out.println("Non sono presenti eventi attivi");
		}
	}
	
	void test_get_all_newsletter(){
		NewsletterImpl ei = new NewsletterImpl();
		ArrayList<Newsletter> elist = ei.getAllNewsletter();
		
		for(int i=0;i<elist.size();i++){
			System.out.println("Email: " + elist.get(i).getUtente_email().getEmail());
			System.out.println("Genere: " + elist.get(i).getGenere_nome().getNome());
			
			if(elist.get(i).getRegione_id() != null)
				System.out.println("Interessato agli eventi della regione: " + elist.get(i).getRegione_id().getNome() + " (indifferentemente da provincia e comune)");
			else if(elist.get(i).getProvincia_id() != null)
				System.out.println("Interessato agli eventi della provincia: " + elist.get(i).getProvincia_id().getNome() + " (indifferentemente dal comune ma NON di tutta la regione)");
			else if(elist.get(i).getComune_id() != null)
				System.out.println("Interessato agli eventi del comune: " + elist.get(i).getComune_id().getNome() + "(NON tutta la regione e NON tutta la provincia)");
			else
				System.out.println("Non c'è nessun filtro sul luogo: va bene qualsiasi zona");
			
			System.out.println("Candenza: " + elist.get(i).getCadenza());
			System.out.println("Data prossima email: " + elist.get(i).getDataProxEmail());
			
			System.out.println("________________________________________");
		}
		
	}
	
	void test_insert_newsletter() throws ParseException{
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date dataProxEmail = new java.sql.Date(df.parse("2018-07-25").getTime());
		
		NewsletterImpl ni = new NewsletterImpl();
		
		
		int result = ni.insertNewsletter("abcd@abcd.com", "film", -1, 98, -1, 7, dataProxEmail);
		
		if(result == 0){
			System.out.println("Inserito correttamente nella newsletter");
		}else if(result == -2){
			System.out.println("Questa email è già associata a un ente/amministratore, quindi non puoi iscriverti alla newsletter");
		}else{
			System.out.println("Errore nell'inserimento, probabilmente questa preferenza è già presente nel DB");
		}
		
		
	}
	 
	void test_add_evento() throws ParseException {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		java.sql.Date inizio = new java.sql.Date(df.parse("2018-07-10").getTime());
		java.sql.Date fine = new java.sql.Date(df.parse("2018-08-10").getTime());
		
		EventoImpl ei= new EventoImpl();
		int result = ei.addEvento("corso java", inizio , fine, "mostra", "ProLocoLombardia@gmail.com", 1006);
		
		if(result == 0){
			System.out.println("Inserito correttamente l'evento");
		}else if(result == -2){
			System.out.println("Non è stato trovato nessun ente con questa e-mail");
		}else{
			System.out.println("Errore nell'inserimento (probabilmente già esiste)");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		// se passi TRUE stampa solo eventi non scaduti e eventi abilitati
		test_eventi_non_scaduti(true);
		
		System.out.println("-------");
		
		// se passi FALSE stampa eventi non scaduti indifferentemente da abilitati o meno
		test_eventi_non_scaduti(false);
			
		
		
	}
}

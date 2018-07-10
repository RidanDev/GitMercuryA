package it.mercurya.model;

import java.util.ArrayList;

public interface EventoUtility {
	public Evento getEventoById(java.sql.Date inizio, java.sql.Date fine, String Genere_nome, String Ente_Utente_email, int Comune_id);
	public ArrayList<Evento> getAllEventi();
	public ArrayList<Evento> getEventiByCustomQuery(String query); // Query completamente personalizzata dal un controller
	public ArrayList<Evento> getEventiNonScaduti(); // Restituisce solo gli eventi non scaduti
	public int addEvento(String nome, java.sql.Date inizio, java.sql.Date fine, String Genere_nome, String Ente_Utente_email, int Comune_id);
}

package it.mercurya.model;

import java.util.ArrayList;

public interface EventoUtility {
	
	public ArrayList<Evento> getAllEventi();
	public int setEvento(String nome, String inizio, String fine, Genere Genere_nome, Ente Ente_Utente_email, int isEnabled, Comune Comune_id);
	public Evento getEventibyNome(String nome); //Cerca Eventi in base al nome parziale
	public Evento getEventibyGenere(Genere Genere_nome);
	public Evento getEventibyIinizio(String inizio);
	public Evento getEventibyFine(String fine);
	public Evento deleteEvento(String nome);
	
}

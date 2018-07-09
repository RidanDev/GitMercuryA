package it.mercurya.model;

import java.util.Date;

/* Chiara: Interfaccia Ente */
public interface EnteUtility {
	public boolean isEnabled(String email);
	
	/*public int cancellaEvento(Date inizio, Date fine, Genere Genere_nome, Ente Ente_Utente_email, Comune Comune_id );*/
	public Ente getEntebyUtente_email(String email);
	
	
	
	

}

package it.mercurya.model;

import java.util.ArrayList;

public interface NewsletterUtility {
	
	public ArrayList<Newsletter> getallNewsletter();
	public Newsletter getNewsletterbyUtente(String Utente_email);
	public Newsletter getNewsletterbyGenere(Genere Genere_nome);
	public Newsletter getNewsletterbyRegione(Regione Regione_nome);
	public Newsletter getNewletterbyProvincia(Provincia Provincia_id );
	public Newsletter getNewsletterbyComune(Comune Comune_id);
	public Newsletter signingtoNewsletter(String Utente_email, Genere Genere_nome, Regione Regione_nome, Provincia Provincia_id, Comune Comune_id);
	
	}


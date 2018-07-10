package it.mercurya.model;

import java.util.ArrayList;

public interface NewsletterUtility {
	public ArrayList<Newsletter> getAllNewsletter();
	public int insertNewsletter(String email, String genere, int regione_id, int provincia_id, int comune_id, int cadenza, java.sql.Date dataProxEmail);
}

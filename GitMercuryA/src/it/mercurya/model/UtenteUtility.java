package it.mercurya.model;

import java.util.ArrayList;

public interface UtenteUtility {
	
	public Utente getUtenteByEmail(String email);
	public int deleteUtenteByEmail(String email); //Ritorna 0 se operazione ok, -1 altrimenti
	public ArrayList<Utente> getAllUtenti();
	public int addUtente(String email, Ruolo r);

}

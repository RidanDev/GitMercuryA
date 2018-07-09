package it.mercurya.model;
/* Chiara: Classe Admin*/

public class Amministratore extends Utente{
    private String Utente_email;
    private String password;
	
    public Amministratore() {
		super();
		
	}
	public String getUtente_email() {
		return Utente_email;
	}
	public void setUtente_email(String utente_email) {
		Utente_email = utente_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}

package it.mercurya.model;
/* Chiara: Classe Admin*/

public class Amministratore extends Utente{
    private String password;
	
    public Amministratore() {
		super();
	}
    
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
    
}

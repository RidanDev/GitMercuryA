package it.mercurya.model;

public class Utente {
	
	private Ruolo Ruolo_nome;
	private String email;
	
	public Utente() {
		
		super();
		
	}

	public Ruolo getRuolo_nome() {
		return Ruolo_nome;
	}

	public void setRuolo_nome(Ruolo ruolo_nome) {
		Ruolo_nome = ruolo_nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

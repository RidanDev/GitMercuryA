package it.mercurya.model;

public class Evento {
	private String nome;
	private java.sql.Date inizio;
	private java.sql.Date fine;
	private Genere Genere_nome;
	private Ente Ente_Utente_email;
	private Comune Comune_id;
	private boolean isEnabled;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public java.sql.Date getInizio() {
		return inizio;
	}
	public void setInizio(java.sql.Date inizio) {
		this.inizio = inizio;
	}
	public java.sql.Date getFine() {
		return fine;
	}
	public void setFine(java.sql.Date fine) {
		this.fine = fine;
	}
	public Genere getGenere_nome() {
		return Genere_nome;
	}
	public void setGenere_nome(Genere genere_nome) {
		Genere_nome = genere_nome;
	}
	public Ente getEnte_Utente_email() {
		return Ente_Utente_email;
	}
	public void setEnte_Utente_email(Ente ente_Utente_email) {
		Ente_Utente_email = ente_Utente_email;
	}
	public Comune getComune_id() {
		return Comune_id;
	}
	public void setComune_id(Comune comune_id) {
		Comune_id = comune_id;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
	
}

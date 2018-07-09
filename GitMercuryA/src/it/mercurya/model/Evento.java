//DAVIDE

package it.mercurya.model;

public class Evento {
	
	private Ente Ente_Utente_email;
	private String nome;
	private String inizio;
	private String fine;
	private Genere Genere_nome;
	private int isEnabled;
	private Comune Comune_id;
	
	public Evento() {
		
		super();
		
	}

	public Ente getEnte_Utente_email() {
		return Ente_Utente_email;
	}

	public void setEnte_Utente_email(Ente ente_Utente_email) {
		Ente_Utente_email = ente_Utente_email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInizio() {
		return inizio;
	}

	public void setInizio(String inizio) {
		this.inizio = inizio;
	}

	public String getFine() {
		return fine;
	}

	public void setFine(String fine) {
		this.fine = fine;
	}

	public Genere getGenere_nome() {
		return Genere_nome;
	}

	public void setGenere_nome(Genere genere_nome) {
		Genere_nome = genere_nome;
	}

	public int isEnabled() {
		return isEnabled;
	}

	public void setEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Comune getComune_id() {
		return Comune_id;
	}

	public void setComune_id(Comune comune_id) {
		Comune_id = comune_id;
	}
	
	
	
	

}

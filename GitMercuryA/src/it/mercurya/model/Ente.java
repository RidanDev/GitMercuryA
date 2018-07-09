package it.mercurya.model;
/* Chiara: classe Ente*/
public class Ente extends Utente{
	private Utente Utente_email;
	private String nome;
	private String password;
	private String telefono;
	private String ragSociale;
	private String pIva;
	
	public Ente() {
		super();
	}

	public Utente getUtente_email() {
		return Utente_email;
	}

	public void setUtente_email(Utente utente) {
		Utente_email = utente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRagSociale() {
		return ragSociale;
	}

	public void setRagSociale(String ragSociale) {
		this.ragSociale = ragSociale;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}
	
}

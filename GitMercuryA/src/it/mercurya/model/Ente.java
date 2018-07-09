package it.mercurya.model;

public class Ente extends Utente{
	private String nome;
	private String ragSociale;
	private String pIva;
	private String password;
	private String telefono;
	
    public Ente() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
    
    
    
    
}

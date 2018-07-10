package it.mercurya.model;

class Newsletter {
	private Utente Utente_email;
	private Genere Genere_nome;
	private Regione Regione_id;
	private Provincia Provincia_id;
	private Comune Comune_id;
	private int cadenza;
	private java.sql.Date dataProxEmail;
	
	public Newsletter(){
		Genere_nome = null;
		Regione_id = null;
		Provincia_id = null;
		Comune_id = null;
	}
	
	public Utente getUtente_email() {
		return Utente_email;
	}
	public void setUtente_email(Utente utente_email) {
		Utente_email = utente_email;
	}
	public Genere getGenere_nome() {
		return Genere_nome;
	}
	public void setGenere_nome(Genere genere_nome) {
		Genere_nome = genere_nome;
	}
	public Regione getRegione_id() {
		return Regione_id;
	}
	public void setRegione_id(Regione regione_id) {
		Regione_id = regione_id;
	}
	public Provincia getProvincia_id() {
		return Provincia_id;
	}
	public void setProvincia_id(Provincia provincia_id) {
		Provincia_id = provincia_id;
	}
	public Comune getComune_id() {
		return Comune_id;
	}
	public void setComune_id(Comune comune_id) {
		Comune_id = comune_id;
	}
	public int getCadenza() {
		return cadenza;
	}
	public void setCadenza(int cadenza) {
		this.cadenza = cadenza;
	}
	public java.sql.Date getDataProxEmail() {
		return dataProxEmail;
	}
	public void setDataProxEmail(java.sql.Date dataProxEmail) {
		this.dataProxEmail = dataProxEmail;
	}

	
}

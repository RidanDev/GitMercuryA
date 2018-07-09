package it.mercurya.model;

import java.sql.Date;

public class Newsletter {
	
	String Utente_email;
	Genere Genere_nome;
	Regione Regione_id;
	Provincia Provincia_id;
	Comune Comune_id;
	String cadenza; //intero o stringa?!?!?!?!?!?!?!?!
	Date dataProxEmail;
	
	public Newsletter() {
		
		super();
		
	}

	public String getUtentebyemail(String email) {
		return Utente_email;
	}

	public void setUtentebyemail(String utente_email) {
		Utente_email = utente_email;
	}

	public Genere getGenerebynome() {
		return Genere_nome;
	}

	public void setGenerebynome(Genere genere_nome) {
		Genere_nome = genere_nome;
	}

	public Regione getRegionebyid() {
		return Regione_id;
	}

	public void setRegionebyid(Regione regione_id) {
		Regione_id = regione_id;
	}

	public Provincia getProvinciabyid() {
		return Provincia_id;
	}

	public void setProvinciabyid(Provincia provincia_id) {
		Provincia_id = provincia_id;
	}

	public Comune getComunebyid() {
		return Comune_id;
	}

	public void setComune_byid(Comune comune_id) {
		Comune_id = comune_id;
	}

	public String getCadenza() {
		return cadenza;
	}

	public void setCadenza(String cadenza) {
		this.cadenza = cadenza;
	}

	public Date getDataProxEmail() {
		return dataProxEmail;
	}

	public void setDataProxEmail(Date dataProxEmail) {
		this.dataProxEmail = dataProxEmail;
	}
	
	
	

}

package it.mercurya.model;

import java.io.Serializable;

/*
 * ALESSIO
 */

public class Ruolo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

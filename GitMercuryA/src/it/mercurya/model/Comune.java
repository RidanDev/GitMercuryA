package it.mercurya.model;
import java.io.Serializable;

/*
 * ALESSIO
 */

public class Comune implements Serializable {
	private int id;
	private String nome;
	private Provincia provincia;

	public Comune() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Provincia getProvincia_id() {
		return this.provincia;
	}

	public void setProvincia_id(Provincia provincia) {
		this.provincia = provincia;
	}
	
	

}

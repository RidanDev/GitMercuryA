
package it.mercurya.model;

public class Provincia {
	private int id;
	private String nome;
	private Regione Regione_id;
	
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

	public Regione getRegione_id() {
		return Regione_id;
	}

	public void setRegione_id(Regione regione_id) {
		Regione_id = regione_id;
	}
	
	
}

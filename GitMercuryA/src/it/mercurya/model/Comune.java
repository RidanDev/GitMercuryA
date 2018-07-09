package it.mercurya.model;

public class Comune {
	String nome;
	int id;
	Provincia Provincia_id;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Provincia getProvincia_id() {
		return Provincia_id;
	}
	public void setProvincia_id(Provincia provincia_id) {
		Provincia_id = provincia_id;
	}
	
}

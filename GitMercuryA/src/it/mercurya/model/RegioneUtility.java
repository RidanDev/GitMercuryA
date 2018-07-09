package it.mercurya.model;

import java.util.ArrayList;

public interface RegioneUtility {
	public Regione getRegioneById(int id);
	public ArrayList<Regione> getAllRegioni();
	public int deleteRegioneById(int id);
}

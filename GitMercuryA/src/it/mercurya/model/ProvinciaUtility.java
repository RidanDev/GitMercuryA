//faysar

package it.mercurya.model;
import java.util.ArrayList;


public interface ProvinciaUtility {
	public Provincia getProvinciaById(int id);
	public ArrayList<Provincia> getAllProvincie();
	public ArrayList<Provincia> getAllProvincieByNomeRegione(String nome_regione);
	public int deleteProvinciaById(int id);
	
}

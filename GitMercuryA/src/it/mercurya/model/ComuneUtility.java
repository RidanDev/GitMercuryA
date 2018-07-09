package it.mercurya.model;

import java.util.ArrayList;

/*
 * ALESSIO
 */

public interface ComuneUtility {
	public Comune getComuneById(int id);
	public int deleteComuneById(int id); //Ritorna 0 se operazione ok, -1 altrimenti
	public ArrayList<Comune> getAllComuni();
	public ArrayList<Comune> getAllComuniByProvincia(String provincia);
	//public int addComune(int id,String nome, Provincia p);
	//public int changeComune(String nome, Provincia p);
}

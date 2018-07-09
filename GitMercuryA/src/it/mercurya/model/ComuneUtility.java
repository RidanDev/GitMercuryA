package it.mercurya.model;

import java.util.ArrayList;

public interface ComuneUtility {
	public Comune getComuneById(int id);
	public ArrayList<Comune> getAllComuni();
	public ArrayList<Comune> getAllComuniByProvincia(int id_provincia);
	public int deleteComuneById(int id);
}

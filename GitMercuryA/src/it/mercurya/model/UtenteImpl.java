package it.mercurya.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.mercurya.dao.Dao;

public class UtenteImpl implements UtenteUtility{
	
	private Utente u=null;
	private ArrayList<Utente> UtentiList;

	@Override
	public Utente getUtenteByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUtenteByEmail(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Utente> getAllUtenti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setUtente(String email, Ruolo r) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}

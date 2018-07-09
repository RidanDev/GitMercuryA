package it.mercurya.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Dao {
	
	private static Connection conn=null;
	private static DataSource ds = null;
	
	private Dao() {
		
		Context initCtx=null;
		Context enxCtx=null;
		
		try {
			
			initCtx = new InitialContext();
			enxCtx = (Context)initCtx.lookup("java:comp/env");
			ds = (DataSource)enxCtx.lookup("jdbc/mydb");
			
		}
		
		catch (NamingException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static Connection getConnection() {
		
		if(ds==null) {
			
			new Dao();
			
		}
		
		try {
			
			conn=ds.getConnection();
			
		}catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
			return conn;
				
	}	
	

}



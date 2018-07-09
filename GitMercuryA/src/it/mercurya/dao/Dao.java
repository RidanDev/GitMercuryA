package it.mercurya.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Dao {
		private static Connection conn = null;
		private static DataSource ds = null;
		
		private Dao() {
				
			Context initCtx = null;
			Context envCtx = null;
			
			try {
				initCtx = new InitialContext();
				envCtx = (Context)initCtx.lookup("java:comp/env");
				
				ds = (DataSource)envCtx.lookup("jdbc/mydb");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		public static Connection getConnection() {
			if(ds == null) {
				new Dao();
			}
			
			try {
				conn = ds.getConnection();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return conn;
			
		}
		
}


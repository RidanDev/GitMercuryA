package it.mercurya.dao;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mercurya.dao.Dao;

/**
 * Servlet implementation class TestConn
 */
@WebServlet("/TestConn")
public class TestConn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = Dao.getConnection();
		PrintWriter out=response.getWriter();
		
		try {
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from utente");
			
			while(rs.next()) {
				out.println("Email: " + rs.getString("email"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}

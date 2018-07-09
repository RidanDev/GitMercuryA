package it.mercurya.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestDao
 */
@WebServlet("/TestDao")
public class TestDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		
		try {
			conn = Dao.getConnection();
			
			// Qua proviamo una query:
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from provincia");
			while (rs.next()) {
				out.println("ID: " + rs.getInt("id") + "<br>");
				out.println("Nome: " + rs.getString("nome") + "<br>");
				out.println("---------------------------------------" + "<br>");
			}
			
			// RICORDA CHE: a questo punto il ResultSet rs è VUOTO (quindi non puoi tornare al primo elemento, ma si svuota mentre scorri con rs.next())
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

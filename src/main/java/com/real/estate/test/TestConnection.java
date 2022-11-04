package com.real.estate.test;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.real.estate.model.Admin;


/**
 * Servlet implementation class TestConnection
 */
public class TestConnection extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/realestate")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		PrintWriter out = response.getWriter();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from admin;");
			
			while (rs.next()) {
				Admin result = new Admin(
						rs.getInt("id"),
						rs.getString("username"), 
						rs.getString("email"), 
						rs.getString("password"), 
						rs.getString("phone"), 
						rs.getString("address"),
						rs.getString("role"));
				
				out.println(result+"\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

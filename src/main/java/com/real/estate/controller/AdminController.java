package com.real.estate.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import com.real.estate.model.Admin;
import com.real.estate.model.AdminDAO;


/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	@Resource(name = "jdbc/realestate")
	private DataSource dataSource;
	private AdminDAO adminDAO;
	
	@Override
	public void init() throws ServletException {
		adminDAO = new AdminDAO(dataSource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "SIGNUP";
		}
		
		switch (mode) {
		case "SIGNUP":
			signup(request, response);
			break;
		default:
			signup(request, response);
			break;
		}
	}

	private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone    = request.getParameter("phone");
		String address  = request.getParameter("address");
		boolean adminOk = Boolean.parseBoolean(request.getParameter("role"));
		String role = adminOk ? "admin" : "user";
		
		Admin admin = new Admin(username, email, password, phone, address, role);
		
		int rowEffected = this.adminDAO.createAdmin(admin);
		
		if(rowEffected > 0)
			//System.out.println("Successful");
			response.sendRedirect("login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

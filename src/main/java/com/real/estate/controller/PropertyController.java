package com.real.estate.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.tomcat.jakartaee.commons.io.IOUtils;

import com.real.estate.model.Admin;
import com.real.estate.model.Property;
import com.real.estate.model.PropertyDAO;


/**
 * Servlet implementation class PropertyController
 */
@MultipartConfig(maxFileSize=16177215)
public class PropertyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Resource(name = "jdbc/realestate")
	private DataSource dataSource;

	private PropertyDAO propertyDAO;
	
	@Override
	public void init() throws ServletException {
		propertyDAO = new PropertyDAO(dataSource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Admin admin = (Admin) session.getAttribute("admin");
		
		if (admin != null) { 
		String mode = request.getParameter("mode");
		if(mode == null) {
			if(admin.getRole().equals("admin"))
			{
				mode = "PROPERTYLIST";
			}
			else {
				mode = "LIST";
			}
			
		}
		
		switch (mode) {
		case "LIST":
			showPropertyList(request, response);
			break;
		case "PROPERTYLIST":
			showPropertyAdminList(request, response);
			break;
		case "LOAD":
			loadProperty(request, response);
			break;
		case "SEARCH":
			searchProperty(request, response);
			break;
		case "CREATE":
			createProperty(request, response);
			break;
		case "LOGOUT":
			session.invalidate();
			response.sendRedirect("login");
			break;
		case "UPDATE":
			updateProperty(request, response);
			break;
		case "DELETE":
			deleteProperty(request, response);
			break;
		default:
			showPropertyList(request, response);
			break;
		}
	}	
	else {
			response.sendRedirect("admin");
		}
	}	
		
	
	private void showPropertyList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		List<Property> propertyList = this.propertyDAO.getPropertyList();
		request.setAttribute("propertyList", propertyList);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}
	private void showPropertyAdminList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		List<Property> propertyList = this.propertyDAO.getPropertyList();
		request.setAttribute("propertyList", propertyList);
		RequestDispatcher rd = request.getRequestDispatcher("property-list.jsp");
		rd.forward(request, response);
		
	}
	
	private void searchProperty(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		String searchName = request.getParameter("propertySearch");
		List<Property> propertyList = this.propertyDAO.getPropertySearchList(searchName);
		request.setAttribute("propertyList", propertyList);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}
	private void createProperty(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		String status = request.getParameter("status");
		String address = request.getParameter("address");
		
		InputStream inputStream = null;
        
        Part filePart = request.getPart("photo");
        if (filePart != null) {
           
            inputStream = filePart.getInputStream();
        }
        Blob image = null;
        byte[] content = IOUtils.toByteArray(inputStream);
        try {
            image = new SerialBlob(content);//debugger says content is empty here
        }
        catch (SerialException e) {e.printStackTrace();}
        catch (SQLException e) {e.printStackTrace();}
		
        
        
        int area = Integer.parseInt(request.getParameter("area"));
		int room = Integer.parseInt(request.getParameter("room"));
		
		Property property = new Property(name, description, price, status, address, image, area, room);
		
		int rowEffected = this.propertyDAO.createProperty(property);
		
		if(rowEffected > 0)
			showPropertyAdminList(request, response);
		
	}
	
	private void loadProperty(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		int id = Integer.parseInt(request.getParameter("id"));
		Property property = this.propertyDAO.getProperty(id);
		request.setAttribute("property", property);
		RequestDispatcher rd = request.getRequestDispatcher("property-update.jsp");
		rd.forward(request, response);
	}
	
	private void updateProperty(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		String status = request.getParameter("status");
		String address = request.getParameter("address");
		int area = Integer.parseInt(request.getParameter("area"));
		int room = Integer.parseInt(request.getParameter("room"));
		Property result = new Property(id, name, description, price, status, address, area, room);
		
		int rowEffected = this.propertyDAO.updateProperty(result);
		
		if(rowEffected > 0)
			showPropertyAdminList(request, response);
	}
	
	private void deleteProperty(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		int id = Integer.parseInt(request.getParameter("id"));
		int rowEffected = this.propertyDAO.deleteProperty(id);
		
		if(rowEffected > 0)
			showPropertyAdminList(request, response);
	}
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

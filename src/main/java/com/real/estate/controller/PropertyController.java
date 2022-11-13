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

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.tomcat.jakartaee.commons.io.IOUtils;

import com.real.estate.model.Admin;
import com.real.estate.model.Order;
import com.real.estate.model.OrderDAO;
import com.real.estate.model.OrderDetail;
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
	private OrderDAO orderDAO;
	
	@Override
	public void init() throws ServletException {
		propertyDAO = new PropertyDAO(dataSource);
		orderDAO = new OrderDAO(dataSource);
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
		case "DETAIL":
			detailProperty(request, response);
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
		case "ADDORDER":
			orderProperty(request, response);
			break;
		case "ORDERDETAIL":
			orderDetail(request, response);
			break;
		case "DELETEORDER":
			deleteOrder(request, response);
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
		int price = Integer.parseInt(request.getParameter("price"));
		int status = Integer.parseInt(request.getParameter("status"));
		int type = Integer.parseInt(request.getParameter("type"));
		List<Property> propertyList = this.propertyDAO.getPropertySearchList(price, status, type);
		request.setAttribute("propertyList", propertyList);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}
	private void detailProperty(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		int id = Integer.parseInt(request.getParameter("id"));
		Property propertyDetail = this.propertyDAO.getProperty(id);
		request.setAttribute("propertyDetail", propertyDetail);
		RequestDispatcher rd = request.getRequestDispatcher("property-detail.jsp");
		rd.forward(request, response);
		
	}
	private void createProperty(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		String type = request.getParameter("type");
		int price = Integer.parseInt(request.getParameter("price"));
		int room = Integer.parseInt(request.getParameter("room"));
		int bedRoom = Integer.parseInt(request.getParameter("bedRoom"));
		int area = Integer.parseInt(request.getParameter("area"));
		
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
		
        
		Property property = new Property(name, description, price, status, address, image, area, room, bedRoom, type);
		
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
		int bedRoom = Integer.parseInt(request.getParameter("bedRoom"));
		String type = request.getParameter("type");
		Property result = new Property(id, name, description, price, status, address, area, room, bedRoom, type);
		
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
	
	private void orderProperty(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		int userId = Integer.parseInt(request.getParameter("userId"));
		int propertyId = Integer.parseInt(request.getParameter("id"));
		String message = request.getParameter("message");
		
		Order order = new Order(userId, propertyId, message);
		
		int rowEffected = this.orderDAO.addOrderProperty(order);
		
		if(rowEffected > 0)
			showPropertyAdminList(request, response);
		
	}
	private void orderDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		List<OrderDetail> orderList = this.orderDAO.getOrderDetail();
		request.setAttribute("orderList", orderList);
		RequestDispatcher rd = request.getRequestDispatcher("order-detail.jsp");
		rd.forward(request, response);
		
	}
	private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		request.setAttribute("admin",admin);
		int id = Integer.parseInt(request.getParameter("id"));
		int rowEffected = this.orderDAO.getDeleteOrder(id);
		
		if(rowEffected > 0)
			orderDetail(request, response);
	}
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

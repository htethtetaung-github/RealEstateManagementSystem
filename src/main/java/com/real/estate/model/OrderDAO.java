package com.real.estate.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class OrderDAO {
	
	private final DataSource dataSource;

	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	

	public OrderDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	private void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int addOrderProperty(Order orders) throws FileNotFoundException {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();

			pStmt = connection.prepareStatement("INSERT INTO `order` (`admin_id`, `property_id`, `message`) VALUES (?,?,?);");

			pStmt.setInt(1, orders.getUserId());
			pStmt.setInt(2, orders.getPropertyId());
			pStmt.setString(3, orders.getMessage());

			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowEffected;
	}
	
	public List<OrderDetail> getOrderDetail() throws IOException {
		List<OrderDetail> orderList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"SELECT t2.username, t2.email, t3.property_name, t3.description, t3.area, t3.price, t3.no_of_rooms as roomNumber,"
					+ " t3.no_of_bedrooms as bedRoomNumber, t1.message "
					+ "FROM realestatedb.order t1 "
					+ "INNER JOIN realestatedb.admin t2  "
					+ "ON t1.admin_id = t2.id "
					+ "INNER JOIN realestatedb.property t3 "
					+ "ON t1.property_id = t3.property_id;");

			while (rs.next()) {

				orderList.add(new OrderDetail(rs.getString("username"), rs.getString("email"),
						rs.getString("property_name"), rs.getString("description"), rs.getInt("area"), rs.getInt("price"),
						rs.getInt("roomNumber"), rs.getInt("bedRoomNumber"),rs.getString("message")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return orderList;

	}
	
	public int getDeleteOrder(int id) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("delete from order where id = ?;");
			pStmt.setInt(1, id);
			rowEffected = pStmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowEffected;

	}


}

package com.real.estate.model;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

public class PropertyDAO {

	private DataSource dataSource;

	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;

	public PropertyDAO(DataSource dataSource) {
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

	public List<Property> getPropertyList() throws IOException {
		List<Property> propertyList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"select property_id as id,property_name as name, description, price, property_status as status, address,property_img as photo, "
					+ "area, no_of_rooms as room, no_of_bedrooms as bedroom, property_type as type  from property;");

			while (rs.next()) {
				Blob blob = rs.getBlob("photo");

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				inputStream.close();
				outputStream.close();

				propertyList.add(new Property(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getInt("price"), rs.getString("status"), rs.getString("address"), base64Image,
						rs.getInt("area"), rs.getInt("room"),rs.getInt("bedroom"), rs.getString("type")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return propertyList;

	}

	public List<Property> getPropertySearchList(int price, int status, int type) throws IOException {
		List<Property> propertyList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select property_id as id, property_name as name, description, price,"
					+ " property_status as status,"
					+ " address, property_img as photo,"
					+ " area,"
					+ " no_of_rooms as room,"
					+ " no_of_bedrooms as bedroom," 
					+ " property_type as type from property where price <='"+price+"' AND property_status = '"+status+"' AND property_type = '"+type+"';");

			while (rs.next()) {
				Blob blob = rs.getBlob("photo");

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				inputStream.close();
				outputStream.close();

				propertyList.add(new Property(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getInt("price"), rs.getString("status"), rs.getString("address"), base64Image,
						rs.getInt("area"), rs.getInt("room"), rs.getInt("bedroom"), rs.getString("type")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return propertyList;

	}

	public Property getProperty(int id) {
		Property property = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from property where property_id='" + id + "';");

			if (rs.next()) {

				property = new Property(rs.getInt("property_id"), rs.getString("property_name"),
						rs.getString("description"), rs.getInt("price"), rs.getString("property_status"),
						rs.getString("address"), rs.getBlob("property_img"), rs.getInt("area"),
						rs.getInt("no_of_rooms"), rs.getInt("no_of_bedrooms"), rs.getString("property_type"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return property;

	}

	public int createProperty(Property property) throws FileNotFoundException {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();

			pStmt = connection.prepareStatement("INSERT INTO `property` "
					+ "(`property_name`, `description`, `price`, `property_status`, `address`, `property_img`,`area`,`no_of_rooms`, `no_of_bedrooms`,`property_type`) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?);");

			pStmt.setString(1, property.getPropertyName());
			pStmt.setString(2, property.getDescription());
			pStmt.setInt(3, property.getPrice());
			pStmt.setString(4, property.getPropertyStatus());
			pStmt.setString(5, property.getAddress());
			pStmt.setBlob(6, property.getPropertyImg());
			pStmt.setInt(7, property.getArea());
			pStmt.setInt(8, property.getRoomNumber());
			pStmt.setInt(9, property.getBedRoomNumber());
			pStmt.setString(10, property.getPropertyType());

			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowEffected;
	}

	public int updateProperty(Property property) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();

			pStmt = connection.prepareStatement("UPDATE `property` SET " + "`property_name` = ?, "
					+ "`description` = ?, " + "`price` = ?, " + "`property_status` = ?, " + "`address` = ?, "
					+ "`area` = ? , " + "`no_of_rooms` = ? , " + "`no_of_bedrooms` = ? , " + "`property_type` = ? WHERE (`property_id` = ?);");
			pStmt.setString(1, property.getPropertyName());
			pStmt.setString(2, property.getDescription());
			pStmt.setInt(3, property.getPrice());
			pStmt.setString(4, property.getPropertyStatus());
			pStmt.setString(5, property.getAddress());
			pStmt.setInt(6, property.getArea());
			pStmt.setInt(7, property.getRoomNumber());
			pStmt.setInt(8, property.getBedRoomNumber());
			pStmt.setString(9, property.getPropertyType());
			pStmt.setInt(10, property.getPropertyId());
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowEffected;
	}

	public int deleteProperty(int id) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("delete from property where property_id = ?;");
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

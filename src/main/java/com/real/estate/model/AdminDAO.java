package com.real.estate.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


public class AdminDAO {
		
		private final DataSource dataSource;
		
		private Connection connection;
		private Statement stmt;
		private PreparedStatement pStmt;
		private ResultSet rs;

		public AdminDAO(DataSource dataSource) {
			super();
			this.dataSource = dataSource;
		}
		
		private void close() {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public Admin getAdminByEmail(String email) {
			Admin admin = null;
			try {
				connection = dataSource.getConnection();
				stmt = connection.createStatement();
				rs = stmt.executeQuery("select * from admin where email='"+email+"';");
				
				while (rs.next()) {
					admin = new Admin(
							rs.getString("username"), 
							rs.getString("email"), 
							rs.getString("password"), 
							rs.getString("phone"), 
							rs.getString("address"),
							rs.getString("role"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}
			return admin;
		}
		
		/*
		 * public boolean isValidUser(String email,String originalPassword) { admin user
		 * = getUserByEmail(email); boolean valid = false;
		 * 
		 * if(user != null) { String storedPassword = user.getPassword(); try { valid =
		 * PasswordValidator.validatePassword(originalPassword, storedPassword); } catch
		 * (NoSuchAlgorithmException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (InvalidKeySpecException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } } return valid; }
		 */
		
		public int createAdmin(Admin admin) {
			int rowEffected = 0;
			try {
				connection = dataSource.getConnection();
				
				pStmt = connection.prepareStatement(
						"INSERT INTO `admin` "
						+ "(`username`, `email`, `password`, `phone`, `address`, `role`) "
						+ "VALUES (?,?,?,?,?,?);"
						);
				pStmt.setString(1,admin.getUsername());
				pStmt.setString(2,admin.getEmail());
				
				/*
				 * String securedPassword = null; try { securedPassword =
				 * PasswordEncoder.encode(user.getPassword()); } catch (NoSuchAlgorithmException
				 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
				 * (InvalidKeySpecException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); }
				 */
				pStmt.setString(3,admin.getPassword());
				pStmt.setString(4,admin.getPhone());
				pStmt.setString(5,admin.getAddress());
				pStmt.setString(6,admin.getRole());
				
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

package com.gil.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gil.example.beans.UserDetails;

@Repository
public class UsersManager {
	
	@Autowired
	private ConnectionPool connectionPool;

	public void persistUser(UserDetails userDetails) {
	
		Connection conn = null; 
		PreparedStatement ps = null;

		try {
			System.out.println("Connecting to the selected DataBase...");
			conn = connectionPool.datasource().getConnection();
			System.out.println("Successfully connected to the DataBase$$$$$$$$...");


			// insert company details:

			String sql = "insert into USERS "
					+    "(FIRSTNAME , LASTNAME ,EMAIL, PASSWORD, START_DATE, END_DATE)"
					+    "values ( ? , ? , ?, ?, ?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, userDetails.getFirstName());
			ps.setString(2, userDetails.getLastName());
			ps.setString(3, userDetails.getEmail());
			ps.setString(4, userDetails.getPassword());
			ps.setString(5, userDetails.getStart_date());
			ps.setString(6, userDetails.getEnd_date());
			
			ps.executeUpdate();
		}
			catch(Exception e){
				e.printStackTrace();
			}

		finally{
			try {
				ps.close();

				if (conn!=null) try {conn.close();}catch (Exception ignore) {}
				System.out.println("CONNECTION RETURNED");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

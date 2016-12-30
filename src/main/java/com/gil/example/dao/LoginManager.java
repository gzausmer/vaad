package com.gil.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gil.example.beans.LoginDetails;
import com.gil.example.beans.UserDetails;

@Repository
public class LoginManager {
	
	@Autowired
	private ConnectionPool connectionPool;

	public UserDetails checkCredentials(LoginDetails loginDetails) {

		UserDetails userDetails;
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet myRs = null;
		

		try {
			System.out.println("Connecting to the selected DataBase...");
			conn = connectionPool.datasource().getConnection();
			System.out.println("Successfully connected to the DataBase$$$$$$$$...");

			// insert company details:

			String sql = "SELECT * FROM users WHERE EMAIL = ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, loginDetails.getEmail());
			System.out.println(loginDetails.getEmail());
			
			myRs = ps.executeQuery();
			System.out.println(myRs.toString());
			//Check if password and company name correct:

			if(myRs.next()){

				if(myRs.getString("PASSWORD").equals(loginDetails.getPassword())){
					
					userDetails = new UserDetails();
					userDetails.setFirstName(myRs.getString("FIRSTNAME"));
					userDetails.setRole(myRs.getString("ROLE"));
					return userDetails;
				}
			}
			
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
		return null;
	}
}

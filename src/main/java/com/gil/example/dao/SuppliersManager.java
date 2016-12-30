package com.gil.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gil.example.beans.Supplier;
import com.gil.example.beans.UserDetails;

@Repository
public class SuppliersManager {
	
	@Autowired
	private ConnectionPool connectionPool;

	public void persistSupplier(Supplier supplier) {
	
		Connection conn = null; 
		PreparedStatement ps = null;

		try {
			System.out.println("Connecting to the selected DataBase...");
			conn = connectionPool.datasource().getConnection();
			System.out.println("Successfully connected to the DataBase$$$$$$$$...");


			// insert company details:

			String sql = "insert into suppliers"
					+    "(NAME , PROFESSION ,PHONE, EMAIL, COMPANY, BUISNESS_NUMBER)"
					+    "values ( ? , ? , ?, ?, ?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, supplier.getName());
			ps.setString(2, supplier.getProfession());
			ps.setString(3, supplier.getPhone());
			ps.setString(4, supplier.getEmail());
			ps.setString(5, supplier.getCompany());
			ps.setString(6, supplier.getBuisness_number());
			
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
	
	public ArrayList<Supplier> getAllSuppliers() throws Exception{

		ArrayList<Supplier> allSuppliers = new ArrayList<Supplier>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet myRs = null;

		try{
			System.out.println("Connecting to the selected DataBase...");
			conn = connectionPool.datasource().getConnection();
			System.out.println("Successfully connected to the DataBase...");

			System.out.println("Creating Statement...");

			ps = conn.prepareStatement("SELECT * FROM suppliers");

			myRs = ps.executeQuery();

			while (myRs.next()){
				int intID1 = myRs.getInt("ID");
				String NAME = myRs.getString("NAME");
				
				String PROFESSION =  myRs.getString("PROFESSION");
				String PHONE =  myRs.getString("PHONE");
				String EMAIL = myRs.getString("EMAIL");
				String COMPANY = myRs.getString("COMPANY"); 
				String BUISNESS_NUMBER = myRs.getString("BUISNESS_NUMBER");
				
				Supplier supplier = new Supplier(intID1, NAME, PROFESSION, PHONE, EMAIL,COMPANY, BUISNESS_NUMBER);
				System.out.println(supplier + "************************");
				allSuppliers.add(supplier);
			}
			System.out.println("all suppliers returned" + allSuppliers);
			return allSuppliers;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();

				if (conn!=null) try {conn.close();}catch (Exception ignore) {}
				System.out.println("CONNECTION RETURNED");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return allSuppliers;
		
	}
}

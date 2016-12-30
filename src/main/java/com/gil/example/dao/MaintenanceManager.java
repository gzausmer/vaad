package com.gil.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gil.example.beans.EventMaintenance;

import com.gil.example.beans.ScheduledMaintenance;
import com.gil.example.beans.Supplier;
import com.gil.example.beans.UserDetails;

@Repository
public class MaintenanceManager {
	
	@Autowired
	private ConnectionPool connectionPool;

	public void persistScheduledMaintenance(ScheduledMaintenance scheduledMaintenance) {
	
		Connection conn = null; 
		PreparedStatement ps = null;

		try {
			System.out.println("Connecting to the selected DataBase...");
			conn = connectionPool.datasource().getConnection();
			System.out.println("Successfully connected to the DataBase$$$$$$$$...");


			// insert company details:

			String sql = "insert into scheduledMaintenance"
					+    "(SYSTEM , PRIORITY ,TYPE, LAST_CHECK, START_ON, SERVICE_FREQ_NUMBER,SERVICE_FREQ_EACH,SERVICE_FREQ_TIME,SUPPLIER,CONTRACT, STATUS)"
					+    "values ( ? , ? , ?, ?, ?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, scheduledMaintenance.getSystem());
			ps.setString(2, scheduledMaintenance.getPriority());
			ps.setString(3, scheduledMaintenance.getType());
			ps.setString(4, scheduledMaintenance.getLastCheck());
			ps.setString(5, scheduledMaintenance.getStartOn());
			ps.setString(6, scheduledMaintenance.getServiceFreqNumber());
			ps.setString(7, scheduledMaintenance.getServiceFreqEach());
			ps.setString(8, scheduledMaintenance.getServiceFreqTime());
			ps.setString(9, scheduledMaintenance.getSupplier());
			ps.setString(10, scheduledMaintenance.getContract());
			ps.setString(11, "open");
			
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
	
	public void mergeEventMaintenanceStatus(EventMaintenance eventMaintenance) {
		
		Connection conn = null; 
		PreparedStatement ps = null;
		
		try {
			System.out.println("Connecting to the selected DataBase...");
			conn = connectionPool.datasource().getConnection();
			System.out.println("Successfully connected to the DataBase$$$$$$$$...");


			// insert company details:

			String sql = "UPDATE eventMaintenance SET STATUS="+ "'" + eventMaintenance.getStatus() + "'"+
					",NOTIFICATION_SENT="+eventMaintenance.getNotificationSent()+
						" WHERE ID="+eventMaintenance.getId()+";";
			
			ps = conn.prepareStatement(sql);
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
	
	public void persistEventMaintenance(EventMaintenance eventMaintenance) {
	
		Connection conn = null; 
		PreparedStatement ps = null;
		

		try {
			System.out.println("Connecting to the selected DataBase...");
			conn = connectionPool.datasource().getConnection();
			System.out.println("Successfully connected to the DataBase$$$$$$$$...");


			// insert company details:

			String sql = "INSERT INTO eventMaintenance"
					+    "(BUILDING,LOCATION,PROBLEM,DESCRIPTION,PHOTO, STATUS, SENDER)"
					+    "VALUES (?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, eventMaintenance.getBuilding());
			ps.setString(2, eventMaintenance.getLocation());
			ps.setString(3, eventMaintenance.getNatureOfProblem());
			ps.setString(4, eventMaintenance.getDescription());
			ps.setString(5, eventMaintenance.getPhoto());
			ps.setString(6, "unread");
			ps.setString(7, eventMaintenance.getSender());
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
	
	public ArrayList<EventMaintenance> findEventMaintenanceJobs() throws Exception{

		ArrayList<EventMaintenance> eventMaintenanceList = new ArrayList<EventMaintenance>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet myRs = null;

		try{
			System.out.println("Connecting to the selected DataBase...");
			conn = connectionPool.datasource().getConnection();
			System.out.println("Successfully connected to the DataBase...");

			System.out.println("Creating Statement...");

			ps = conn.prepareStatement("SELECT * FROM eventMaintenance");

			myRs = ps.executeQuery();

			while (myRs.next()){
				int intID1 = myRs.getInt("ID");
				String BUILDING = myRs.getString("BUILDING");
				String LOCATION =  myRs.getString("LOCATION");
				String PROBLEM =  myRs.getString("PROBLEM");
				String DESCRIPTION = myRs.getString("DESCRIPTION");
				String PHOTO = myRs.getString("PHOTO"); 
				String STATUS = myRs.getString("STATUS"); 
				String SENDER = myRs.getString("SENDER");
				boolean NOTIFICATION_SENT = myRs.getBoolean("NOTIFICATION_SENT");
				
				EventMaintenance eventMaintenance = new EventMaintenance(intID1, BUILDING, LOCATION, PROBLEM, DESCRIPTION,PHOTO, STATUS, SENDER, NOTIFICATION_SENT);
				System.out.println(eventMaintenance + "************************");
				eventMaintenanceList.add(eventMaintenance);
			}
			System.out.println("all suppliers returned" + eventMaintenanceList);
			return eventMaintenanceList;
			
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
		return eventMaintenanceList;	
	}
	
	public ArrayList<ScheduledMaintenance> findScheduledMaintenanceJobs() throws Exception{

		ArrayList<ScheduledMaintenance> scheduledMaintenanceList = new ArrayList<ScheduledMaintenance>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet myRs = null;

		try{
			System.out.println("Connecting to the selected DataBase...");
			conn = connectionPool.datasource().getConnection();
			System.out.println("Successfully connected to the DataBase...");

			System.out.println("Creating Statement...");

			ps = conn.prepareStatement("SELECT * FROM scheduledMaintenance");

			myRs = ps.executeQuery();

			while (myRs.next()){
				int intID1 = myRs.getInt("ID");
				String SYSTEM = myRs.getString("SYSTEM");
				String PRIORITY =  myRs.getString("PRIORITY");
				String TYPE =  myRs.getString("TYPE");
				String LAST_CHECK = myRs.getString("LAST_CHECK");
				String START_ON = myRs.getString("START_ON"); 
				String SERVICE_FREQ_NUMBER = myRs.getString("SERVICE_FREQ_NUMBER");
				String SERVICE_FREQ_EACH =  myRs.getString("SERVICE_FREQ_EACH");
				String SERVICE_FREQ_TIME =  myRs.getString("SERVICE_FREQ_TIME");
				String SUPPLIER = myRs.getString("SUPPLIER");
				String CONTRACT = myRs.getString("CONTRACT"); 
				String STATUS = myRs.getString("STATUS");
				boolean NOTIFICATION_SENT = myRs.getBoolean("NOTIFICATION_SENT");
				
				ScheduledMaintenance scheduledMaintenance = new ScheduledMaintenance(intID1, SYSTEM, 
						PRIORITY, TYPE, LAST_CHECK,START_ON,SERVICE_FREQ_NUMBER,SERVICE_FREQ_EACH,
				SERVICE_FREQ_TIME, SUPPLIER, CONTRACT,STATUS, NOTIFICATION_SENT);
				System.out.println(scheduledMaintenance + "************************");
				scheduledMaintenanceList.add(scheduledMaintenance);
			}
			System.out.println("all suppliers returned" + scheduledMaintenanceList);
			return scheduledMaintenanceList;
			
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
		return scheduledMaintenanceList;	
	}
	
}

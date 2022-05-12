package com.carRentalAdminResources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc_connection {
	
	public static Connection getconnect() throws ClassNotFoundException
	{
		Connection c = null;
		 
	  
		 
	        Class.forName("org.postgresql.Driver");
	        try {
				c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CarRentalSystem","postgres", "yaso4456");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;
	}
 

}
 

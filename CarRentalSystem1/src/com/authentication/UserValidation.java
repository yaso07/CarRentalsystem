package com.authentication;

import java.sql.*;

public class UserValidation {


	Connection c = null;
	 
     public static Connection getconnect() throws ClassNotFoundException
     {
	    Connection c=null;
        Class.forName("org.postgresql.Driver");
        try {
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CarRentalSystem","postgres", "yaso4456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
     }
     public static Boolean validation(String username, String password) throws ClassNotFoundException, SQLException
     {
    	   Boolean valid=false;
    	   Connection connect=getconnect();
    	   PreparedStatement ps=connect.prepareStatement("select * from admin_table");
    	   ResultSet rs=ps.executeQuery();
    	   while(rs.next())
    	   {
    		   if(username.equals(rs.getString(1)) && password.equals(rs.getString(2)))
    		   {
    			   valid=true;
    		   }
    	   }
    	   
    	 
		return valid;
    	 
     }
}

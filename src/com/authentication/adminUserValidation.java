package com.authentication;

import java.sql.*;

public class adminUserValidation{


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
    
	public static Boolean uservalidation(String username, String password) throws SQLException, ClassNotFoundException {
	   Boolean valid=false;
	   Connection connect=getconnect();
  	   PreparedStatement ps=connect.prepareStatement("select username,password from userdetails");
  	   ResultSet rs=ps.executeQuery();
  	   while(rs.next())
  	   {
  		  
  		   if(username.equals(rs.getString(1)) && password.equals(rs.getString(2)))
  		   {
  			 valid=true;
  			 System.out.println(valid);
  		   }
  	   }
  	   
		


		return valid;
	}
}
 
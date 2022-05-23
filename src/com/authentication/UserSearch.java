package com.authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.carRentalAdminResources.jdbc_connection;

public class UserSearch {

	  static ArrayList<userdetails> usersearch=new ArrayList<>();
	  public static ArrayList<userdetails> searchUser(String option,String value) throws ClassNotFoundException, SQLException
      {
    	
    	  Connection connect=jdbc_connection.getconnect();  
    	  PreparedStatement ps=connect.prepareStatement("select firstname,lastname,userid from userdetails where \""+option +"\"=? order by userid asc");
    	  
    	  ps.setString(1, value);
    	  ResultSet rs=ps.executeQuery();
    	  
    	 
    	 
    	  usersearch.clear();
    	  while(rs.next())
    	  {
    		  userdetails user=new userdetails();
    		  user.setFirstname(rs.getString(1));
    		  user.setLastname(rs.getString(2));
    		  user.setId(rs.getInt(3));
    		  usersearch.add(user);
    	  }
    	  ps.close();
  		connect.close();
  		rs.close();
		 return usersearch;
    	  
      }
	  public static ArrayList<userdetails> filter()
	  {
	  	return usersearch;
	  }

}

package com.authentication;

import java.sql.*;
import java.util.ArrayList;

import com.carRentalAdminResources.jdbc_connection;

public class UserDetailsDb {

      public static void adduserdetails(userdetails user) throws ClassNotFoundException, SQLException
      {
    	  Connection connect=jdbc_connection.getconnect();
    	  String sql="insert into userdetails (firstname,lastname,username,email,password,"
    	  		+ "mobile,address1,address2,country,state,pincode)"
    	  		+ " values (?,?,?,?,?,?,?,?,?,?,?)";
    	  PreparedStatement ps1=connect.prepareStatement(sql);
    	 
    	  
    	  ps1.setString(1, user.getFirstname());
    	  ps1.setString(2,user.getLastname());
    	  ps1.setString(3,user.getUsername());
    	  ps1.setString(4,user.getEmail());
    	  ps1.setString(5,user.getPassword());
    	  ps1.setString(6,user.getMobile());
    	  ps1.setString(7, user.getAddress1());
    	  ps1.setString(8, user.getAddress2());
    	  ps1.setString(9, user.getCountry());
    	  ps1.setString(10, user.getState());
    	  ps1.setInt(11,user.getPincode());
    	  ps1.executeUpdate();
    	  ps1.close();
    	 
    	  connect.close();
    	  
      }
    
      public static  ArrayList<userdetails>  getuserdetails() throws ClassNotFoundException, SQLException
      {
    	  ArrayList<userdetails> userlist=new ArrayList<>();
    	  Connection connect=jdbc_connection.getconnect();  
    	  PreparedStatement ps=connect.prepareStatement("select firstname,lastname,userid from userdetails order by userid asc");
    	  ResultSet rs=ps.executeQuery();
    	 
    	  while(rs.next())
    	  {
    		  userdetails user=new userdetails();
    		  user.setFirstname(rs.getString(1));
    		  user.setLastname(rs.getString(2));
    		  user.setId(rs.getInt(3));
    		  userlist.add(user);
    	  }
    	  ps.close();
  		connect.close();
  		rs.close();
		 return userlist;
    	  
      }
    
      public static userdetails getuserdetails(String id) throws ClassNotFoundException, SQLException
      {
    	   
    	  int userid=Integer.parseInt(id);
          userdetails user=new userdetails();
    	  Connection connect=jdbc_connection.getconnect();
    	  PreparedStatement ps=connect.prepareStatement("select firstname,lastname,email,mobile,address1,address2,country,state,pincode from userdetails where userid=?");
    	
    	
    	  ps.setInt(1,userid);
    	  ResultSet rs=ps.executeQuery();
    	  while(rs.next())
    	  {
    		  user.setFirstname(rs.getString(1));
    		  user.setLastname(rs.getString(2));
    		  user.setEmail(rs.getString(3));
    		  user.setMobile(rs.getString(4));
    		  user.setAddress1(rs.getString(5));
    		  user.setAddress2(rs.getString(6));
    		  user.setCountry(rs.getString(7));
    		  user.setState(rs.getString(8));
    		  user.setPincode(Integer.parseInt(rs.getString(9)));
    		  
    	  }
    	    
    	  ps.close();
    	  rs.close();
  		connect.close();
    	  
		return user;
    	  
      }
	public static void deletemember(String email) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		 
		Connection c=jdbc_connection.getconnect();
		PreparedStatement ps=c.prepareStatement("delete from userdetails where email=?");
	    ps.setString(1, email);
	    ps.executeUpdate();
	    ps.close();
		 

	}
	 public static userdetails getdetails(String name) throws ClassNotFoundException, SQLException
     {
   	   
   	    
   
   	  userdetails user=new userdetails();
   	  Connection connect=jdbc_connection.getconnect();
   	  PreparedStatement ps=connect.prepareStatement("select firstname,lastname,email,mobile,address1,address2,country,state,pincode from userdetails where username=?");
   	
   	
   	  ps.setString(1,name);
   	  ResultSet rs=ps.executeQuery();
   	  while(rs.next())
   	  {
   		  user.setFirstname(rs.getString(1));
   		  user.setLastname(rs.getString(2));
   		  user.setEmail(rs.getString(3));
   		  user.setMobile(rs.getString(4));
   		  user.setAddress1(rs.getString(5));
   		  user.setAddress2(rs.getString(6));
   		  user.setCountry(rs.getString(7));
   		  user.setState(rs.getString(8));
   		  user.setPincode(Integer.parseInt(rs.getString(9)));
   		  
   	  }
   	    
   	   ps.close();
		connect.close();
   	  
		return user;
   	  
     }
	 public static void update(userdetails user,String username) throws ClassNotFoundException, SQLException
	 {
		 Connection connect=jdbc_connection.getconnect();
		 PreparedStatement ps=connect.prepareStatement("UPDATE public.userdetails"
		 		+ "	SET firstname=?, lastname=?, email=?,mobile=?, address1=?, address2=?, country=?, state=?, pincode=?"
		 		+ "	WHERE username=?");
		  System.out.println(username);
		 ps.setString(1,user.getFirstname());
		 ps.setString(2,user.getLastname());
		 ps.setString(3,user.getEmail());
		 ps.setString(4,user.getMobile());
		 ps.setString(5,user.getAddress1());
		 ps.setString(6,user.getAddress2());
		 ps.setString(7,user.getCountry());
		 ps.setString(8,user.getState());
		 ps.setInt(9,user.getPincode());
		 ps.setString(10, username);
		 ps.executeUpdate();
		 ps.close();
		connect.close();
	 }
}

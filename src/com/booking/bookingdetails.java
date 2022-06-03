package com.booking;

import com.carRentalAdminResources.jdbc_connection;
import java.sql.*;
import java.util.ArrayList;

public class bookingdetails {
    private String username,carname,pickdate,dropdate,location,type;
    private int id; 
    public static int maximumbooks=0;
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	Long totaldays,totalcost;

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getPickdate() {
		return pickdate;
	}

	public void setPickdate(String pickdate) {
		this.pickdate = pickdate;
	}

	public String getDropdate() {
		return dropdate;
	}

	public void setDropdate(String dropdate) {
		this.dropdate = dropdate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getTotaldays() {
		return totaldays;
	}

	public void setTotaldays(Long totaldays) {
		this.totaldays = totaldays;
	}

	public Long getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(Long totalcost) {
		this.totalcost=totalcost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public static ArrayList<bookingdetails> bookinghistory(String name) throws ClassNotFoundException, SQLException
	{
	    ArrayList<bookingdetails> list=new ArrayList<>();
	    Connection connect=jdbc_connection.getconnect();
	    PreparedStatement ps=connect.prepareStatement("select carname,type,dropdate,totalcost,id from bookingdetails where username=?");
	    ps.setString(1, name);
	    ResultSet rs=ps.executeQuery();
	    while(rs.next())
	    {
	        bookingdetails book=new bookingdetails();
	        book.setCarname(rs.getString(1));
	        book.setType(rs.getString(2));
	        book.setDropdate(rs.getString(3));
	        book.setTotalcost(rs.getLong(4));
	        book.setId(rs.getInt(5));
	        list.add(book);  
	     
	    }
		return list;
	}

	 
}
class BookingDb extends bookingdetails{
	
	public static void book(bookingdetails book) throws ClassNotFoundException, SQLException
	{
		 
		 Connection connect=jdbc_connection.getconnect();
		 PreparedStatement ps=connect.prepareStatement("INSERT INTO public.bookingdetails"
		 		+ " (username,carname,totalcost,totaldays,pickdate,dropdate,location,type) VALUES (?,?, ?, ?, ?, ?, ?,?);");
		 ps.setString(1,book.getUsername());
		 ps.setString(2,book.getCarname());
		 ps.setLong(3,book.getTotalcost());
		 ps.setLong(4,book.getTotaldays());
		 ps.setString(5,book.getPickdate());
		 ps.setString(6,book.getDropdate());
		 ps.setString(7,book.getLocation());
		 ps.setString(8,book.getType());
		 ps.executeUpdate();
		 ps.close();
		 connect.close();
		
	}
	public static String cancelbooking(Integer id) throws SQLException, ClassNotFoundException
	{
		Connection connect=jdbc_connection.getconnect();
		String carname = null;
		PreparedStatement ps1=connect.prepareStatement("select carname from bookingdetails where id=?");
		ps1.setInt(1,id);
		ResultSet rs=ps1.executeQuery();
       while( rs.next())
       {
    	   
            carname=rs.getString(1);
       }
		PreparedStatement ps=connect.prepareStatement("delete from bookingdetails where id=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		
		 
	 return carname;

	}
	
}

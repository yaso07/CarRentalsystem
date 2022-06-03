package com.carRentalAdminResources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

import com.booking.CheckingAvailability;
 


public class ViewCarDb {
	 
	
	 static ArrayList<Addcar> filter=new ArrayList<>();
	public static  void Searchview(LinkedHashSet<String> set) throws ClassNotFoundException, SQLException
	{
		 
		filter.clear();
		
		Connection connect=jdbc_connection.getconnect();
		 if(connect==null)
		 {
			 connect=jdbc_connection.getconnect();
		 }
		 Iterator<String> itr=set.iterator();  
		while(itr.hasNext())
		 {
			PreparedStatement ps = connect.prepareStatement( "select * from addcar");
			ResultSet result=ps.executeQuery();
		    String vehicle= itr.next();
			 
			while(result.next())
			{
				
			  if(vehicle.contains(result.getString(1)))
			  {
				  Addcar cars_filt=new Addcar();
				  cars_filt.setVehicleBrands(result.getString(1));
				  cars_filt.setPrice(result.getLong(2));
				  cars_filt.setType(result.getString(3));
				  filter.add(cars_filt);
			  }
			}
	 
		 }
	     
	}
	public static ArrayList<Addcar> getfilter() throws ClassNotFoundException, SQLException
	{
	 
	 ArrayList<Addcar> list=CheckingAvailability.viewcar();
	 ArrayList<Addcar> list2=new ArrayList<>();
	 list2.clear();
	 for(int i=0;i<filter.size();i++)
	 {
		 
		 for(int j=0;j<list.size();j++)
		 {
			 
			 if(filter.get(i).getVehicleBrand().equals(list.get(j).getVehicleBrand()))
			 {
				 list2.add(filter.get(i));
			 
			 }
		 }
		 
	 }
	
	 return list2;
		
	}
	public static Addcar getcardetails(String vehicle) throws ClassNotFoundException, SQLException
	{
		Connection connect=jdbc_connection.getconnect();
		if(connect==null)
		{
			connect=jdbc_connection.getconnect();
		}
		PreparedStatement ps=connect.prepareStatement("select * from addcar where vehicle=?");
		ps.setString(1, vehicle);
		Addcar car=new Addcar();
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			car.setVehicleBrands(rs.getString(1));
			car.setPrice(rs.getLong(2));
			car.setType(rs.getString(3));
		}
		ps.close();
		rs.close();
		connect.close();
		return car;
		
	}
	public static ArrayList<Addcar> getAdminView() throws ClassNotFoundException, SQLException
	{
		ArrayList<Addcar> list=new ArrayList<>();
		Connection connect=jdbc_connection.getconnect();
		 
		PreparedStatement ps = connect.prepareStatement( "select * from addcar");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Addcar car=new Addcar();
			car.setVehicleBrands(rs.getString(1));
			car.setPrice(rs.getLong(2));
			car.setType(rs.getString(3));
			car.setNoOfCars(rs.getInt(4));
			
			list.add(car);
		}
		return list;
	}
 
 
}

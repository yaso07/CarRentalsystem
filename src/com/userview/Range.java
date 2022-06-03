package com.userview;

import java.sql.*;
import java.util.*;

import com.carRentalAdminResources.jdbc_connection;

public class Range {

	public static ResultSet query() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connect=jdbc_connection.getconnect();
		if(connect==null)
		{
			connect=jdbc_connection.getconnect();
		}
		PreparedStatement ps=connect.prepareStatement("select vehicle from addcar order by prize desc");
		ResultSet rs=ps.executeQuery();
		 
		return rs;
	}
	public static LinkedHashSet<String> setRange(ResultSet rs) throws SQLException
	{
		LinkedHashSet<String> set=new LinkedHashSet<>();
		while(rs.next())
		{
			 
			set.add(rs.getString(1));
		}
		 
		return set;
	}
	public static LinkedHashSet<String> setRangeWDOption(String value,String car_option) throws SQLException, ClassNotFoundException
	{
		LinkedHashSet<String> set=new LinkedHashSet<>();
		Connection connect=jdbc_connection.getconnect();
		if(connect==null)
		{
			connect=jdbc_connection.getconnect();
		}
		//String[] split=car_option.split(" ");
		PreparedStatement ps=connect.prepareStatement("select vehicle from addcar where vehicle like ?  order by vehicle asc");
		ps.setString(1, car_option + "%");
		 
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			 
			set.add(rs.getString(1));
		}
		 
		return set;
	}
	 
	
	

}
class lowRange extends Range
{
	public static ResultSet query() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connect=jdbc_connection.getconnect();
		if(connect==null)
		{
			connect=jdbc_connection.getconnect();
		}
		PreparedStatement ps=connect.prepareStatement("select vehicle from addcar order by prize asc");
		ResultSet rs=ps.executeQuery();
		 
		return rs;
	}
	
	
}
class midRange extends lowRange
{
	public static ResultSet query() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connect=jdbc_connection.getconnect();
		if(connect==null)
		{
		   connect=jdbc_connection.getconnect();
		}
		PreparedStatement ps=connect.prepareStatement("select vehicle from addcar where prize>1500 and prize<5000");
		ResultSet rs=ps.executeQuery();
	 
		return rs;
	}
}

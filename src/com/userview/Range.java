package com.userview;

import java.sql.*;
import java.util.*;

import com.carRentalAdminResources.jdbc_connection;

public class Range {

	public static ResultSet query() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connect=jdbc_connection.getconnect();
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
	public static LinkedHashSet<String> setRangeWDOption(ResultSet rs,String car_option) throws SQLException
	{
		LinkedHashSet<String> set=new LinkedHashSet<>();
		while(rs.next())
		{
			if(rs.getString(1).contains(car_option))
			{
		  	  set.add(rs.getString(1));
			}
		}
		 
		return set;
	}
	
	

}
class lowRange extends Range
{
	public static ResultSet query() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connect=jdbc_connection.getconnect();
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
		PreparedStatement ps=connect.prepareStatement("select vehicle from addcar where prize>1500 and prize<5000");
		ResultSet rs=ps.executeQuery();
	 
		return rs;
	}
}

package com.userview;

import java.sql.*;
import java.util.*;

import com.carRentalAdminResources.ViewCarDb;

public class CarDatalist { 
	static LinkedHashSet<String> set=new LinkedHashSet<>();
	static ResultSet rs;
	public static void search(String range) throws ClassNotFoundException, SQLException
	
	{ 
		switch(range)
		{
		case "high":
		
		   rs=Range.query();
		   set=Range.setRange(rs);
		   
			break;
		case "low":
			
		    rs=lowRange.query();
		   set=Range.setRange(rs);
		   break;
		case "mid":
			
			rs=midRange.query();
			set=Range.setRange(rs);
	     }
	 
		 
		ViewCarDb.Searchview(set);
	}
	public static void search(String range,String car_option) throws ClassNotFoundException, SQLException
	
	{ 
		switch(range)
		{
		case "high":
		
		   rs=Range.query();
		   set=Range.setRangeWDOption(rs,car_option);
		   
			break;
		case "low":
			
		    rs=lowRange.query();
		    set=Range.setRangeWDOption(rs,car_option);
		   break;
		case "mid":
			
			rs=midRange.query();
			  set=Range.setRangeWDOption(rs,car_option);
	     }
		
	 
		ViewCarDb.Searchview(set);
	}
	

}

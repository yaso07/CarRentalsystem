package com.carRentalAdminResources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditDeleteView {

	public static void edit(Addcar editcar,String vehicle) throws ClassNotFoundException, SQLException
	{
	 
		Connection connect=jdbc_connection.getconnect();
	 
	       
		PreparedStatement ps=connect.prepareStatement("update public.addcar	SET vehicle=?, prize=?, type=?,no_of_cars=?	WHERE vehicle=? ");
	    ps.setString(1,editcar.getVehicleBrand());
		ps.setLong(2,editcar.getPrice());
		ps.setString(3,editcar.getType());
		ps.setInt(4,editcar.getNoOfCars());
		ps.setString(5, vehicle);
		 
		ps.executeUpdate();
	    ps.close();
		connect.close(); 
	
		
	}
    public static Addcar toview(String vehicle) throws ClassNotFoundException, SQLException
    {
    	Addcar temp=new Addcar();
    	
	    Connection connect=jdbc_connection.getconnect();
	 
	   PreparedStatement ps=connect.prepareStatement("select * from public.addcar where vehicle=? order by vehicle asc ");
	   ps.setString(1, vehicle);
	  ResultSet result=ps.executeQuery();
	  while(result.next())
	  {
	  temp.setVehicleBrands(result.getString(1));
      temp.setPrice(result.getLong(2));
      temp.setType(result.getString(3));
      temp.setNoOfCars(result.getInt(4));
	  }
	  
	  result.close();
	  ps.close();
	  connect.close();
      return temp;
    	
    }
    public static void delete(String vehicle) throws ClassNotFoundException, SQLException
    {
        Connection connect=jdbc_connection.getconnect();
		 
		 PreparedStatement res= connect.prepareStatement("DELETE FROM public.addcar WHERE vehicle=?;");
		 res.setString(1,vehicle);
         res.executeUpdate();
         res.close();
         connect.close();
         
    }
   
}

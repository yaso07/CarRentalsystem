package com.carRentalAdminResources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCarDb {

      

	public static void addCarDb(Addcar car) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connect=jdbc_connection.getconnect();
	    PreparedStatement res= connect.prepareStatement("INSERT INTO addcar(vehicle, prize,type)VALUES (?, ?, ?);");
        res.setString(1,car.getVehicleBrand());
        res.setLong(2,car.getPrice());
        res.setString(3,car.getType());
        res.executeUpdate();
        res.close();
     
        
        
	}

	 }
	
	
	

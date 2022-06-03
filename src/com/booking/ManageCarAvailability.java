package com.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.carRentalAdminResources.jdbc_connection;

public class ManageCarAvailability {

	public static int getNoOfCars(String carname) throws ClassNotFoundException, SQLException {
		Connection connect = jdbc_connection.getconnect();

		PreparedStatement ps = connect.prepareStatement("Select no_of_cars from addcar where vehicle=?");
		ps.setString(1, carname);
		ResultSet rs = ps.executeQuery();

		rs.next();
		int bookings = rs.getInt(1);
		ps.close();
		rs.close();

		return bookings;
	}

	public static void updateCarAvailability(String carname) throws ClassNotFoundException, SQLException {
		Connection connect = jdbc_connection.getconnect();

		PreparedStatement ps1 = connect.prepareStatement("select totalbookings from addcar where vehicle=?");
		ps1.setString(1, carname);
		ResultSet res = ps1.executeQuery();
		res.next();
		PreparedStatement ps = connect.prepareStatement("update addcar set totalbookings=? where vehicle=?");
		int value = res.getInt(1);

		ps.setInt(1, ++value);
		ps.setString(2, carname);

		ps.executeUpdate();

		ps.close();
		res.close();

	}

	public static int getAvailable(String carname) throws ClassNotFoundException, SQLException {
		Connection connect = jdbc_connection.getconnect();

		PreparedStatement ps = connect.prepareStatement("select totalbookings from addcar where vehicle=?");
		ps.setString(1, carname);
		ResultSet rs = ps.executeQuery();
		rs.next();

		return rs.getInt(1);

	}

	public static void updateCarAvailability(String carname, String string)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connect = jdbc_connection.getconnect();

		PreparedStatement ps1 = connect.prepareStatement("select totalbookings from addcar where vehicle=?");
		ps1.setString(1, carname);
		ResultSet res = ps1.executeQuery();
		res.next();
		PreparedStatement ps = connect.prepareStatement("update addcar set totalbookings=? where vehicle=?");
		int value = res.getInt(1);

		ps.setInt(1, --value);
		ps.setString(2, carname);

		ps.executeUpdate();
		res.close();
		ps.close();

	}

}

package com.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.carRentalAdminResources.Addcar;
import com.carRentalAdminResources.jdbc_connection;
import java.sql.*;

public class CheckingAvailability {

	static String pick;
	static String drop;

	public static void getdata(String pickdate, String dropdate)
			throws ParseException, SQLException, ClassNotFoundException {
		pick = pickdate;
		drop = dropdate;

		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat monthformatter = new SimpleDateFormat("MMMM");

		Date date1 = formatter1.parse((String) pick);
		Date date2 = formatter1.parse((String) drop);
		formatter1 = new SimpleDateFormat("dd MMMM yyyy");

		String pick_month = monthformatter.format(date1);
		String drop_month = monthformatter.format(date2);
		pick = formatter1.format(date1);
		drop = formatter1.format(date2);

		CheckingAvailability.checkdb(pick_month, drop_month);

	}

	static HashMap<String, Integer> map;

	public static void checkdb(String month, String month2) throws ClassNotFoundException, SQLException {
		ArrayList<String> pickdate = new ArrayList<>();
		ArrayList<String> dropdate = new ArrayList<>();
		ArrayList<String> carlist = getcar();
		map = new HashMap<>();
		Connection connect = jdbc_connection.getconnect();

		for (int k = 0; k < carlist.size(); k++) {
			if (ManageCarAvailability.getAvailable(carlist.get(k)) < ManageCarAvailability
					.getNoOfCars(carlist.get(k))) {
				continue;
			}

			PreparedStatement ps = connect.prepareStatement("select pickdate,dropdate from bookingdetails b inner join "
					+ "addcar a on b.carname=a.vehicle where pickdate like ? and carname=?  order by id asc");
			ps.setString(1, "___" + month + "%");
			ps.setString(2, carlist.get(k));

			ResultSet rs = ps.executeQuery();
			pickdate.clear();
			dropdate.clear();
			while (rs.next()) {
				pickdate.add(rs.getString(1));
				dropdate.add(rs.getString(2));
			}

			int available = 0;

			for (int i = 0; i < pickdate.size(); i++) {
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMMM yyyy");

				LocalDate Pick = LocalDate.parse(pickdate.get(i), df);
				LocalDate Drop = LocalDate.parse(dropdate.get(i), df);
				LocalDate pick1 = LocalDate.parse(pick, df);
				LocalDate drop1 = LocalDate.parse(drop, df);
				long a1 = ChronoUnit.DAYS.between(Pick, pick1);
				long a2 = ChronoUnit.DAYS.between(Pick, drop1);
				long b1 = ChronoUnit.DAYS.between(Drop, pick1);
				long b2 = ChronoUnit.DAYS.between(Drop, drop1);
				if (a1 < 0 && a2 <= 0 || b1 > 0 && b2 > 0) {
					available++;
				} else {
					if (available > 0) {
						available--;
					}
				}
			}
			if (pickdate.size() == 0) {
				continue;
			}

			map.put(carlist.get(k), available);

		}
		connect.close();

	}

	public static ArrayList<String> getcar() throws ClassNotFoundException, SQLException {
		ArrayList<String> carlist = new ArrayList<>();
		Connection c = jdbc_connection.getconnect();

		PreparedStatement ps = c.prepareStatement("select vehicle from addcar");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			carlist.add(rs.getString(1));
		}
		rs.close();
		ps.close();
		c.close();

		return carlist;

	}

	public static ArrayList<Addcar> viewcar() throws ClassNotFoundException, SQLException {
		ArrayList<Addcar> list = new ArrayList<>();

		list.clear();
		Connection connect = jdbc_connection.getconnect();

		PreparedStatement ps = connect.prepareStatement("select * from addcar");
		ResultSet result = ps.executeQuery();
		boolean valid = false;
		while (result.next()) {
			valid = false;
			if (map == null) {
				break;
			}

			for (Map.Entry m : map.entrySet()) {

				if (m.getKey().equals(result.getString(1)) && m.getValue().equals(0)) {
					valid = true;
				}
			}

			if (valid != true) {

				Addcar car = new Addcar();
				car.setVehicleBrands(result.getString(1));
				car.setPrice(result.getLong(2));
				car.setType(result.getString(3));

				list.add(car);
			}
		}

		return list;

	}

}

package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FlightsDB {
	public static List<Flights> getFlightsList() throws ClassNotFoundException, SQLException{
		String url="jdbc:mysql://localhost:3306/flyaway";
		String userName="root";
		String password="root";
		ArrayList<Flights> flights=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,userName,password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from flights");
		while(rs.next()) {
			int flightnumber=rs.getInt(1);
			String source=rs.getString(2);
			String destination=rs.getString(3);
			String time=rs.getString(4);
			int duration=rs.getInt(5);
			int price=rs.getInt(6);
			Flights f=new Flights(flightnumber,source,destination,time,duration,price);
			flights.add(f);
		}
		return flights;
	}
}

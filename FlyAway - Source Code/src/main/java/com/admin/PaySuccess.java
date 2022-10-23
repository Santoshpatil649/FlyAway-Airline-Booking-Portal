package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaySuccess
 */
@WebServlet("/PaySuccess")
public class PaySuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaySuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Flights f;
		PrintWriter pw=response.getWriter();
		HttpSession session =request.getSession(false);
		Customer u=(Customer) session.getAttribute("customer");
		Customer u2=(Customer) request.getAttribute("customer");
		u.setCardname(u2.getCardname());
		u.setCardno(u2.getCardno());
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/flyaway";
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement("select * from flights where flightnumber=?");
			ps.setInt(1, u.getFlightno());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				f=new Flights(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
				pw.print("<button><a href='index.html'>Home</a></button>");
				pw.print("<h1 align='center'>Congratualtions you have Successfully booked your Ticket</h1><br>");
				pw.print("<h2 align='center'>Details are as below</h2><br>");
				pw.print("<center> Name:"+u.getName()+"</center>");
				pw.print("<center> Flight Number:"+u.getFlightno()+"</center>");
				pw.print("<center> Source:"+f.getSource()+"</center>");
				pw.print("<center> Destination:"+f.getDestination()+"</center>");
				pw.print("<center> Time:"+f.getTime()+"</center>");
				pw.print("<center>Payment Details are as Follows:</center>");
				pw.print("<center> Price:"+f.getPrice()+"</center>");
				pw.print("<center> CardNumber:"+u.getCardno()+"</center>");
				pw.print("<center> Name of CardHolder:"+u.getCardname()+"</center><br>");
				pw.print("<center>Payment Status:<span style='color:green'>Successful</span></center>");
			}
			
		}
			catch (Exception e) {
				
				pw.print(e);
			}
		
	}}

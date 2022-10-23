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

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String user="root";
		String password="root";
		String url="jdbc:mysql://localhost:3306/flyaway";
		Connection con=DriverManager.getConnection(url,user,password);
		if(!request.getParameter("source").equals(request.getParameter("destination"))) {
		PreparedStatement ps=con.prepareStatement("insert into flights(source,destination,time,duration,price) values(?,?,?,?,?)");
		ps.setString(1, request.getParameter("source"));
		ps.setString(2, request.getParameter("destination"));
		ps.setString(3, request.getParameter("time"));
		ps.setInt(4, Integer.parseInt(request.getParameter("duration")));
		ps.setInt(5, Integer.parseInt(request.getParameter("price")));
		ps.executeUpdate();
		ps.close();
		request.getRequestDispatcher("add.html").include(request, response);
		pw.println("<center><SPAN style='color:green'>Flight Added Successfully</SPAN></center>");
		}
		else {
			request.getRequestDispatcher("add.html").include(request, response);
			pw.println("<center><SPAN style='color:red'>Source And Destination cannot be same</SPAN></center>");
		}
		}
		catch (Exception e) {
			
			pw.print(e);
		}
	}

}

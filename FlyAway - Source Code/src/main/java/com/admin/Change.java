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
 * Servlet implementation class Change
 */
@WebServlet("/Change")
public class Change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Change() {
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
		PreparedStatement ps=con.prepareStatement("select * from admin");
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			if(request.getParameter("newpassword").equals(request.getParameter("conpassword"))&&request.getParameter("oldpassword").equals(rs.getString(2))&&!request.getParameter("newpassword").equals(rs.getString(2))) {
				PreparedStatement ps1=con.prepareStatement("update admin set Password=? where Username=?");
				ps1.setString(1, request.getParameter("newpassword"));
				ps1.setString(2, "santosh");
				ps1.executeUpdate();
				ps1.close();
				request.getRequestDispatcher("cp.html").include(request, response);
				pw.println("<center><SPAN style='color:green'>Password Changed Successfully</SPAN></center>");
			}
			else {
				request.getRequestDispatcher("cp.html").include(request, response);
				pw.println("<center><SPAN style='color:red'>Invalid Credentials</SPAN></center>");
			}
		}
		
	}
		catch (Exception e) {
			
			pw.print(e);
		}
	
	}

} 

package Servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MySqlConnection
 */
@WebServlet("/MySqlConnection")
public class MySqlConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySqlConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				String username="root";
				String password="root";
				String url="jdbc:mysql://localhost:3306/first_project";
				Connection con=DriverManager.getConnection(url, username, password);
				//out.print(con);
				Statement statement=con.createStatement();
			    ResultSet rs= statement.executeQuery("select * from sports");
			    while(rs.next())
			    {
			    	out.print(rs.getInt(1) +"/t" +rs.getString(2) +"/t" +rs.getString(3) +"/t" +rs.getInt(4) +"/t" +rs.getInt(5));
			    }
				
			} 
			catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

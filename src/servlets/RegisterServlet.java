package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	@Resource(lookup = "java:jboss/datasources/contactsconn")
	private DataSource datasrc;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (
				Connection connect = datasrc.getConnection();
		) {
			String query = "insert into users(username,password) values (?,?);";
			PreparedStatement prepstmt = connect.prepareStatement(query);
			
			prepstmt.setString(1, request.getParameter("username"));
			prepstmt.setString(2, request.getParameter("password"));
			
			int result = prepstmt.executeUpdate();
			request.setAttribute("register", result);
			
			RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
            rs.forward(request, response);
			
		} catch (Exception e) {
			String message = "Username already exist.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("links").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

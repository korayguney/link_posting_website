package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/usernamecontrol")
public class UsernameControlServlet extends HttpServlet {
	
	@Resource(lookup = "java:jboss/datasources/contactsconn")
	private DataSource ds;
	
	int st = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection conn = ds.getConnection();) {

			String query = "select * from users where username=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			
			psmt.setString(1, request.getParameter("username"));
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				st++;	
			}
			
			if(st > 0)
	        {
				String message = "Username exist!";  		 	
				request.setAttribute("usernameexist", message);
	            request.getRequestDispatcher("register.jsp").forward(request, response);
	        }
	        else
	        { 
	        	request.getRequestDispatcher("register").forward(request, response);
	        }
			
			// request.setAttribute("loginStatus", st);
			// getServletContext().getRequestDispatcher("/login").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

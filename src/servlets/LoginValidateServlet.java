package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/validate")
public class LoginValidateServlet extends HttpServlet {
	
	@Resource(lookup = "java:jboss/datasources/contactsconn")
	private DataSource ds;
	
	int st = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection conn = ds.getConnection();) {

			String query = "select * from users where username=? and password=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			
			psmt.setString(1, request.getParameter("username"));
			psmt.setString(2, request.getParameter("password"));
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				st++;	
			}
			
			if(st > 0)
	        {
				String username = request.getParameter("username");  
		        HttpSession session=request.getSession();  
		        session.setAttribute("username", username);  			
	            request.getRequestDispatcher("links").forward(request, response);
	        }
	        else
	        {
	        	request.setAttribute("err", 1); 
	        	request.getRequestDispatcher("home.jsp").forward(request, response);
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

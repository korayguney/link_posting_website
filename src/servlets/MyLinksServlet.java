package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import models.UserLink;

@WebServlet("/mylinks")
public class MyLinksServlet extends HttpServlet {
	
	@Resource(lookup = "java:jboss/datasources/contactsconn")
	private DataSource datasrc;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<UserLink> mylinks = new ArrayList<>();
	
			try (
					Connection connect = datasrc.getConnection();
			) {
				String query = "select * from user_links where username=? order by viewcount DESC;";
				PreparedStatement prepstmt = connect.prepareStatement(query);
				
				HttpSession session = request.getSession(true);
				prepstmt.setString(1, (String)session.getAttribute("username"));
				
				ResultSet rs = prepstmt.executeQuery();

				while (rs.next()) {
					mylinks.add(new UserLink(rs.getString("username"), rs.getString("postedlink"), rs.getString("title"),
							rs.getDate("postdate"), rs.getInt("viewcount")));
				}

				request.setAttribute("mylinks", mylinks);
				request.getRequestDispatcher("mylinks.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import javax.sql.DataSource;

import models.UserLink;

@WebServlet("/links")
public class LinkDisplayServlet extends HttpServlet {
	
	@Resource(lookup = "java:jboss/datasources/contactsconn")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<UserLink> links = new ArrayList<>();
		
		try (Connection conn = ds.getConnection();) {

			String query = "select * from user_links order by viewcount DESC";

			PreparedStatement psmt = conn.prepareStatement(query);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				links.add(new UserLink(rs.getString("username"), rs.getString("postedlink"), rs.getString("title"),
						rs.getDate("postdate"), rs.getInt("viewcount")));
			}

			request.setAttribute("links", links);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

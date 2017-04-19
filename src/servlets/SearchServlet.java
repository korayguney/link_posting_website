package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	@Resource(lookup = "java:jboss/datasources/contactsconn")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchword = request.getParameter("search");
		
		List<UserLink> searchlinks = new ArrayList<>();
		
		String query = "select * from user_links where title like ? order by viewcount DESC";

		try (Connection conn = ds.getConnection();) {
			
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, "%"+ searchword +"%");
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()){
				searchlinks.add(new UserLink(rs.getString("username"),
						rs.getString("postedlink"),
						rs.getString("title"), 
						rs.getDate("postdate"),
						rs.getInt("viewcount")));
				System.out.println("hello");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello");
		request.setAttribute("links", searchlinks);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

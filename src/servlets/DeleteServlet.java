package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	@Resource(lookup = "java:jboss/datasources/contactsconn")
	private DataSource datasrc;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (
				Connection connect = datasrc.getConnection();
		) {
			String query = "delete from user_links where username=? and postedlink=?;";
			PreparedStatement prepstmt = connect.prepareStatement(query);
			
			HttpSession session = request.getSession(true);
			prepstmt.setString(1, (String)session.getAttribute("username"));
			prepstmt.setString(2, request.getParameter("postedlink"));
			
			int result = prepstmt.executeUpdate();
			//request.setAttribute("register", result);
			
			response.sendRedirect("mylinks");
			
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

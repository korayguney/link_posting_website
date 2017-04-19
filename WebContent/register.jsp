<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>

		<%
			if(request.getAttribute("register") == null){
		%>
	<div id="content" style="width: 95%; border: 1px solid; padding: 5px; min-height: 80px; margin-bottom: 5px;">
		<form method="post" action="register">
  		<table>
  			<tr><td>Username</td><td><input type="text" name="username"/></td></tr>
  			<tr><td>Password</td><td><input type="password" name="password"/></td></tr>
  			<tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
  			<tr><td colspan="2">
  				
  			</td></tr>
	  			<c:if test="${not empty message}">
	  				<p>${message} </p>
	  			</c:if>
  		</table>
  		</form>
	</div>
	<% } else { %>
		<div id="content" style="width: 95%; border: 1px solid; padding: 5px; min-height: 80px; margin-bottom: 5px;">
    		<p>You registered successfully, please login.</p>
   		</div>
	<% } %>
<jsp:include page="footer.jsp"/>
	
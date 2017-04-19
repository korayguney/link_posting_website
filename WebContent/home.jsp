<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
		if(request.getAttribute("err") != null){
	%>
<jsp:include page="headerErr.jsp"/>
	<% } else { %>
<jsp:include page="header.jsp"/>
	<% } %>


	<div id="content" style="width: 95%; border: 1px solid; padding: 5px; min-height: 80px; margin-bottom: 5px;">

		<h4>All Links Posted</h4>
		<div>
			<form method="get" action="search">
				<input type="text" name="search" placeholder="Enter your keywords" />
				<input type="submit" value="Search" /> <a href="links">Reset</a>
			</form>
		</div>
	
	<div>
		<table style="width: 90%; padding: 5px;">
			<tr style="text-decoration: bold; font-weight: bold;">
				<td>Title</td>
				<td>Link</td>
				<td>Date</td>
				<td>Views</td>
				<td>Posted By</td>
			</tr>
		<c:forEach items="${links}" var="link">
			<tr>
				<td>${link.title}</td>
				<td><a href ="${link.postedlink}" />${link.postedlink}</td>
				<td>${link.postdate}</td>
				<td>${link.viewcount}</td>
				<td><a href="usrlink?user=${link.username}">${link.username}</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>
	</div>
	
<jsp:include page="footer.jsp"/>
	
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<jsp:include page="header.jsp"/>

	<div id="content" style="width: 95%; border: 1px solid; padding: 5px; min-height: 80px; margin-bottom: 5px;">
	<%
	String user1 = request.getParameter("user");
	%><h3><%
	out.write(user1 +" Links");
	%></h3>
	
		
	<div>
		<table style="width: 90%; padding: 5px;">
			<tr style="text-decoration: bold; font-weight: bold;">
				<td>Title</td>
				<td>Link</td>
				<td>Date</td>
				<td>Views</td>
				<td>Posted By</td>
			</tr>
		<c:forEach items="${userlinks}" var="usrlink">
			<tr>
				<td>${usrlink.title}</td>
				<td><a href ="${usrlink.postedlink}" />${usrlink.postedlink}</td>
				<td>${usrlink.postdate}</td>
				<td>${usrlink.viewcount}</td>
				<td>${usrlink.username}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	</div>
	
<jsp:include page="footer.jsp"/>
	
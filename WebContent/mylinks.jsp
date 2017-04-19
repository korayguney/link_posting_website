<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<jsp:include page="header.jsp"/>

	<div id="content" style="width: 95%; border: 1px solid; padding: 5px; min-height: 80px; margin-bottom: 5px;">

		<h4>Your Links</h4>
	
	<div>
		<table style="width: 90%; padding: 5px;">
			<tr style="text-decoration: bold; font-weight: bold;">
				<td>Title</td>
				<td>Link</td>
				<td>Date</td>
				<td>Views</td>
				<td>Posted By</td>
			</tr>
		<c:forEach items="${mylinks}" var="mylink">
			<tr>
				<td>${mylink.title}</td>
				<td><a href ="${mylink.postedlink}" />${mylink.postedlink}</td>
				<td>${mylink.postdate}</td>
				<td>${mylink.viewcount}</td>
				<td>${mylink.username}</td>
				<td><a href="delete?postedlink=${mylink.postedlink}">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>
	</div>
	
<jsp:include page="footer.jsp"/>
	
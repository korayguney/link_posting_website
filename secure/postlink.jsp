<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../WebContent/header.jsp"/>

	<div id="content" style="width: 95%; border: 1px solid; padding: 5px; min-height: 80px; margin-bottom: 5px;">
		<form method="post" action="postlink">
  		<table>
  			<tr><td>Title</td><td><input type="text" name="title"/></td></tr>
  			<tr><td>Link</td><td><input type="text" name="link"/></td></tr>
  			<tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
  			<tr><td colspan="2">
  				
  			</td></tr>
  		</table>
  		</form>
	</div>
	
<jsp:include page="../WebContent/footer.jsp"/>
	
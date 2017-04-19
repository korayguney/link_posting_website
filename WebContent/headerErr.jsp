<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Koray Guney Link Assignment</title>
<div style="width: 95%; border: 1px solid; padding: 5px; min-height: 80px; margin-bottom: 5px;">
		<h3>My Links</h3>

		<form method="post" action="validate">
			Username: <input type="text" name="username" /> 
			Password: <input type="password" name="password" /> 
			<input type="submit" value="Login" />
		</form>
		<br/>
		Username or password is wrong <br/>	
			<a href="home.jsp">Home</a>&nbsp;&nbsp; <a href="register.jsp">Register</a>&nbsp;&nbsp;	
	</div>

</head>

	
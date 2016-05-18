<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
a:link {
	color: green;
	background-color: transparent;
	text-decoration: none;
}

a:visited {
	color: pink;
	background-color: transparent;
	text-decoration: none;
}

a:hover {
	color: red;
	background-color: transparent;
	text-decoration: underline;
}

a:active {
	color: yellow;
	background-color: transparent;
	text-decoration: underline;
}
</style>
</head>
<body>


	<p>Click the link get info</p>
	<a href="/Geon/UserController?action=complaintlist">ComplaintRegistration</a>

	<a href="html_images.asp" target="_blank">Support Resolution</a>
	
	<a href="/Geon/UserController?action=resolved">Resolved</a>
	<br>
	<a href="/Geon/AdminController?action=userslist">Admin</a>
	
	




</body>
</html>
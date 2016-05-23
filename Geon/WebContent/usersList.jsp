<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Users</title>
</head>
<body>
	<h1>List of Users</h1>


	<c:if test="${!empty users}">
		<table align="left" border="1">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Phone Number</th>
				<th>Joining Date</th>
				<th>Experience</th>
				<th>Education</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.phoneNumber}" /></td>
					<td><c:out value="${user.joiningDate}" /></td>
					<td><c:out value="${user.experience}" /></td>
					<td><c:out value="${user.education}" /></td>
					<td align="center">
					
					<a href="/Geon/AdminController?action=edit&email=<c:out value="${user.email}"/>">Edit</a>
					<a href="/Geon/AdminController?action=delete&email=<c:out value="${user.email}"/>"><button onclick="myFunction()">Delete</button></a>	
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="/Geon/AdminController?action=">ADD</a>
	<script>
function myFunction() {
    var x;
    if (confirm("Are you sure want to delete!") == true) {
        x = "You pressed OK!";
    } else {
        x = "You pressed Cancel!";
    }
    alert(x);
}
</script>
	
</body>
</html>
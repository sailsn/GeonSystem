<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Get Record</title>
</head>
<body>
	<h1>Display record</h1>



		<table align="left" border="1">
			

				<tr>
					<td>CustomerName</td>
					<c:forEach items="${users}" var="user">
						<td><c:out value="${user.customerName}" /></td>
					</c:forEach>
				</tr>
				<tr>
					<td>CompanyName</td>
					<c:forEach items="${users}" var="user">
						<td><c:out value="${user.companyName}" /></td>
					</c:forEach>
				</tr>

				<tr>
					<td>Severity</td>
					<c:forEach items="${users}" var="user">
						<td><c:out value="${user.severity}" /></td>
					</c:forEach>
				</tr>

				<tr>
					<td>status</td>
					<c:forEach items="${users}" var="user">
						<td><c:out value="${user.status}" /></td>
					</c:forEach>
				</tr>


				<tr>
					<td>IssueDescription</td>
					<c:forEach items="${users}" var="user">
						<td><c:out value="${user.issueDescription}" /></td>
					</c:forEach>
				</tr>


				<tr>
					<td>TicketRefNumber</td>
					<c:forEach items="${users}" var="user">
						<td><c:out value="${user.ticketRefNumber}" /></td>
					</c:forEach>
				</tr>


				<tr>
					<td>Remarks</td>
					<c:forEach items="${users}" var="user">
						<td><c:out value="${user.remarks}" /></td>
					</c:forEach>
				</tr>



		
		</table>

	<br>

	<br>
</body>
</html>
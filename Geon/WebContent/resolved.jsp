<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Resolved Complaints</title>
</head>
<body>
	<h1>Resolved</h1>
	
	
	<c:if test="${!empty resolved}">
		<table align="left" border="1">
			<tr>
				<th>CustomerName</th>
				<th>Severity</th>
				<th>CompanyName</th>
				<th>Email</th>
				<th>Warrantystatus</th>
				<th>SupportCategory</th>
				<th>IssueDescription</th>
				<th>ForwardedEmail</th>
				<th>Remarks</th>
				<th>PhoneNumber</th>
				<th>TicketRefNumber</th>
				
			</tr>

			<c:forEach items="${resolved}" var="user">
				<tr>
					<td><c:out value="${user.customerName}" /></td>
					<td><c:out value="${user.severity}" /></td>
					<td><c:out value="${user.companyName}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.supportCategory}" /></td>
					<td><c:out value="${user.issueDescription}" /></td>
					<td><c:out value="${user.forwardedEmail}" /></td>
					<td><c:out value="${user.remarks}" /></td>
					<td><c:out value="${user.phoneNumber}" /></td>
					<td><c:out value="${user.ticketRefNumber}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</body>
</html>
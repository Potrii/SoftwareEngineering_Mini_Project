<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Manager Home Page</title>
</head>
<body>


	<div align="center">
		<h1>Contact Manager Application</h1>
		<h3>Contact List</h3>
		<h4> 
			<a href="new">New Contact</a>
		</h4>
		<table border="2" cellpadding="5px">
		
			<tr>
			 <th>TableNo</th>
			 <th>ID</th>
			 <th>Name</th>
			 <th>Email</th>
			 <th>Address</th>
			 <th>PhoneNumber</th>
			 <th>Action</th>
			</tr>
			
		
		<c:forEach items="${listOfContacts}" var="contact" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${contact.ID}</td>
				<td>${contact.name}</td>
				<td>${contact.email}</td>
				<td>${contact.address}</td>
				<td>${contact.phoneNumber}</td>
				<td>
					<a href="edit?id=${contact.ID}">Edit</a>
					&nbsp;&nbsp;
					<a href="delete?id=${contact.ID}">Delete</a>
				</td>
			</tr>
		</c:forEach>
		
		</table>			
	</div>
	
</body>
</html>
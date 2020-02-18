<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New / Edit  Contact</title>
</head>
<body>

	<div align="center">
		<h1>New/Edit Contact</h1>
		
		<form:form action="save" method="post" modelAtribute="contact">
		
			<div align="center">
				<table>
				
				<tr>
					<td>Name:</td>
					<td>
						<input type="text" name="name"/>
					</td>
				</tr>
				
				<tr>
					<td>Email:</td>
					<td>
						<input type="text" name="email"/>
					</td>
				</tr>
				
				<tr>
					<td>Address:</td>
					<td>
						<input type="text" name="address"/>
					</td>
				</tr>
				
				<tr>
					<td>PhoneNumber:</td>
					<td>
						<input type="text" name="phoneNumber"/>
					</td>
				</tr>
				
				<tr >
					<td align="center" colspan="3">  
						<input type="submit" value="Save"/>
					</td>
				</tr>
				</table>
			</div>
		
		</</form:form>
	</div>
</body>
</html>
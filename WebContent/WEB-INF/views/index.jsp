<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Manager Application</title>
</head>
<body>
	
	<div align="center">
		<h1>My Contacts</h1>
		<h3>Contact List</h3>
		<h3><a href="/ContactManager/new">New Contact</a></h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>S. No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${contactList}" var="contact" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.address}</td>
					<td>${contact.telephone}</td>
					<td>
                        <a href="/ContactManager/editContact?id=${contact.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/ContactManager/deleteContact?id=${contact.id}">Delete</a>
                    </td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>
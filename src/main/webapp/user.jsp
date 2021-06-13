<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User list</title>

<style type="text/css">    
           * { margin: 0; padding: 0; }
           p { padding: 10px; }
           height: 200px;
           #left { position: absolute; left: 0; top: 0; width: 50%; }
           #right { position: absolute; right: 0; top: 0; width: 50%; } 
        </style>
</head>
<body>
	<jsp:useBean id="userListDatabean"
		class="databean.UserListDatabean" />
		
	<header>
	<div id="left"><h1>
	User page 
	</h1></div>
	</header>		
	<form method="post" action="user">	
		<table style="width: 100%" border="1">
			<tr>
				<td>Id</td>
				<td>FirstName</td>
				<td>LastName</td>
				<td>Age</td>
				<td>Action</td>
			</tr>
			<c:forEach var="user" items="${userListDatabean.getUserList()}">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.age}" /></td>
					<td><c:url var="deleteUrl" value="/deleteuser.jsp">
							<c:param name="userid" value="${user.id}" />
							<c:param name="userfirstname" value="${user.firstName}" />
							<c:param name="userlastname" value="${user.lastName}" />
							<c:param name="userage" value="${user.age}" />
						</c:url> <c:url var="updateUrl" value="/updateuser.jsp">
							<c:param name="userid" value="${user.id}" />
							<c:param name="userfirstname" value="${user.firstName}" />
							<c:param name="userlastname" value="${user.lastName}" />
							<c:param name="userage" value="${user.age}" />
						</c:url>
						<p>
							<a href="${deleteUrl}">Delete user</a>
						</p>
						<p>
							<a href="${updateUrl}">Update user</a>
						</p></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td><input type="text" name="userfirstname" /></td>
				<td><input type="text" name="userlastname" /></td>
				<td><input type="text" name="userage" /></td>
				<td><input type="hidden" name="actiontype" value="adduser" />
					<input type="submit" name="adduser" value="Add user">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

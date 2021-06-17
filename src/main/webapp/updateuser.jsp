<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update waiter</title>
</head>
<body>
	<p>Please update user fields and press Update user button or
		press Cancel button.</p>
	<c:url var="userUrl" value="/user.jsp" />
	<form method="post" action="user">
		<input type="hidden" name="actiontype" value="updateuser" /> <input
			type="hidden" name="userid" value="${param.userid}" />
		<p>
			User id:
			<c:out value="${param.userid}" />
		</p>
		<p>
			User first name: <input type="text" name="userfirstname"
				value="${param.userfirstname}" />
		</p>
		<p>
			User last name: <input type="text" name="userlastname"
				value="${param.userlastname}" />
		</p>
		<p>
			User age: <input type="text" name="userage"
				value="${param.userage}" />
		</p>
		<p>
			User age: <input type="text" name="useremail"
				value="${param.useremail}" />
		</p>
		<input type="submit" name="deleteuser" value="Update user" /> <input
			type="button" onclick="window.location.href='${userUrl}'"
			value="Cancel">
	</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete user</title>
</head>
<body>
	<p>Below user will be deleted:</p>
	<p>User id ${param.userid}</p>
	<p>User first name ${param.userfirstname}</p>
	<p>User last name ${param.userlastname}</p>
	<p>User age ${param.userage}</p>
	<p>User email ${param.useremail}</p>
	<p>Could you please confirm?</p>
	<c:url var="userUrl" value="/user.jsp" />
	<form method="post" action="user">
		<input type="hidden" name="actiontype" value="deleteuser" /> <input
			type="hidden" name="userid" value="${param.userid}"> <input
			type="submit" name="deleteuser" value="Delete user"> <input
			type="button" onclick="window.location.href='${userUrl}'"
			value="Cancel">
	</form>
</body>
</html>

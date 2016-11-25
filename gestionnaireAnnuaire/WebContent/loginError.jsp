<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Error</title>
</head>
<body>
	<c:url var="url" value="/index.jsp" />
	<h2>Le login ou le mot de passre est invalid.</h2>

	<p>
		Please enter a user name or password that is authorized to access this
		application. For this application, this means a user that has been
		created in the
		<code>file</code>
		realm and has been assigned to the <em>group</em> of
		<code>TutorialUser</code>
		. Click here to <a href="${url}">Try Again</a>
	</p>
</body>
</html>
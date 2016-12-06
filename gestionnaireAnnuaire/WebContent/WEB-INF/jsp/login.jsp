<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello :: Spring Application</title>
</head>
<body>

	<form action="login" name="userLogin" method="post">
		<label><b>Login</b></label> <input type="text"
			placeholder="Entrez votre login" name="login"> <label><b>Password</b></label>
		<input type="password" placeholder="Entrez votre mot de passe" name="pwd">

		<button type="submit">Login</button>
	</form>

</body>
</html>
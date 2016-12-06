<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table style="border: solid 1px black">
		<tr>
			<td>${personData.id}</td>
			<td>${personData.firstName}</td>
			<td>${personData.lastName}</td>
			<td>${personData.mail}</td>
			<td>${personData.web}</td>
			<td>${personData.naissance}</td>
			<td>${personData.password}</td>
		</tr>
	</table>
	<a href='login'>Authentification</a>
</body>
</html> 
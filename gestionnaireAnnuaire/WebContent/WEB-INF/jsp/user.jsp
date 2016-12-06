<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form method="POST" commandName="connexion">
	<table style="border: solid 1px black">
		<tr>
			<td><input value=${personData.id} /></td>
			<td><input value=${personData.firstName} /></td>
			<td><input value=${personData.lastName} /></td>
			<td><input value=${personData.mail}></input></td>
			<td><input value=${personData.web} /></td>
			<td><input value=${personData.naissance} /></td>
			<td><input value=${personData.password} /></td>
		</tr>
		<tr><input type="submit" /></tr>
	</table>
	</form>
	<a href='login'>Authentification</a>
</body>
</html> 
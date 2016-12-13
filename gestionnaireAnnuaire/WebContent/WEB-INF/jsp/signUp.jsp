<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>

	<h1>Inscription</h1>

	<form:form method="POST" commandName="person">
		<table>
			<tr>
				<td>Numero :</td>
				<td><form:input path="idPers" value="${personSignUp.idPers}" /></td>

				<td><small class="errors help-block"><form:errors
							path="idPers" cssClass="error" /></small></td>
			</tr>
			<tr>
				<td>Groupe :</td>
				<td><form:input path="idGroup" value="${personSignUp.idGroup}" /></td>
				<td><small class="errors help-block"><form:errors
							path="idGroup" cssClass="error" /></small></td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td><form:input path="firstName"
						value="${personSignUp.firstName}" /></td>
				<td><small class="errors help-block"><form:errors
							path="firstName" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td>Nom :</td>
				<td><form:input path="lastName"
						value="${personSignUp.lastName}" /></td>
				<td><small class="errors help-block"><form:errors
							path="lastName" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td>Email :</td>
				<td><form:input path="mail" value="${personSignUp.mail}" /></td>
				<td><small class="errors help-block"><form:errors
							path="mail" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td>Site web :</td>
				<td><form:input path="web" value="${personSignUp.web}" /></td>
				<td><small class="errors help-block"><form:errors
							path="web" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td>Naissance :</td>
				<td><form:input path="naissance"
						value="${personSignUp.naissance}" /></td>
				<td><small class="errors help-block"><form:errors
							path="naissance" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><form:password path="password"
						value="${personSignUp.password}" /></td>
				<td><small class="errors help-block"><form:errors
							path="password" cssClass="error" /></small></td>
			</tr>
			

			<tr>
				<td colspan="3">
					<!-- 
					 <a href="login" >Confirmer</a>
					 -->
					 <input type="submit" value="Sign up"/>
				</td>
			</tr>

		</table>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp"%>

<c:url var="edit" value="/actions/connexion/edit" />

<html>
<head>
<title>Information</title>
</head>
<body>
    <h1>Votre profile</h1>
    <table border='1'>
    <c:forEach items="${person}" var="pers">
        <tr>
        <td><a href="${edit}?id=${pers.number}">
            <c:out value="${pers.firstName}" /></a>
        </td>
        <td><a href="${edit}?id=${pers.number}">
            <c:out value="${pers.lastName}" /></a>
        </td>
        </tr>
    </c:forEach>
    </table>
    <p><a href="${edit}">Create new product</a></p>
</body>
</html>
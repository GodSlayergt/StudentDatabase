<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<div>
<h1>Add Student</h1>
</div>
<div>
<form:form action="conformation" modelAttribute="student">
<table>
<tr style="visibility: hidden;">
<th><form:input path="id"/>
</th>
</tr>
<tr>
<th>Name: </th>
<td><form:input path="name"/></td>
<td><form:errors path="name"></form:errors></td>
</tr>
<tr>
<th>LastName: </th>
<td><form:input path="lastname"/></td>
<td><form:errors path="lastname"></form:errors></td>
</tr>
<tr>
<th>Email: </th>
<td><form:input path="email"/></td>
<td><form:errors path="email"></form:errors></td>
</tr>
</table>
<form:button type="submit"> Submit</form:button>
</form:form>
</div>
</div>

</body>
</html>
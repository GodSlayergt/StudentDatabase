<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>


<div>
<div> <h1> Student details</h1></div>
<div><a href="${pageContext.request.contextPath}/add"> Add Student</a></div>
<div>
<table>
<tr>
<th style="visibility: hidden;"></th>
<th>SerialNo</th>
<th>Name</th>
<th>LastName</th>
<th>Email</th>
</tr>
<c:set var="i" value="0" scope="page"/>
<c:forEach var="cst" items="${students}">
<tr>
<td style="visibility:hidden;">
${cst.id}
</td>
<td>
<c:out value="${pageScope.i =pageScope.i + 1}"></c:out>
</td>
<td>
${cst.name}
</td>
<td>
${cst.lastname}
</td>
<td>
${cst.email}
</td>
<td>
<a href="${pageContext.request.contextPath}/delete?id=${cst.id}" onclick='if(!confirm("Are you Sure!")) return (false);'  >Delete</a>
<a href="${pageContext.request.contextPath}/add?id=${cst.id}">Update</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</div>



</div>
</body>
</html>
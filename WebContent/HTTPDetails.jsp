<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.jsp" %>
<%@ page import="java.util.*"%>
<%@ page import="jdbc.*" %>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HTTP Details</title>
<style>
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 50%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
<% out.println("<h3>Request Details</h3>"); %>
<% response.setContentType("text/html"); %>


<ul>
<li>Request Method: <%=request.getMethod() %>
<li>Request URI: <%=request.getRequestURI() %>
<li>Request Protocol: <%=request.getProtocol() %>
<li>Server Name: <%=request.getServerName() %>
<li>Server Port: <%=request.getServerPort() %>
<li>Remote Address: <%=request.getServerPort() %>
<li>Browser: <%=request.getHeader("User-Agent") %>
</ul>

<br>

<ul>
<li>  <%@ include file="index.html" %>
<li>  <%@ include file="Date.jsp" %>
<%-- <li>  <jsp:include page="/ts" /> --%>
<%-- <li>  <jsp:forward page="/fws" /> --%>

<%-- <% request.getRequestDispatcher("/fws").forward(request, response); %>
 --%>

<h2>===========================================================================</h2>

<%
		out.println("<h3>Request Details</h3>");
	%>
	<%
		response.setContentType("text/html");
	%>
	<ul>
		<li>Request Method: <%=request.getMethod()%>
		<li>Request URL :<%=request.getRequestURI()%>
		<li>Request Protocol :<%=request.getProtocol()%>
		<li>Server Name :<%=request.getServerName()%>
		<li>Server Port :<%=request.getServerPort()%>
		<li>Remote Address: <%=request.getRemoteAddr()%>
		<li>Browser :<%=request.getHeader("User-Agent")%>
	</ul>
	<br>
	<ul>
		<li>Buffer Size: <%=response.getBufferSize()%> bytes <br />
		<li>Character Encoding :<%=response.getCharacterEncoding()%>
		<li>Locale: <%=response.getLocale()%>
		<li>Status: <%=response.getStatus()%>
	</ul>

	<ul>
		<li>Session CreationTime: <%=new Date(session.getCreationTime())%>
		<li>Session Id: <%=session.getId()%>
		<li>Session LastAccessedTime: <%=new Date(session.getLastAccessedTime())%>
		<li>Session MaxInactiveInterval: <%=session.getMaxInactiveInterval()%>
	</ul>

	<c:set var="salary" scope="session" value="${250*2}" />
	<p>
		Your salary is :
		<c:out value="${salary}" />
	</p>
	
	<c:choose>

		<c:when test="${salary <= 0}">
            Salary is very low to survive.
         </c:when>

		<c:when test="${salary > 1000}">
            Salary is very good.
         </c:when>

		<c:otherwise>
            No comment sir...
         </c:otherwise>
	</c:choose>


	<c:set var="empList" value="<%=new EmployeeDAO().getEmployeesHQLWithConditionsOrder()%>" />

	<table id="customers">
		<tbody>
			<tr>
				<th>FName</th>
				<th>LName</th>
				<th>Email</th>
			</tr>
			<c:forEach var="emp" items="<%=new EmployeeDAO().getEmployeesHQLWithConditionsOrder()%>"/>                                   <!--			<c:forEach var="emp" items="${empList}">
			  -->
				<tr>
					<td><c:out value="${emp.first_name}"></c:out></td>
					<td><c:out value="${emp.last_name}"></c:out></td>
					<td><c:out value="${emp.email}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>




	<h3>JSTL Format:</h3>
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<p>
		Formatted Date (1):
		<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
			value="${now}" />
	</p>
	
	<p>
		Formatted Date (1):
		<fmt:formatDate  dateStyle="long" 
			value="${now}" />
	</p>

	<p>
		Formatted Date (2):
		<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />
	</p>

	<h3>JSTL Functions:</h3>
	<c:set var="string1" value="This is first String." />
	<c:set var="string2" value="${fn:split(string1, ' ')}" />
	<c:set var="string3" value="${fn:join(string2, '-')}" />
	<p>Final String : ${string3}</p>
	
	
	
	<p> <c:out value="${cookie}"></c:out> </p>
<%-- 	   <% request.getRequestDispatcher("/fws").include(request, response);%>
 --%>
	<%-- <%@ include file="date.jsp" %> 
    <jsp:include page="/fws" />  
 
<%--   <jsp:forward page="/ts" />
 --%>


</body>
</html>
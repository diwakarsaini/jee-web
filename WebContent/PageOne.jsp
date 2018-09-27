<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="jdbc.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
h1{color:blue}
h2{color:yellow}
</style>
<title>First JSP</title>
</head>
<body bgcolor="cyan">
<h1>My First JSP</h1>
<h2><%= new String("My First JSP") %></h2>
<h2><%= new Date()  %></h2>
<%-- <h2><%= new EmployeeDAO().getEmployee().getFirst_name() %></h2> --%>
<%-- <h2><%= new EmployeeDAO().getEmployee().getLast_name() %></h2> --%>

<%-- <table border=1>
	<thead>
		<th>Fname</th>
		<th>Lname</th>
	</thead>
	
	<tr>
		<td><%= new EmployeeDAO().getEmployee().getFirst_name()%></td>
		<td><%= new EmployeeDAO().getEmployee().getLast_name()%></td>
	</tr>

</table> --%>

<%
EmployeeDAO eDAO = new EmployeeDAO();
List<Employee> ls = eDAO.getEmployeesHQLWithConditionsOrder();
Iterator<Employee> it = ls.iterator();
%>
<table border=1>
	<thead>
		<th>Fname</th>
		<th>Lname</th>
	</thead>
<%
while(it.hasNext()){
	Employee emp = it.next();
%>		
	<tr>
	<td><%= emp.getFirst_name()%></td>
	<td><%= emp.getJob_id()%></td>
</tr>

<%} %>
	
</table>






<%-- <% int i=0; 
for(i=0;i<10;i++){ %>
<h3>Hello man</h3>
<% } %>  --%>
<%-- 
<% int j=0;
for(j=0;j<10;j++){
	out.println("<h3>Hello " + j + count++ + "</h3>");
	}%>
	
<% 
for(j=0;j<10;j++){ %>
	<strong> hi <%=j %> <%= count++%></strong>
  <%} %>	
	
<%! int count=0; %> --%>




<h3>
	<jsp:useBean id="empl" class="jdbc.Employee" />
	<jsp:setProperty name="empl" property="first_name" value="Mahesh" />
	<jsp:getProperty name="empl" property="first_name"/>
</h3>







</body>
</html>
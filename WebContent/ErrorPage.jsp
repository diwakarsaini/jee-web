<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>In Error Page</h1>
<h2>Exception in error: <%= exception.getLocalizedMessage() %></h2>


<h2>Exception: <%= exception.getMessage() %></h2>
</body>
</html>
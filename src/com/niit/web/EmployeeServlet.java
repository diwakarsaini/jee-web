package com.niit.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(urlPatterns= {"/EmployeeServlet" , "/es"})
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sn=request.getSession();
		PrintWriter pw =response.getWriter();
		String url = "http://localhost:8080/NIITWeb/eds";
		String encodeUrl=response.encodeRedirectURL(url);
		pw.println(
		"<!DOCTYPE html>"+
		"<html>"+
		"<head>"+
		"<title>Form Servlet</title>"+
		"<meta name="+"\"viewport\""+ " content="+"\"width=device-width, initial-scale=1.0\"/>"+
		"<link rel="+"\"stylesheet\"" +" href="+"\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"" +
		" integrity="+"\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\""+ " crossorigin="+"\"anonymous\"/>"+
		"</head>"+
		"<body>"+
		"<div class="+"\"container-fluid bg-warning\">"+
		"<h1>Form</h1>"+
        "<Form"+ " action=\""+encodeUrl+"\""+"class=\"p-5 m-4 bg-info text-white\""+">"+
		"<div class="+"\"form-group row\">"+
		        "<div class="+"\"col-auto\">"+
		    "Department Name"+ "<input type="+"\"text\""+ "name="+"\"DepartmentName\""+"/>"+"<br/>"+
		    "</div>"+
		    "</div>"+
		    
		
		 
		"Submit Form:"+
		    "<input type="+"\"submit\""+ " value="+"\"SubmitThis\""+" />"+
		    
		  "</Form>"+
		  "</div>"+
	

		"<script src="+"\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"" +" integrity="+"\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\""+ " crossorigin="+"\"anonymous\""+"></script>"+
		"<script src="+"\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\""+ " integrity="+"\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\""+ " crossorigin="+"\"anonymous\">"+"</script>"+
		"<script src="+"\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\""+ " integrity="+"\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\""+ " crossorigin="+"\"anonymous\"></script>"+
		"</body>"+
		"</html>"
		);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

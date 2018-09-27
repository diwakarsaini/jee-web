package com.niit.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstWebServlet
 */
@WebServlet(
		urlPatterns = { 
				"/FirstWebServlet", 
				"/fws"
		}, 
		initParams = { 
				@WebInitParam(name = "name", value = "fname"), 
				@WebInitParam(name = "age", value = "30")
		})
public class FirstWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstWebServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		HttpSession sn=request.getSession();
		PrintWriter pw =response.getWriter();
		String url = "http://localhost:8080/NIITWeb/ss";
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
		    "First name:"+ "<input type="+"\"text\""+ "name="+"\"fname\""+"/>"+"<br/>"+
		    "Last name: <input type="+"\"text\""+ "name="+"\"lname\""+"/>"+"<br/>"+
		    "</div>"+
		    "</div>"+
		    "<div class="+"\"form-group row\">"+ 
		    "<div class="+"\"col\">"+
		   "<lable id="+"\"myl1\""+">Choose you car:</lable>"+
		   "Honda <input type="+"\"radio\""+ " name="+"\"cval\""+ " value=\"Honda\""+"/>"+
		   "Maruti <input type="+"\"radio\""+ " name="+"\"cval\""+ " value=\"Maruti\""+"/>"+
		   "Nissan <input type="+"\"radio\""+ " name="+"\"cval\""+ " value=\"Nissan\""+"/>"+
		"</div>"+
		"</div>"+
		"<div class="+"\"col\""+">"+
		 "choose you cycle:"+
		   "hero  <input type="+"\"checkbox\""+ " name="+"\"cval1\""+ " value="+"\"hero\""+"/>"+
		   "avon  <input type="+"\"checkbox\""+ " name="+"\"cval2\""+ " value="+"\"avon\""+"/>"+
		   "</div>"+

		   "<br/>"+
		   "choose you car:"+
		    "<select name="+"myop>"+
		        "<option value="+"volvo"+">Volvo</option>"+
		        "<option value="+"saab"+">Saab</option>" +
		        "<option value="+"mercedes"+">Mercedes</option>"+
		        "<option value="+"audi"+">Audi</option>"+
		    "</select>"+ 

		    "<br/>"+
		    "Add your Comment:"+
		    "<br/>"+
		    "<textarea rows=5"+" cols=20"+" name=myarea"+">My Area</textarea>"+
		    "<br/>"+
		    "Choose your Date:"+
		 "<input type="+"date" +" name="+"mdate>"+""+
		 "<br/>"+
		 "Choose your file:"+
		 "<input type="+"file"+ " name="+"myfile"+"/>"+
		 "<br/>"+
		
		 "Reset Form:"+
		"<input type="+"\"reset\""+"/>" +
		"<br/>"+
		 
		"Submit Form:"+
		    "<input type="+"\"submit\""+ " value="+"\"SubmitThis\""+" />"+
		    
		  "</Form>"+
		  "</div>"+
	

		"<script src="+"\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"" +" integrity="+"\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\""+ " crossorigin="+"\"anonymous\""+"></script>"+
		"<script src="+"\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\""+ " integrity="+"\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\""+ " crossorigin="+"\"anonymous\">"+"</script>"+
		"<script src="+"\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\""+ " integrity="+"\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\""+ " crossorigin="+"\"anonymous\"></script>"+
		"</body>"+
		"</html>"
		);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doTrace(HttpServletRequest, HttpServletResponse)
	 */
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

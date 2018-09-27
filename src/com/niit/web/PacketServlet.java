package com.niit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PacketServlet
 
@WebServlet(
		urlPatterns = { "/PacketServlet" }, 
		initParams = { 
				@WebInitParam(name = "myname", value = "Fname1")
		})*/
public class PacketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

		
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
			
		res.setContentType("text/html");   // set header field first   
        PrintWriter pw = res.getWriter(); // then get writer & write response data 
        pw.println("<!DOCTYPE html/>");
        pw.println("<HTML>");
        pw.println("<HEAD><TITLE>Welcome</TITLE>");
        pw.println("<style>" + 
        		"table,th,td{" + 
        		"border: 1px solid yelllow" + 
        		"}" + 
        		"</style>");
        pw.println("</HEAD>");
        pw.println("<BODY>");
        pw.println("<H3>" + "Welcome to Java Servlet Technology!! yadadadadad" + "</H3>");
        Cookie cookie = new Cookie("MyCookie1","MyValue1");
        cookie.setDomain("MyWebAPP1");
        res.addCookie(cookie);
        printAllRequestHeaders(request,pw);
        printAllResponseHeaders(res,pw);
        printAllCookies(request,pw);
        printAllParameters(request,pw);
        printAllStaticParam(request,pw);
        pw.println("</BODY>");
        pw.println("</HTML>"); 
        pw.close();   
        
        System.out.println("######################################IN servlet ");
		
		
	}
	
	private void printAllStaticParam(HttpServletRequest request, PrintWriter pw) {
		ServletConfig sc = getServletConfig();
		pw.println("<p>"+sc.getInitParameter("firstName")+"</p>");
		ServletContext scx = sc.getServletContext();
		String str = scx.getServerInfo() + " " + scx.getVirtualServerName() + " " + scx.getSessionTimeout();
		pw.println("<p>"+str+"</p>");
	}
	
	
	private void printAllParameters(HttpServletRequest request, PrintWriter pw) {
		pw.println("<strong>Parameters</strong>");
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String pName=paramNames.nextElement();
			String pValue = request.getParameter(pName);
			pw.println("<br><p>"+pName+"</p> :<p>"+pValue+"</p><br>");
		}
		
	}

	private void printAllCookies(HttpServletRequest request, PrintWriter pw) {
		Cookie[] cookies = request.getCookies();
		
		pw.println("<br><br><strong>Cookies</strong>");
		if(cookies==null) {
			pw.println("<br><br><strong>Null Cookies</strong>");
			return;
		}
		for(Cookie cookie : cookies){
			String str = cookie.getPath()+ " " +cookie.getDomain()+  " "+cookie.getName()
			+ " "+ cookie.getValue();
			pw.println("<p>"+str+"</p>");
		}
		
	}

	private void printAllResponseHeaders(HttpServletResponse res, PrintWriter pw) {
		pw.println("<br><strong>ResponseHeaders</strong>");
		 Collection<String> hdrList = res.getHeaderNames();
		
		  for(String hdrName:hdrList) {
			 
			  String hdrval=res.getHeader(hdrName);
			  pw.println("<p>"+hdrName+" : "+hdrval+"</p>");
		  }
			
		  pw.println("<br><strong>End ResponseHeaders</strong>");
	}

	private void printAllRequestHeaders(HttpServletRequest request,PrintWriter pw) {
		pw.println("<strong>RequestHeaders</strong>");
		
	  Enumeration<String> en = request.getHeaderNames();
	  pw.println("<table>");
	  while (en.hasMoreElements()) {
		  
		  String s=en.nextElement();
		  String st=request.getHeader(s);
		  pw.println("<tr>");
		  pw.println("<td>"+s+" : "+st+"</td>");
		  pw.println("</tr>");
	  }
	  //pw.println("<p>"+"referer"+" : "+request.getHeader("Referer")+"</p>");
	  pw.println("</table>");
	  pw.println("<strong>End RequestHeaders</strong>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("######################################IN servlet ");
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

	

}

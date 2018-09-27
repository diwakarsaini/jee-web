package com.niit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/ss")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sn=request.getSession();
		PrintWriter pw = visitCount(response, sn);
		pw=printAllItems(response, request, sn);
		
		printAllParameters(request,pw);
		
		String url = "http://localhost:8080/NIITWeb/fws";
		String encodeURL = response.encodeRedirectURL(url);
	    pw.println("<a href =\""+encodeURL+"\">"+"<p>This is fws</p>"+"</a>");
//		request.getRequestDispatcher("/wel").forward(request, response);
//		request.getRequestDispatcher("/ts").forward(request, response);
		//
	    if(request.getParameter("lname").equals("logout")) {
	    	sn.invalidate();
	    };
	    
		request.getRequestDispatcher("/ts").include(request, response);
		request.getRequestDispatcher("/welcome").include(request, response);
		
	}

	private PrintWriter printAllItems(HttpServletResponse response, HttpServletRequest request,HttpSession sn) throws IOException {
		synchronized(sn){
		@SuppressWarnings("unchecked")
		List<String> previousItems =
		(List<String>)sn.getAttribute("previousItems");
		if (previousItems == null) {
		previousItems = new ArrayList<String>();
		}
		String newItem = request.getParameter("fname");
		if ((newItem != null) &&
		(!newItem.trim().equals(""))) {
		previousItems.add(newItem);
		}
	    sn.setAttribute("previousItems", previousItems);
	    PrintWriter pw =response.getWriter();
	    if(request.getParameter("lname").equals("Print")) {
	    	for(String st:previousItems) {
	    	pw.println("<h3>"+st+"</h3>");	
	    	}
	    }
	    return pw;
		}
		
		
	}

	private PrintWriter visitCount(HttpServletResponse response, HttpSession sn) throws IOException {
		String heading;
		Integer accessCount =
		(Integer)sn.getAttribute("accessCount");
		if (accessCount == null) {
		accessCount = 0;
		heading = "Welcome, Newcomer";
		} else {
		heading = "Welcome Back for your "+accessCount+" visit";
		accessCount = accessCount + 1;
		}
		sn.setAttribute("accessCount", accessCount);
		response.setContentType("text/html"); 
				
		PrintWriter pw =response.getWriter();
		pw.println("<h2>"+heading+"</h2>");
		return pw;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void printAllParameters(HttpServletRequest request, PrintWriter pw) {
		pw.println("<strong>Parameters</strong>");
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String pName=paramNames.nextElement();
			String pValue = request.getParameter(pName);
			pw.println("<p>"+pName+":"+pValue+"</p>");
		}
		
	}

}

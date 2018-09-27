package com.niit.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Employee;
import jdbc.EmployeeDAO;

/**
 * Servlet implementation class EmployeeDatabaseServlet
 */
@WebServlet(urlPatterns= {"/EmployeeDatabaseServlet" , "/eds"})
public class EmployeeDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String nameOfDepartment = request.getParameter("DepartmentName");
		EmployeeDAO employees= new EmployeeDAO();
		List<Employee> ls = employees.getEmployeesHQLFromDept(nameOfDepartment);
		Iterator it = ls.iterator();
		
		pw.println("<table border=\"1\"> <thead> <th>Lname</th> <th>Department</th> </thead>");
		while(it.hasNext()) {
			Object[] emp = (Object[]) it.next();
			pw.println("<tr><td>" + emp[0] + "</td><td>  " + emp[1] + "</td></tr>");
			System.out.println(emp[0]+"  "+emp[1]);
		}
		pw.println("</table>");
		
		
//		PrintWriter pw = response.getWriter();
//		String nameOfDepartment = request.getParameter("DepartmentName");
//		EmployeeDAO employees= new EmployeeDAO();
//		List<Employee> ls = employees.getEmployeesHQLFromDept(nameOfDepartment);
//		Iterator<Employee> it = ls.iterator();
//		while(it.hasNext()) {
//			Employee emp = it.next();				// this wont work because join is used and returning table is not of employee type
//			pw.println("<p>"+ emp.getFirst_name() +"  "+ emp.getLast_name() +"</p>");
//			System.out.println(emp.getFirst_name()+"  "+emp.getLast_name());
//		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

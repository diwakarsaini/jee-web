package com.niit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AccessLogFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/AccessLogFilter", "/ts" })
public class AccessLogFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AccessLogFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		System.out.println(req.getRemoteHost() + 
				" tried to access " + req.getRequestURL() + " on " + new Date() + ".");

		PrintWriter pw = res.getWriter();
		pw.append("<h2>From Access Filter "+res.getClass()+"</h2>");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

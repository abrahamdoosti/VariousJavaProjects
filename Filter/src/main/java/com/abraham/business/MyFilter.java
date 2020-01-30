package com.abraham.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//out.println("my-param (InitParameter): " + filterConfig.getInitParameter("my-param \n"));
		Enumeration<String> parameters = request.getParameterNames();
		if (parameters.hasMoreElements()) {
			while (parameters.hasMoreElements()) {
				String name = parameters.nextElement();
				String value = request.getParameter(name);
				out.println("name " + name + " Value " + value);
			}
		}
		else {
			out.println("---None---<br/>");
		}

		out.println("<br/>Start Regular Content:<br/><hr/>");
		filterChain.doFilter(request, response);
		out.println("<br/><hr/>End Regular Content:<br/>");

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}

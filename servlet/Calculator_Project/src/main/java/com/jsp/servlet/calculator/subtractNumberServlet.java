package com.jsp.servlet.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class subtractNumberServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String num1=req.getParameter("num1");
		int n1= Integer.parseInt(num1);
		int n2=Integer.parseInt(req.getParameter("num2"));
		
		
		int Sub = n1-n2;
		PrintWriter pw=res.getWriter();
		pw.print("<h1>The sub value is :"+Sub+"</h1>");
		
		
	}

}

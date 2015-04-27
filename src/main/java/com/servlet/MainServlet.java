package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.java.CarManager;

public class MainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarManager carManager = (CarManager) getServletContext().getAttribute("carManager");
		String[] carNumbers = carManager.getCarNumbers();
		request.setAttribute("carNumbers", carNumbers); 
		RequestDispatcher view = request.getRequestDispatcher("input.jsp");
		view.forward(request, response);
	}
}

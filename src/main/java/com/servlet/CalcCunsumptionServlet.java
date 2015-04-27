package com.servlet;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.java.CarManager;

public class CalcCunsumptionServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarManager carManager = (CarManager) getServletContext().getAttribute("carManager");
		String[] carNumbers = carManager.getCarNumbers();
		String[] distances = request.getParameterValues("distance");
		TreeMap<String, Double> resultData = carManager.calcConsumption(carNumbers, distances);
		request.setAttribute("data", resultData);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}
}

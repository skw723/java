package com.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.java.io.InputManager;
import com.java.io.OutputManager;
import com.java.io.impl.ConsoleOutputManager;
import com.java.io.impl.FileInputManager;
import com.servlet.java.CarManager;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		System.out.println("container destroy");
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("container start");
		ServletContext ctx = e.getServletContext();
		
		InputManager input = new FileInputManager();
		OutputManager output = new ConsoleOutputManager();
		CarManager carManager = new CarManager(input, output, ctx.getRealPath("/"));
		carManager.procAddCars();
		
		ctx.setAttribute("carManager", carManager);
	}
}
package com;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/UpdateCar")
public class UpdateCarServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int carId = Integer.parseInt(request.getParameter("carId"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarPU");
        EntityManager em = emf.createEntityManager();

        Car car = em.find(Car.class, carId);

        request.setAttribute("Car", car);
        RequestDispatcher rd = request.getRequestDispatcher("UpdateCar.jsp");
        rd.forward(request, response);

    }
}

package com;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DeleteCar")
public class DeleteCarServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("carId"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Car c = em.find(Car.class, carId);

        et.begin();

        em.remove(c);
        et.commit();

        response.sendRedirect("DisplayAllCars");

    }
}

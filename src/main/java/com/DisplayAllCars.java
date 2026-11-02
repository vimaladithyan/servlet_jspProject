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
import java.util.List;

@WebServlet("/DisplayAllCars")
public class DisplayAllCars extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarPU");
        EntityManager em = emf.createEntityManager();

        List<Car> cars=em.createQuery("from Car", Car.class).getResultList();

        request.setAttribute("ListOfCars", cars);
        RequestDispatcher rd = request.getRequestDispatcher("DisplayCar.jsp");
        rd.forward(request, response);
    }
}

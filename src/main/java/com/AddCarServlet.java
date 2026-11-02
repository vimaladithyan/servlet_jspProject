
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

@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int carId = Integer.parseInt(request.getParameter("carId"));
        String carModel = request.getParameter("carModel");
        String carBrand = request.getParameter("carBrand");
        String carColor = request.getParameter("carColor");
        int carPrice = Integer.parseInt(request.getParameter("carPrice"));

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("CarPU");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        Car c = new Car();

        c.setCarId(carId);
        c.setCarModel(carModel);
        c.setCarBrand(carBrand);
        c.setCarColor(carColor);
        c.setCarPrice(carPrice);

        em.persist(c);

        et.commit();

        response.sendRedirect("index.jsp");

        em.close();
        emf.close();
    }
}
 
package Servlet;

import Dao.UserDao;
import Model.Reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reservation")
public class reservation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reservationFrom = req.getParameter("from");
        String reservationTo = req.getParameter("to");
        int seatNum = Integer.parseInt(req.getParameter("seatNumber"));
        String tName = req.getParameter("tName");
        String cType = req.getParameter("cType");
        String dJourney = req.getParameter("dJourney");

        PrintWriter writer = resp.getWriter();
        Reservation reservation = Reservation.builder()
                .reservationFrom(reservationFrom).reservationTo(reservationTo)
                .trainName(tName).classType(cType).seatNum(seatNum).dateOfJourney(dJourney).build();

        //writer.println(reservation);
        UserDao userDao = new UserDao();
        boolean detail = userDao.addReservationDetail(reservation);
        //writer.println(detail);
        HttpSession session = req.getSession();
        if (detail) {
            session.setAttribute("msg", "To conform your ticket please enter email and PNR number");
            resp.sendRedirect("PnrConformation.jsp");
        } else {
            session.setAttribute("msg", "Something wrong.!");
            resp.sendRedirect("UserInterface.jsp");
        }
    }
}

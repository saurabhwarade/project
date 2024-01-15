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
@WebServlet("/delete")
public class CancelReservation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("delete"));

        UserDao userDao = new UserDao();
        boolean b = userDao.cancelReservation(id);
        HttpSession session = req.getSession();
        if (b){
            session.setAttribute("msg","Reservation is canceled");
            resp.sendRedirect("ReservationDetail.jsp");
        }
    }
}

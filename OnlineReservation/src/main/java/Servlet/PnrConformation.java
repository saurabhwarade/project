package Servlet;

import Dao.UserDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/pnr")
public class PnrConformation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        int pnrNum = Integer.parseInt(req.getParameter("pnr"));
      User user = User.builder().email(email).userId(pnrNum).build();
       /* User user = new User();
        user.setEmail(email);
        user.setUserId(pnrNum);*/
        PrintWriter writer = resp.getWriter();
        writer.println(user);
        UserDao userDao = new UserDao();
        User pnr1 = userDao.pnr(email, pnrNum);
        HttpSession session = req.getSession();
        if (pnr1!=null){
            session.setAttribute("msg","Seat is book");
            resp.sendRedirect("UserInterface.jsp");
        }
        else {
            session.setAttribute("msg","Invalid credential. Enter correct email and PNR");
            resp.sendRedirect("PnrConformation.jsp");
        }
    }
}

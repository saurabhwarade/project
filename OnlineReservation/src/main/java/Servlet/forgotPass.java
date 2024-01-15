package Servlet;


import Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/forgot")
public class forgotPass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        int password = Integer.parseInt(req.getParameter("password"));
        /*User user = User.builder()
                .email(email)
                .password(pass)
                .build();*/


        UserDao userDao = new UserDao();
        // productController.updaatUser(email,password);
        boolean b = userDao.fPass(email, password);

        HttpSession session = req.getSession();
        if (b) {
            resp.sendRedirect("index.jsp");
            session.setAttribute("msg", "Password Updated...!  you are ready to login");
        }

    }
}
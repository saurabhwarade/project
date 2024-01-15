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

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String mobileNumber = req.getParameter("mobNumber");
        String email = req.getParameter("email");
        int pass = Integer.parseInt(req.getParameter("password"));
        PrintWriter writer = resp.getWriter();
      /*  writer.println(name);
        writer.println(courseName);
        writer.println(email);
        writer.println(password);
*/
        //  resp.setContentType("text/html");
        /*User user = new User();
        user.setName(name);
                user.setMobileNumber(mobileNumber);
                user.setEmail(email);
                user.setPassword(pass);*/
        User user = User.builder()
                .name(name).mobileNumber(mobileNumber).email(email).password(pass).build();

        //writer.println(user);
    //  UsertController productController = new UserController();
        UserDao userDao = new UserDao();
        boolean u = userDao.addUser(user);
        // System.out.println(u);
        HttpSession session = req.getSession();
        if (u) {
            session.setAttribute("msg", "Registration Success.. Login Now.!");
            resp.sendRedirect("index.jsp");
        } else {
            session.setAttribute("msg", "Something wrong.!");
            resp.sendRedirect("register.jsp");
        }
    }
}

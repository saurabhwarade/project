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

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        int password = Integer.parseInt(req.getParameter("password"));
        PrintWriter writer = resp.getWriter();
       /* writer.println(email);
        writer.println(password);*/

        UserDao productController=new UserDao();
        User login = productController.login(email, password);

        HttpSession session = req.getSession();

        if (login!=null){
            session.setAttribute("msg","Login Success..");


           session.setAttribute("userData",login.getUserId());
           session.setAttribute("userName",login.getName());
            resp.sendRedirect("UserInterface.jsp");
        }
        else {
            session.setAttribute("msg","Invalid Credential..Please enter valid email and Password");
            resp.sendRedirect("index.jsp");
        }
    }
}

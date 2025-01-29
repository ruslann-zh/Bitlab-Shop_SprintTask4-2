package Bitlab_Shop;

import Bitlab_Shop.db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/signin")
public class SigninServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/signin?Error";
        List<Users> userList = DBManager.getUsers();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        for (Users user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                redirect = "/welcome?email=" + email;
                break;
            }
        }
        resp.sendRedirect(redirect);
    }
}

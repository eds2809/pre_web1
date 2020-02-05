package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class mainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("users", UserService.instance.getAllUsers());
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean result = false;
        try {
            switch (req.getParameter("action")) {
                case "delete":
                    result = UserService.instance.delUser(Long.parseLong(req.getParameter("id")));
                    break;
                case "put":
                    result = UserService.instance.addUser(req.getParameter("name"));
                    break;
                case "update":
                    result = UserService.instance.updateUser(
                            Long.parseLong(req.getParameter("id")),
                            req.getParameter("name")
                    );
                    break;
            }
        } catch (NullPointerException ignored) {

        }

        if (result) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.sendRedirect("/web1/");
    }
}

package Utils;

import Controllers.UserServlet;
import dao.UserDAO;
import entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ListUserCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        listUser(request, response, Util.getConnection());
    }
    public static void listUser (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws SQLException, IOException, ServletException {

        List<User> listUser = UserDAO.getUserList(conn);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userdetails.jsp");
        dispatcher.forward(request, response);
    }
}

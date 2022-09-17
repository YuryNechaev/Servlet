package Utils;

import dao.UserDAO;
import entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ShowEditFormCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        showEditForm(request, response, Util.getConnection());
    }
    public static void showEditForm (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = UserDAO.selectUser(id, conn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }
}

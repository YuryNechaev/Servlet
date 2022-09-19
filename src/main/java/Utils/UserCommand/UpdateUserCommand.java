package Utils.UserCommand;

import Controllers.UserServlet;
import Utils.Command;
import Utils.Util;
import dao.UserDAO;
import entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class UpdateUserCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        updateUser(request, response, Util.getConnection());
    }
    public static void updateUser (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User updatedUser = new User();
        updatedUser.setId(id);
        updatedUser.setFirstName(request.getParameter("firstName"));
        updatedUser.setLastName(request.getParameter("lastName"));
        updatedUser.setAge(Integer.parseInt(request.getParameter("age")));
        UserDAO.updateUser(updatedUser, conn);
        response.sendRedirect("list");
    }
}

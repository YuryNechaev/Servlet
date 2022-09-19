package Utils.UserCommand;

import Controllers.UserServlet;
import Utils.Command;
import Utils.Util;
import dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DeleteUserCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        deleteUser(request, response, Util.getConnection());
    }
    public static void deleteUser (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO.deleteUser(conn, id);
        response.sendRedirect("list");

    }
}

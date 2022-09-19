package Utils.ActivityCommand;

import Utils.Command;
import Utils.Util;
import dao.ActivityDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DeleteActivityCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        deleteActivity(request, response, Util.getConnection());
    }
    public static void deleteActivity (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ActivityDAO.deleteActivity(conn, id);
        response.sendRedirect("activities");

    }
}

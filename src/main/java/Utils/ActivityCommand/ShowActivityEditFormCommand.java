package Utils.ActivityCommand;

import Utils.Command;
import Utils.Util;
import dao.ActivityDAO;
import entities.Activity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ShowActivityEditFormCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        showEditForm(request, response, Util.getConnection());
    }
    public static void showEditForm (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Activity existingActivity = ActivityDAO.selectActivity(id, conn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("newActivity.jsp");
        request.setAttribute("activity", existingActivity);
        dispatcher.forward(request, response);

    }
}

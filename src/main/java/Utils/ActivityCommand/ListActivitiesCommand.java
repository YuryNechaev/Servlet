package Utils.ActivityCommand;

import Utils.Command;
import Utils.Util;
import dao.ActivityDAO;
import dao.UserDAO;
import entities.Activity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ListActivitiesCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        listActivities(request, response, Util.getConnection());
    }
    public static void listActivities (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws SQLException, IOException, ServletException {

        List<Activity> listActivities = ActivityDAO.getActivityList(conn);
        request.setAttribute("listActivities", listActivities);
        RequestDispatcher dispatcher = request.getRequestDispatcher("activities.jsp");
        dispatcher.forward(request, response);
    }
}

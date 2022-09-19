package Utils.ActivityCommand;

import Utils.Command;
import Utils.Util;
import dao.ActivityDAO;
import dao.UserDAO;
import entities.Activity;
import entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class UpdateActivityCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        updateActivity(request, response, Util.getConnection());
    }
    public static void updateActivity (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Activity updatedActivity = new Activity();
        updatedActivity.setId(id);
        updatedActivity.setStudentName(request.getParameter("studentName"));
        updatedActivity.setActivityType(request.getParameter("activityType"));
        updatedActivity.setActivityDate(request.getParameter("activityDate"));
        updatedActivity.setProlongation(Integer.parseInt(request.getParameter("prolongation")));
        updatedActivity.setStatus(request.getParameter("status"));
        ActivityDAO.updateActivity(updatedActivity, conn);
        response.sendRedirect("activities");
    }
}

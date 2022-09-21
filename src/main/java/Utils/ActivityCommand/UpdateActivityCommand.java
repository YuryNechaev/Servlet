package Utils.ActivityCommand;

import Utils.Command;
import Utils.Util;
import dao.ActivityDAO;
import entities.Activity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("studentName"));
        System.out.println(request.getParameter("activityType"));
        System.out.println(request.getParameter("activityDate"));
        System.out.println(request.getParameter("prolongation"));
        System.out.println(request.getParameter("status"));
        updatedActivity.setActivityDate(Date.valueOf(request.getParameter("activityDate")));
        updatedActivity.setProlongation(Integer.parseInt(request.getParameter("prolongation")));
        updatedActivity.setStatus(request.getParameter("status"));
        ActivityDAO.updateActivity(updatedActivity, conn);
        response.sendRedirect("activities");
    }
}

package Utils.ActivityCommand;

import Utils.Command;
import Utils.Util;
import dao.ActivityDAO;
import entities.Activity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertActivityCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        insertActivity(request, response, Util.getConnection());
    }
    public static void insertActivity (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws SQLException, IOException {
        Activity newActivity = new Activity();
        newActivity.setStudentName(request.getParameter("studentName"));
        newActivity.setActivityType(request.getParameter("activityType"));
        newActivity.setActivityDate(request.getParameter("activityDate"));
        newActivity.setProlongation(Integer.parseInt(request.getParameter("prolongation")));
        ActivityDAO.insertActivity(newActivity, conn);
        response.sendRedirect("activities");
    }
}

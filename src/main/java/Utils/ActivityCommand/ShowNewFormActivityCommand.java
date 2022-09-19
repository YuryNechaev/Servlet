package Utils.ActivityCommand;

import Utils.Command;
import Utils.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class ShowNewFormActivityCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        showNewActivityForm(request, response, Util.getConnection());
    }
    public static void showNewActivityForm (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("newActivity.jsp");
        dispatcher.forward(request, response);
    }
}

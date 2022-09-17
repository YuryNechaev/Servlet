package Utils;

import dao.UserDAO;
import entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertUserCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        insertUser(request, response, Util.getConnection());
    }
    public static void insertUser (HttpServletRequest request, HttpServletResponse response, Connection conn)
            throws SQLException, IOException {
        User newUser = new User();
        newUser.setFirstName(request.getParameter("firstName"));
        newUser.setLastName(request.getParameter("lastName"));
        newUser.setAge(Integer.parseInt(request.getParameter("age")));
        UserDAO.registerUser(newUser, conn);
        response.sendRedirect("list");
    }
}

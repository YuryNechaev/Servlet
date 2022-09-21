package dao;

import entities.Activity;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO {

    private static final String SELECT_ACTIVITY_BY_ID = "select id, student_name, activity_type, activity_data, prolongation, status from activity where id =?;";

    private static final String SELECT_ALL_ACTIVITIES = "select * from activity;";

    private static final String DELETE_ACTIVITY_SQL = "delete from activity where id = ?;";
    private static final String UPDATE_ACTIVITY_SQL = "UPDATE activity SET student_name = ?, activity_type= ?,activity_data= ?, prolongation =?, status=? where id = ?;";
    private static final String INSERT_ACTIVITY_SQL = "INSERT INTO activity" +
            "  (student_name, activity_type, activity_data, prolongation, status) VALUES " +
            " (?, ?, ?, ?, ?);";

    public static int insertActivity(Activity activity, Connection conn) throws SQLException {

        int result = 0;

        PreparedStatement stm = conn.prepareStatement(INSERT_ACTIVITY_SQL);
        int i = 1;
        stm.setString(i++, activity.getStudentName());
        stm.setString(i++, activity.getActivityType());
        stm.setDate(i++, Date.valueOf(LocalDate.now()));
        stm.setInt(i++, activity.getProlongation());
        stm.setString(i++, activity.getStatus());

        System.out.println(stm);

        result = stm.executeUpdate();

        return result;
    }


    public static Activity selectActivity(int id, Connection conn) throws SQLException {
        Activity activity = new Activity();

        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ACTIVITY_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                activity.setId(id);
                activity.setStudentName(rs.getString("student_name"));
                activity.setActivityType(rs.getString("activity_type"));
                activity.setActivityDate(rs.getDate("activity_data"));
                activity.setProlongation(rs.getInt("prolongation"));
                activity.setStatus(rs.getString("status"));
            }

        return activity;
    }

    public static List<Activity> getActivityList(Connection conn) throws SQLException {

        PreparedStatement stm = conn.prepareStatement(SELECT_ALL_ACTIVITIES);

        ResultSet rs = stm.executeQuery();

        List<Activity> list = new ArrayList<>();

        while (rs.next()) {
            Activity activity = new Activity();
            activity.setId(rs.getInt("id"));
            activity.setStudentName(rs.getString("student_name"));
            activity.setActivityType(rs.getString("activity_type"));
            activity.setActivityDate(rs.getDate("activity_data"));
            activity.setProlongation(rs.getInt("prolongation"));
            activity.setStatus(rs.getString("status"));
            list.add(activity);
        }
        return list;

    }

    public static boolean deleteActivity(Connection conn, int id) throws SQLException {
        boolean activityDeleted;

        PreparedStatement stm = conn.prepareStatement(DELETE_ACTIVITY_SQL);

        int i = 1;

        stm.setInt(i++, id);
        activityDeleted = stm.executeUpdate() > 0;
        return activityDeleted;

    }

    public static boolean updateActivity(Activity activity, Connection conn) throws SQLException {
        boolean rowUpdated;
        PreparedStatement statement = conn.prepareStatement(UPDATE_ACTIVITY_SQL);
        System.out.println(statement);
            int i = 1;
            statement.setString(i++, activity.getStudentName());
            statement.setString(i++, activity.getActivityType());
            statement.setDate(i++, activity.getActivityDate());
            statement.setInt(i++, activity.getProlongation());
            statement.setString(i++, activity.getStatus());
            statement.setInt(i++, activity.getId());

            System.out.println(statement);

            rowUpdated = statement.executeUpdate() > 0;


        return rowUpdated;
    }

    private static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
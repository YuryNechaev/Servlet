package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class Util {

    public static Map<String, Command> roots = new HashMap<>();

    static {
        roots.put("/new", new ShowNewFormCommand());
        roots.put("/insert", new InsertUserCommand());
        roots.put("/delete", new DeleteUserCommand());
        roots.put("/update", new UpdateUserCommand());
        roots.put("/edit", new ShowEditFormCommand());

    }

    public static Command getRootFromMap(String action){
        Command command;
        if(!roots.containsKey(action)) {
            command=new ListUserCommand();
        }
        else {
            command = roots.get(action);
        }
        return command;
    }



    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection("jdbc:postgresql://130.211.61.134:5432/postgres", "postgres", "postgres");
    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        getConnection();
//        System.out.println("connected");
//    }

}

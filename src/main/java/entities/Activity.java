package entities;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Activity {

    private int id;
    private String studentName;
    private String activityType;
    private Date activityDate;
    private int prolongation;
    private String status = "valid";

//    public static void main(String[] args) {
//        Activity activity = new Activity();
//        activity.setActivityDate(Date.valueOf(request.getParameter("activityDate")));
//    }
}

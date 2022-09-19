package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Activity {

    private int id;
    private String studentName;
    private String activityType;
    private String activityDate;
    private int prolongation;
    private String status = "valid";
}

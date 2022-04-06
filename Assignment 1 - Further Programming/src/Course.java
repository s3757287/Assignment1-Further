import java.util.ArrayList;

public class Course {
    private String courseID;
    private String name;
    private String credit;

    ArrayList<Course> courseArray = new ArrayList<>();

    public Course(){}

    public Course(String courseID, String name, String credit){
        this.courseID = courseID;
        this.name = name;
        this.credit = credit;
    }

    public String getCourseID(){
        return courseID;
    }

    public void getAllCourse(){
        for (Course course : courseArray){
            System.out.println(course.toString());
        }
    }

    @Override
    public String toString(){
        return "Course ID: " + courseID + " " +
                "| Name: " + name + " " +
                "| Credits: " + credit;
    }
}

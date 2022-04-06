import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentEnrolment{
    private String student;
    private String course;
    private String semester;

    public StudentEnrolment() {
    }

    public StudentEnrolment(String student, String course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student: " + student +
                " | Course: " + course +
                " | Semester: " + semester;
    }
}


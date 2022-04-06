import java.util.ArrayList;

public interface StudentEnrolmentManager {
    void addEnrolment(StudentEnrolment newEnrolment);
    void updateAdd(StudentEnrolment updateAdd);
    void updateDelete(StudentEnrolment updateDelete);
    void deleteEnrolment(StudentEnrolment delete);
    void getOne(int One);
    void getAll();
    ArrayList<StudentEnrolment> studentEnrolment = new ArrayList<>();
}

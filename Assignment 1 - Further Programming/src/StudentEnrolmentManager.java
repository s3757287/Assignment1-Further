import java.util.ArrayList;

public interface StudentEnrolmentManager {
    void addEnrolment(StudentEnrolment newEnrolment);
    void updateEnrolment(StudentEnrolment updateData, StudentEnrolment update);
    void deleteEnrolment();
    void getOne();
    void getAll();
    ArrayList<StudentEnrolment> studentEnrolment = new ArrayList<>();
}

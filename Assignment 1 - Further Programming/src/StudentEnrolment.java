public class StudentEnrolment implements StudentEnrolmentManager{
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


    @Override
    public void addEnrolment(StudentEnrolment newEnrolment) {
        studentEnrolment.add(newEnrolment);
        System.out.println("Enrol Success " + newEnrolment.toString());
    }

    @Override
    public void updateAdd(StudentEnrolment updateAdd) {
        studentEnrolment.add(updateAdd);
    }

    @Override
    public void updateDelete(StudentEnrolment updateDelete) {
        studentEnrolment.remove(updateDelete);
    }

    @Override
    public void deleteEnrolment(StudentEnrolment delete) {
        studentEnrolment.remove(delete);
    }

    @Override
    public void getOne(int One) {
        System.out.println(studentEnrolment.get(One).toString());
    }

    @Override
    public void getAll() {
        for(int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++){
            System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).toString());
        }
    }
}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Student student = new Student();
        Course course = new Course();
        Scanner scanner = new Scanner(System.in);
        StudentEnrolment studentEnrolment = new StudentEnrolment();
        boolean loop;

        try {
            File sourceDefault = new File("default.csv");
            Scanner fileRead = new Scanner(sourceDefault);
            System.out.println("Data: ");
            String info = null;
            while (fileRead.hasNextLine()) {
                info = fileRead.nextLine();
                System.out.println(info);
                String dup = "No";
                String dup1 = "No";

                if (student.studentArray.size() == 0) {
                    Student student1 = new Student(info.split(",")[0], info.split(",")[1], info.split(",")[2]);
                    student.studentArray.add(student1);
                } else {
                    for (int i = 0; i < student.studentArray.size(); i++) {
                        if (student.studentArray.get(i).getID().equalsIgnoreCase(info.split(",")[0])) {
                            dup = "Yes";
                            break;
                        }
                    }
                    if (dup.equalsIgnoreCase("No")) {
                        Student student2 = new Student(info.split(",")[0], info.split(",")[1], info.split(",")[2]);
                        student.studentArray.add(student2);
                    }
                }

                if (course.courseArray.size() == 0) {
                    Course course1 = new Course(info.split(",")[3], info.split(",")[4], info.split(",")[5]);
                    course.courseArray.add(course1);
                } else {
                    for (int i = 0; i < course.courseArray.size(); i++) {
                        if (course.courseArray.get(i).getCourseID().equalsIgnoreCase(info.split(",")[3])) {
                            dup1 = "Yes";
                            break;
                        }
                    }
                    if (dup1.equalsIgnoreCase("No")) {
                        Course course2 = new Course(info.split(",")[3], info.split(",")[4], info.split(",")[5]);
                        course.courseArray.add(course2);
                    }
                }

                StudentEnrolment enrolment = new StudentEnrolment(info.split(",")[0], info.split(",")[3], info.split(",")[6]);
                StudentEnrolmentManager.studentEnrolment.add(enrolment);
            }
            fileRead.close();
            System.out.println("\n");

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found\n");
        }

        Scanner scanner1 = new Scanner(System.in);
        while (!Objects.equals(null,"Quit")){
            System.out.println("Welcome\n" +
                    "What would you like to do?\n" +
                    "~~~~~~~~~~~~~~~~~~~\n" +
                    "1) Add Enrolment\n" +
                    "2) Update Enrolment\n" +
                    "3) Withdraw\n" +
                    "4) Print Data\n" +
                    "5) Quit");
            String option = "";
            if (scanner1.hasNext()){
                option = scanner1.next();
            }
            switch (option){
                case "1" -> {
                    loop = true;
                    while (loop){
                        System.out.println("New Enrolment\n" +
                                "Enter Student ID: ");
                        String studentID = scanner.next();
                        String valid = "";
                        for (int i = 0; 1 < student.studentArray.size(); i++){
                            if (studentID.equalsIgnoreCase(student.studentArray.get(i).getID())){
                                valid = "Valid";
                                break;
                            }
                        }
                        if(!valid.equalsIgnoreCase("Valid")){
                            System.out.println("Invalid ID");
                            continue;
                        }
                        String enrolStudent = studentID;
                        while (loop){
                            System.out.println("Enter Course ID: ");
                            studentID = scanner.next();
                            valid = "";
                            for (int i = 0; i < course.courseArray.size(); i++){
                                if (studentID.equalsIgnoreCase(course.courseArray.get(i).getCourseID())){
                                    valid = "Valid";
                                    break;
                                }
                            }
                            if (!valid.equalsIgnoreCase("Valid")){
                                System.out.println("Invalid Course ID");
                                continue;
                            }
                            String enrolCourse = studentID;
                            while (loop){
                                System.out.println("Semester: ");
                                studentID = scanner.next();
                                valid = "";
                                ArrayList<String> semester = new ArrayList<>(Arrays.asList("2020B","2020C","2021A"));
                                for (String s : semester){
                                    if (!studentID.equalsIgnoreCase(s)){
                                        valid = "Valid";
                                        break;
                                    }
                                }
                                if (!valid.equalsIgnoreCase("Valid")){
                                    System.out.println("Invalid Semester");
                                    continue;
                                }
                                String exist = "";
                                String end = "";
                                for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++){
                                    if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                    enrolCourse.equalsIgnoreCase(StudentEnrolmentManager))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

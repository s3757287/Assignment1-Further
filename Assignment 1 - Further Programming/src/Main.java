import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("Print.csv");
        Student student = new Student();
        Course course = new Course();
        Scanner scanner = new Scanner(System.in);
        StudentEnrolment studentEnrolment = new StudentEnrolment();
        ArrayList<String> semester = new ArrayList<>(Arrays.asList("2020B", "2020C", "2021A"));
        boolean loop;

        try {
            File sourceDefault = new File("default.csv");
            Scanner fileRead = new Scanner(sourceDefault);
            System.out.println("Data: ");
            String info;
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found\n");
        }
        Scanner scanner1 = new Scanner(System.in);
        String quitApp = null;
        while (!Objects.equals(quitApp, "Quit")) {
            System.out.println("""
                    Welcome
                    What would you like to do?
                    ~~~~~~~~~~~~~~~~~~~
                    1) Add Enrolment
                    2) Update Enrolment
                    3) Withdrawal
                    4) Print Data
                    5) Quit""");
            String option = "";
            if (scanner1.hasNext()) {
                option = scanner1.next();
            }
            switch (option) {
                case "1" -> {
                    loop = true;
                    while (loop) {
                        System.out.println("New Enrolment\n" +
                                "Enter Student ID: ");
                        String studentID = scanner.next();
                        String valid = "";
                        for (int i = 0; i < student.studentArray.size(); i++) {
                            if (studentID.equalsIgnoreCase(student.studentArray.get(i).getID())) {
                                System.out.println("Continue~~");
                                valid = "valid";
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("valid")) {
                            System.out.println("Invalid ID");
                            continue;
                        }
                        String enrolStudent = studentID;
                        while (loop) {
                            System.out.println("Enter Course ID: ");
                            studentID = scanner.next();
                            valid = "";
                            for (int i = 0; i < course.courseArray.size(); i++) {
                                if (studentID.equalsIgnoreCase(course.courseArray.get(i).getCourseID())) {
                                    System.out.println("Continue~~");
                                    valid = "Valid";
                                    break;
                                }
                            }
                            if (!valid.equalsIgnoreCase("Valid")) {
                                System.out.println("Invalid Course ID");
                                continue;
                            }
                            String enrolCourse = studentID;
                            while (loop) {
                                System.out.println("Semester: ");
                                studentID = scanner.next();
                                valid = "";
                                for (String s : semester) {
                                    if (!studentID.equalsIgnoreCase(s)) {
                                        System.out.println("Continue~~");
                                        valid = "Valid";
                                        break;
                                    }
                                }
                                if (!valid.equalsIgnoreCase("Valid")) {
                                    System.out.println("Invalid Semester");
                                    continue;
                                }
                                String exist = "";
                                String fin = "";
                                for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                    if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                            enrolCourse.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                            studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                        exist = "exist";
                                    }
                                    if (exist.equalsIgnoreCase("exist")) {
                                        System.out.println("Already enrolled\n" +
                                                "Please choose another Course / Semester");
                                        break;
                                    }
                                }
                                if (!exist.equalsIgnoreCase("exist")) {
                                    StudentEnrolment studentEnrolment1 = new StudentEnrolment(enrolStudent, enrolCourse, studentID);
                                    studentEnrolment.addEnrolment(studentEnrolment1);
                                    fin = "fin";
                                    System.out.println(StudentEnrolmentManager.studentEnrolment.size());
                                }
                                if (!fin.equalsIgnoreCase("fin")) {
                                    continue;
                                }
                                loop = false;
                            }
                        }
                    }
                }
                case "2" -> {
                    loop = true;
                    System.out.println("Updating Enrolment\n" +
                            "~~~~");
                    while (loop) {
                        System.out.println("Enter Student ID: ");
                        String studentID = scanner.next();
                        String valid = "";
                        for (int i = 0; i < student.studentArray.size(); i++) {
                            if (studentID.equalsIgnoreCase(student.studentArray.get(i).getID())) {
                                System.out.println("Continue~~");
                                valid = "Valid";
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("Valid")) {
                            System.out.println("Invalid Id");
                            continue;
                        }
                        String enrolStudent = studentID;
                        while (loop) {
                            System.out.println("Semester");
                            studentID = scanner.next();
                            valid = "";
                            for (String s : semester) {
                                if (!studentID.equalsIgnoreCase(s)) {
                                    System.out.println("Continue~~");
                                    valid = "Valid";
                                    break;
                                }
                            }
                            if (!valid.equalsIgnoreCase("Valid")) {
                                System.out.println("Invalid Semester");
                                continue;
                            }
                            String exist = "";
                            String enrolSem = studentID;
                            ArrayList<String> enrolCourse = new ArrayList<>();
                            for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                        enrolSem.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                    System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                                    exist = "exist";
                                    enrolCourse.add(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                                }
                            }
                            if (!exist.equalsIgnoreCase("exist")) {
                                System.out.println("There's no enrolment of " + enrolStudent + " in " + enrolSem);
                                break;
                            }
                            System.out.println("""
                                    Add enrolment or Withdrawal
                                    1) Add
                                    2) Withdrawal""");
                            String option1 = scanner.next();
                            switch (option1) {
                                case "1":
                                    while (loop) {
                                        System.out.println("Choose course: ");
                                        for (int i = 0; i < course.courseArray.size(); i++) {
                                            System.out.println(course.courseArray.get(i));
                                        }
                                        String courseID = scanner.next();
                                        exist = "";
                                        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                            if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                                    courseID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                                    enrolSem.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                exist = "exist";
                                                break;
                                            }
                                        }
                                        if (exist.equalsIgnoreCase("exist")) {
                                            System.out.println("Already Enrolled\n" +
                                                    "Please choose another Course");
                                            continue;
                                        }
                                        StudentEnrolment studentEnrolment1 = new StudentEnrolment(enrolStudent, courseID, enrolSem);
                                        studentEnrolment.updateAdd(studentEnrolment1);
                                        System.out.println(StudentEnrolmentManager.studentEnrolment.size());
                                        loop = false;
                                        System.out.println("Updated enrolment for " + enrolStudent + " for semester " + enrolSem);
                                    }
                                case "2":
                                    while (loop) {
                                        System.out.println("Choose a course to withdraw");
                                        for (String enrolledCourse : enrolCourse) {
                                            System.out.println(enrolledCourse);
                                        }
                                        String courseID = scanner.next();
                                        String delete = "";
                                        for (String enrolledCourse : enrolCourse) {
                                            if (courseID.equalsIgnoreCase(enrolledCourse)) {
                                                for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                                    if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                                            enrolledCourse.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                                            enrolSem.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                        studentEnrolment.updateDelete(StudentEnrolmentManager.studentEnrolment.get(i));
                                                        System.out.println(StudentEnrolmentManager.studentEnrolment.size());
                                                        delete = "delete";
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (delete.equalsIgnoreCase("delete")) {
                                            System.out.println("Updated enrollment:");
                                            loop = false;
                                        } else {
                                            System.out.println("Cannot find enrolment!");
                                        }
                                    }
                            }
                        }
                    }
                }

                case "3" -> {
                    loop = true;
                    while (loop) {
                        System.out.println("Withdraw from course: \n" +
                                "Enter Student ID: ");
                        String studentID = scanner.next();
                        String valid = "";
                        for (int i = 0; i < student.studentArray.size(); i++) {
                            if (studentID.equalsIgnoreCase(student.studentArray.get(i).getID())) {
                                System.out.println("Continue~~");
                                valid = "valid";
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("valid")) {
                            System.out.println("Invalid ID");
                            continue;
                        }
                        String enrolStudent = studentID;
                        while (loop) {
                            System.out.println("Enter Course ID: ");
                            studentID = scanner.next();
                            valid = "";
                            for (int i = 0; i < course.courseArray.size(); i++) {
                                if (studentID.equalsIgnoreCase(course.courseArray.get(i).getCourseID())) {
                                    System.out.println("Continue~~");
                                    valid = "valid";
                                    break;
                                }
                            }
                            if (!valid.equalsIgnoreCase("valid")) {
                                System.out.println("Invalid Course ID");
                                continue;
                            }
                            String enrolCourse = studentID;
                            while (loop) {
                                System.out.println("Semester: ");
                                studentID = scanner.next();
                                valid = "";
                                for (String s : semester) {
                                    if (!studentID.equalsIgnoreCase(s)) {
                                        System.out.println("Continue~~");
                                        valid = "valid";
                                        break;
                                    }
                                }
                                if (!valid.equalsIgnoreCase("valid")) {
                                    System.out.println("Invalid Semester");
                                    continue;
                                }
                                String delete = "";
                                for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                    if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                            enrolCourse.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                            studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                        studentEnrolment.deleteEnrolment(StudentEnrolmentManager.studentEnrolment.get(i));
                                        delete = "delete";
                                        System.out.println("Withdrew");
                                        break;
                                    }
                                }
                                if (delete.equalsIgnoreCase("delete")) {
                                    loop = false;
                                } else {
                                    System.out.println("Cannot find enrolment");
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                }

                case "4" -> {
                    loop = true;
                    String exitPrint = null;
                    while (!Objects.equals(exitPrint, "Exit")) {
                        System.out.println("""
                                Printing
                                1) All courses of 1 student in 1 semester
                                2) All students of 1 course in 1 semester
                                3) All courses in 1 semester
                                4) All Enrolments
                                5) 1 Enrolment
                                6) Print all
                                7) Exit""");
                        String option1 = scanner.next();
                        switch (option1) {
                            case "1" -> {
                                loop = true;
                                while (loop) {
                                    System.out.println("Printing all course of 1 student in 1 semester\n" +
                                            "Enter student ID: ");
                                    String studentID = scanner.next();
                                    String valid = "";
                                    for (int i = 0; i < student.studentArray.size(); i++) {
                                        if (studentID.equalsIgnoreCase(student.studentArray.get(i).getID())) {
                                            System.out.println("Continue~~");
                                            valid = "valid";
                                            break;
                                        }
                                    }
                                    if (!valid.equalsIgnoreCase("valid")) {
                                        System.out.println("Invalid");
                                        continue;
                                    }
                                    System.out.println("Enter semester: ");
                                    String Semester = scanner1.next();
                                    valid = "";
                                    for (String s : semester) {
                                        if (Semester.equalsIgnoreCase(s)) {
                                            System.out.println("Continue~~");
                                            valid = "valid";
                                            break;
                                        }
                                    }
                                    if (!valid.equalsIgnoreCase("valid")) {
                                        System.out.println("Invalid");
                                        continue;
                                    }
                                    int count = 0;
                                    for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                        if (studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                                Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                            count += 1;
                                        }
                                    }
                                    if (count == 0) {
                                        System.out.println("No course");
                                    } else {
                                        System.out.println("""
                                                Save list to file?
                                                1) Yes
                                                2) No
                                                """);
                                        String option2 = scanner.next();
                                        if (Objects.equals(option2, "1")) {
                                            try {
                                                FileWriter saveFile = new FileWriter(file);

                                                System.out.println("Course(s) of " + studentID + ":");
                                                for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                                    if (studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                                            Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                        System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                                                        saveFile.write(StudentEnrolmentManager.studentEnrolment.get(i).getCourse() + "\n");
                                                    }
                                                }
                                                saveFile.close();
                                            } catch (IOException e) {
                                                System.out.println("Error");
                                                e.printStackTrace();
                                            }
                                        }
                                        if (Objects.equals(option2, "2")) {
                                            System.out.println("Course of " + studentID + ":");
                                            for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                                if (studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                                        Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                    System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                                                }
                                            }
                                        }
                                    }
                                    loop = false;
                                }
                            }
                            case "2" -> {
                                loop = true;
                                while (loop) {
                                    System.out.println("Printing all students of 1 course in 1 semester\n" +
                                            "Enter course ID: ");
                                    String courseID = scanner.next();
                                    String valid = "";
                                    for (int i = 0; i < course.courseArray.size(); i++) {
                                        if (courseID.equalsIgnoreCase(course.courseArray.get(i).getCourseID())) {
                                            System.out.println("Continue~~");
                                            valid = "valid";
                                            break;
                                        }
                                    }
                                    if (!valid.equalsIgnoreCase("valid")) {
                                        System.out.println("Invalid course ID");
                                        continue;
                                    }
                                    System.out.println("Enter semester: ");
                                    String Semester = scanner.next();
                                    valid = "";
                                    for (String s : semester) {
                                        if (Semester.equalsIgnoreCase(s)) {
                                            System.out.println("Continue~~");
                                            valid = "valid";
                                            break;
                                        }
                                    }
                                    if (!valid.equalsIgnoreCase("valid")) {
                                        System.out.println("Invalid Semester");
                                        continue;
                                    }
                                    System.out.println("""
                                            Save list to file?
                                            1) Yes
                                            2) No
                                            """);
                                    String option2 = scanner.next();
                                    if (Objects.equals(option2, "1")) {
                                        try {
                                            FileWriter saveFile = new FileWriter(file);

                                            System.out.println("Students in " + courseID + " : ");
                                            for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                                if (courseID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                                        Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                    System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getStudent());
                                                    saveFile.write(StudentEnrolmentManager.studentEnrolment.get(i).getCourse() + "\n");
                                                }
                                            }
                                            saveFile.close();
                                        } catch (IOException e) {
                                            System.out.println("Error");
                                            e.printStackTrace();
                                        }
                                    }
                                    if (Objects.equals(option2, "2")) {
                                        System.out.println("Students in " + courseID + " : ");
                                        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                            if (courseID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                                    Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getStudent());
                                            }
                                        }
                                    }
                                    loop = false;
                                }
                            }
                            case "3" -> {
                                loop = true;
                                while (loop) {
                                    System.out.println("Printing all courses in 1 semester\n" +
                                            "Enter semester: ");
                                    String courseSem = scanner.next();
                                    String valid = "";
                                    for (String s : semester) {
                                        if (courseSem.equalsIgnoreCase(s)) {
                                            System.out.println("Continue~~");
                                            valid = "valid";
                                            break;
                                        }
                                    }
                                    if (!valid.equalsIgnoreCase("valid")) {
                                        System.out.println("Invalid semester");
                                        continue;
                                    }
                                    System.out.println("""
                                            Save list to file?
                                            1) Yes
                                            2) No
                                            """);
                                    String option2 = scanner.next();
                                    if (Objects.equals(option2, "1")) {
                                        try {
                                            FileWriter saveFile = new FileWriter(file);

                                            System.out.println("Courses in Semester: " + courseSem);
                                            for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                                if (courseSem.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                    System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                                                    saveFile.write(StudentEnrolmentManager.studentEnrolment.get(i).getCourse() + "\n");
                                                }
                                            }
                                            saveFile.close();
                                        } catch (IOException e) {
                                            System.out.println("Error");
                                            e.printStackTrace();
                                        }
                                    }
                                    if (Objects.equals(option2, "2")) {
                                        System.out.println("Courses in Semester: " + courseSem);
                                        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                            if (courseSem.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                                            }
                                        }
                                    }
                                    loop = false;
                                }
                            }
                            case "4" -> {
                                System.out.println("Printing all student enrolment\n");
                                studentEnrolment.getAll();
                                System.out.println("""
                                        Save list to file?
                                        1) Yes
                                        2) No
                                        """);
                                String option2 = scanner.next();
                                if (Objects.equals(option2, "1")) {
                                    try {
                                        FileWriter saveFile = new FileWriter(file);

                                        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                            saveFile.write(StudentEnrolmentManager.studentEnrolment.get(i).toString() + "\n");
                                        }

                                        saveFile.close();
                                    } catch (IOException e) {
                                        System.out.println("Error");
                                        e.printStackTrace();
                                    }
                                }

                            }
                            case "5" -> {
                                loop = true;
                                while (loop) {
                                    System.out.println("Printing 1 enrolment\n" +
                                            "Enter Student ID: ");
                                    String studentID = scanner.next();
                                    String valid = "";
                                    for (int i = 0; i < student.studentArray.size(); i++) {
                                        if (studentID.equalsIgnoreCase(student.studentArray.get(i).getID())) {
                                            System.out.println("Continue~~");
                                            valid = "valid";
                                            break;
                                        }
                                    }
                                    if (!valid.equalsIgnoreCase("valid")) {
                                        System.out.println("Invalid ID");
                                        continue;
                                    }
                                    String enrolStudent = studentID;
                                    while (loop) {
                                        System.out.println("Enter Course ID: ");
                                        studentID = scanner.next();
                                        valid = "";
                                        for (int i = 0; i < course.courseArray.size(); i++) {
                                            if (studentID.equalsIgnoreCase(course.courseArray.get(i).getCourseID())) {
                                                System.out.println("Continue~~");
                                                valid = "valid";
                                                break;
                                            }
                                        }
                                        if (!valid.equalsIgnoreCase("valid")) {
                                            System.out.println("Invalid ID");
                                            continue;
                                        }
                                        String enrolCourse = studentID;
                                        while (loop) {
                                            System.out.println("Enter Semester: ");
                                            studentID = scanner.next();
                                            valid = "";
                                            for (String s : semester) {
                                                if (!studentID.equalsIgnoreCase(s)) {
                                                    System.out.println("Continue~~");
                                                    valid = "valid";
                                                    break;
                                                }
                                            }
                                            if (!valid.equalsIgnoreCase("valid")) {
                                                System.out.println("Invalid");
                                                continue;
                                            }
                                            for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                                if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                                        enrolCourse.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                                        studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                    studentEnrolment.getOne(i);
                                                    loop = false;
                                                    break;
                                                }
                                            }
                                        }
                                        loop = false;
                                    }
                                }
                            }
                            case "6" -> {
                                System.out.println("""
                                        Print All Info
                                        1) All Students
                                        2) All Courses""");
                                String option2 = scanner.next();
                                switch (option2) {
                                    case "1" -> student.getAllStudent();
                                    case "2" -> course.getAllCourse();
                                }
                            }
                            case "7" -> exitPrint = "Exit";
                        }
                    }
                }
                case "5" -> quitApp = "Quit";
            }
        }
    }
}


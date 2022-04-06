import java.util.ArrayList;

public class Student {
    private String ID;
    private String name;
    private String birthdate;

    ArrayList<Student> studentArray = new ArrayList<>();

    public Student(){}

    public Student(String ID, String name, String birthdate){
        this.ID = ID;
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getID(){
        return ID;
    }
    public void setID(){
        this.ID = ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirthdate(String birthdate){
        this.birthdate = birthdate;
    }

    @Override
    public String toString(){
        return "Student ID: " + ID + " " +
                "| Name: " + name + " " +
                "| Birthdate: " + birthdate;
    }
}

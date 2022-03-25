import java.util.Date;

public class Student {
    private int ID;
    private String name;
    private Date birthdate;

    public Student(int ID, String name, Date birthdate) {
        this.ID = ID;
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}

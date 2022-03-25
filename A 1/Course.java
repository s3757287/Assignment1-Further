public class Course {
    private int ID;
    private String name;
    private int credit;

    public Course(int ID, String name, int credit) {
        this.ID = ID;
        this.name = name;
        this.credit = credit;
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}

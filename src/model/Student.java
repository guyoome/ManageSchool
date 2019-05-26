package model;

public class Student extends People {
    public Student() {
        super();
    }

    public Student(String name, String firstname) {
        super(name, firstname);
    }

    public Student(String name, String firstname, int id) {
        super(name, firstname, id);
    }
}

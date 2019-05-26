package model;

public abstract class People {
    protected String name;
    protected String firstname;
    protected int id;

    public People() {
        this.name = null;
        this.firstname = null;
        this.id = -1;
    }

    public People(String name, String firstname) {
        this.name = name;
        this.firstname = firstname;
        this.id = -1;
    }

    public People(String name, String firstname, int id) {
        this.name = name;
        this.firstname = firstname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setId(int id) {
        this.id = id;
    }
}

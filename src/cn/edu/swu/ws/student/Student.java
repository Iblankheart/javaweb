package cn.edu.swu.ws.student;

public class Student {

    private String id;
    private String name;

    public Student() {

    }

    public Student(String id, String name) {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return String.format("ID: %s, Name: %s", this.getId(), this.getName());
    }
}

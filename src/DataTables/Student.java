package DataTables;

import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private String surname;
    private String age;
    private static ArrayList<Student> studentTable = new ArrayList<>();
    private static ArrayList<Student> studentTableAnonymised = new ArrayList<>();
    public Student(String id, String name, String surname, String age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}

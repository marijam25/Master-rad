package DataTables;

import java.util.ArrayList;

public class Student {
    private String name;
    private String surname;
    private int age;
    private long JMBG;
    private String gender;
    private String city;
    private double gpa;
    private String indexNumber;
    private int studyYear;
    private String module;
    private long phone;

    private static ArrayList<Student> studentTable = new ArrayList<>();
    private static ArrayList<Student> studentTableAnonymised = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String surname, int age, long JMBG, String gender, String city, double gpa, String indexNumber, int studyYear, String module, long phone) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.JMBG = JMBG;
        this.gender = gender;
        this.city = city;
        this.gpa = gpa;
        this.indexNumber = indexNumber;
        this.studyYear = studyYear;
        this.module = module;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public long getJMBG() {
        return JMBG;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public double getGpa() {
        return gpa;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public String getModule() {
        return module;
    }

    public long getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJMBG(long JMBG) {
        this.JMBG = JMBG;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}

package DataTables;

import java.util.ArrayList;

public class Student {
    private String name;
    private String surname;
    private String age;
    private String JMBG;
    private String gender;
    private String city;
    private String gpa;
    private String indexNumber;
    private String studyYear;
    private String module;
    private String phone;

    private static ArrayList<Student> studentTable = new ArrayList<>();
    private static ArrayList<Student> studentTableAnonymised = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String surname, String age, String JMBG, String gender, String city, String gpa, String indexNumber, String studyYear, String module, String phone) {
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

    public String getAge() {
        return age;
    }

    public String getJMBG() {
        return JMBG;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String getGpa() {
        return gpa;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getStudyYear() {
        return studyYear;
    }

    public String getModule() {
        return module;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setStudyYear(String studyYear) {
        this.studyYear = studyYear;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                ", JMBG='" + JMBG + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", gpa='" + gpa + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                ", studyYear='" + studyYear + '\'' +
                ", module='" + module + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

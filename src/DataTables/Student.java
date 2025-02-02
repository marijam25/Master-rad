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

    public String getAttributeValue(String attributeName){
        switch(attributeName){
            case "Name":
                return name;
            case "Surname":
                return surname;
            case "Age":
                return age;
            case "JMBG":
                return JMBG;
            case "Gender":
                return gender;
            case "City":
                return city;
            case "Gpa":
                return gpa;
            case "IndexNumber":
                return indexNumber;
            case "StudyYear":
                return studyYear;
            case "Module":
                return module;
            case "Phone":
                return phone;
            default:
                throw new IllegalArgumentException(attributeName);
        }
    }

    public ArrayList<String> getQuasiIdentifierValues(ArrayList<String> quasiIdentifierNames){
        ArrayList<String> quasiIdentifierValues = new ArrayList<>();
        for(String qi : quasiIdentifierNames){
            quasiIdentifierValues.add(this.getAttributeValue(qi));
        }
        return quasiIdentifierValues;
    }

    public void setAttributeValue(String attribute, String newValue) {
        switch(attribute) {
            case "Name":
                this.name = newValue;
                break;
            case "Surname":
                this.surname = newValue;
                break;
            case "Age":
                this.age = newValue;
                break;
            case "JMBG":
                this.JMBG = newValue;
                break;
            case "Gender":
                this.gender = newValue;
                break;
            case "City":
                this.city = newValue;
                break;
            case "Gpa":
                this.gpa = newValue;
                break;
            case "IndexNumber":
                this.indexNumber = newValue;
                break;
            case "StudyYear":
                this.studyYear = newValue;
                break;
            case "Module":
                this.module = newValue;
                break;
            case "Phone":
                this.phone = newValue;
                break;
            default:
                throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }
    }

}

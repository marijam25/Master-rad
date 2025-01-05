package DataTables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RandomStudentGenerator {

    public static final String directory = System.getProperty("user.dir") + File.separator + "data" + File.separator + "values" + File.separator;
    public static final String nameTableFile = directory + "Name.csv";
    public static final String surnameTableFile = directory + "Surname.csv";
    public static final String ageTableFile = directory + "Age.csv";
    public static final String cityTableFile = directory + "City.csv";
    public static final String gpaTableFile = directory + "Gpa.csv";
    public static final String genderTableFile = directory + "Gender.csv";
    public static final String moduleTableFile = directory + "Module.csv";
    public static final String indexTableFile = directory + "IndexNumber.csv";
    public static final String studyYearTableFile = directory + "StudyYear.csv";
    public static final String phoneNumberTableFile = directory + "Phone.csv";
    public static final String jmbgTableFile = directory + "JMBG.csv";

    private ArrayList<String> names;
    private ArrayList<String> surnames;
    private ArrayList<String> age;
    private ArrayList<String> jmbg;
    private ArrayList<String> gender;
    private ArrayList<String> city;
    private ArrayList<String> gpa;
    private ArrayList<String> indexNumber;
    private ArrayList<String> studyYear;
    private ArrayList<String> module;
    private ArrayList<String> phone;

    Random random = new Random();

    public RandomStudentGenerator() {
        names = readArrayFromCsv(nameTableFile);
        surnames = readArrayFromCsv(surnameTableFile);
        age = readArrayFromCsv(ageTableFile);
        jmbg = readArrayFromCsv(jmbgTableFile);
        gender = readArrayFromCsv(genderTableFile);
        city = readArrayFromCsv(cityTableFile);
        gpa = readArrayFromCsv(gpaTableFile);
        indexNumber = readArrayFromCsv(indexTableFile);
        studyYear = readArrayFromCsv(studyYearTableFile);
        module = readArrayFromCsv(moduleTableFile);
        phone = readArrayFromCsv(phoneNumberTableFile);
    }

    public Student generateRandomStudent(){
        Student s = new Student(generateRandomValue(names),generateRandomValue(surnames),generateRandomValue(age),
                generateRandomValue(jmbg),generateRandomValue(gender),generateRandomValue(city),generateRandomValue(gpa),
                generateRandomValue(indexNumber),generateRandomValue(studyYear),generateRandomValue(module),
                generateRandomValue(phone));
        return s;
    }

    private String generateRandomValue(ArrayList<String> list){
        return list.get(random.nextInt(list.size()));
    }

    private ArrayList<String> readArrayFromCsv(String filename) {
        ArrayList<String> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] fields = line.split(",");
                if (fields.length > 0) {
                    values.add(fields[0].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error while reading the file: " + e.getMessage());
        }

        if (values.isEmpty()) {
            throw new IllegalArgumentException("The file is empty.");
        }
        return values;
    }

}

package controller;

import DataTables.Student;
import db.DBBroker;

import java.util.ArrayList;

public class Controller {
    private static Controller instance;
    protected DBBroker dbBroker;

    private Controller() {
        dbBroker = new DBBroker();
        try {
            dbBroker.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }


    public void createTable(String tableName) {
        try {
            dbBroker.createTable(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addStudent(String tableName, Student s) {
        try {
            dbBroker.insert(tableName,s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getAll(String tableName){
        ArrayList<Student> list = new ArrayList<>();
        try {
            list = dbBroker.getAllStudents(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Student> removePrivateData(ArrayList<Student> studentList){

        for (Student student : studentList) {
            student.setName("");
            student.setSurname("");
        }
        return studentList;
    }
}

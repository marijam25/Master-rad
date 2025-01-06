package GUI;

import DataTables.RandomStudentGenerator;
import DataTables.Student;
import controller.Controller;
import db.DBBroker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TableGeneratorForm {
    JPanel TopPanel;
    private JTextField txtTableName;
    private JTextField txtRowCount;
    private JButton jbtnGenerate;
    private JButton jbtnBack;
    ArrayList<Student> studentList;


    public TableGeneratorForm() {
        studentList = new ArrayList<>();
        jbtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuForm.changeView(Main.frame);
            }
        });
        jbtnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableName = txtTableName.getText();
                Controller.getInstance().createTable(tableName);
                int rowCount = Integer.parseInt(txtRowCount.getText());
                for(int i=0;i<rowCount;i++){
                    Student s = new RandomStudentGenerator().generateRandomStudent();
                    studentList.add(s);
                    Controller.getInstance().addStudent(tableName, s);
                }
                JOptionPane.showMessageDialog(TopPanel,"Vrednosti su generisane");
            }
        });
        }


    public static void changeView(JFrame frame){
        frame.setContentPane(new TableGeneratorForm().TopPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

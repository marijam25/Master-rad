package GUI;

import DataTables.Student;
import DataTables.StudentTableModel;
import Datafly.Anonymize;
import DomainGeneralizationHierarchy.DGH;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class AnonymizeTableForm {
    private JPanel TopPanel;
    private JButton jbuttonAnonymize;
    private JButton jbuttonBack;
    private JTextField txtTableName;
    private JTextField txtParameter;
    private JPanel listPanel;
    private JList list1;

    public AnonymizeTableForm(){
        list1 = new JList(StudentTableModel.columnNames);
        listPanel.setLayout(new BorderLayout());
        listPanel.add(list1);


        jbuttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuForm.changeView(Main.frame);
            }
        });
        jbuttonAnonymize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableName = txtTableName.getText();
                int k = Integer.parseInt(txtParameter.getText());
                ArrayList<String> quasiIdentifiers = new ArrayList<>(list1.getSelectedValuesList());

                ArrayList<Student> studentList = Controller.getInstance().getAll(tableName);
                studentList = Controller.getInstance().removePrivateData(studentList);

                HashMap<String, DGH> dghMap = new HashMap<>();
                for(String element:quasiIdentifiers){
                    dghMap.put(element, Main.dgh.get(element));
                }

                Anonymize.dataflyAnonymize(k,quasiIdentifiers, studentList,dghMap);
                JOptionPane.showMessageDialog(Main.frame, "Success!");

                String table = tableName+"Anon";
                Controller.getInstance().createTable(table);
                for(Student s: studentList){
                    Controller.getInstance().addStudent(table,s);
                }

                new Table(table);

            }
        });
    }

    public static void changeView(JFrame frame){
        frame.setContentPane(new AnonymizeTableForm().TopPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

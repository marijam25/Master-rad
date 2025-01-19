package GUI;

import DataTables.Student;
import DataTables.StudentTableModel;
import DomainGeneralizationHierarchy.DGH;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
                int[] arr =  list1.getSelectedIndices();

                ArrayList<Student> studentList = Controller.getInstance().getAll(tableName);
                studentList = Controller.getInstance().removePrivateData(studentList);

                ArrayList<Integer> attList = new ArrayList<>();
                ArrayList<DGH> dgh = new ArrayList<>();
                for(int j:arr){
                    attList.add(j);
                    dgh.add(Main.dgh.get(j));
                }

                //continue here


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

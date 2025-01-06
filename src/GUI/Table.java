package GUI;

import DataTables.Student;
import DataTables.StudentTableModel;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Table extends JFrame {
    public Table(String tableName) {
        setTitle("Prikaz Studenata");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        ArrayList<Student> list = Controller.getInstance().getAll(tableName);

        StudentTableModel tableModel = new StudentTableModel(list);

        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }
}

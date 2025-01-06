package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowTableForm {
    private JPanel TopPanel;
    private JTextField txtTableName;
    private JButton jbtnShowTable;
    private JButton jbtnBack;

    public ShowTableForm() {
        jbtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuForm.changeView(Main.frame);
            }
        });
        jbtnShowTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableName = txtTableName.getText();
                new Table(tableName);
            }
        });
    }

    public static void changeView(JFrame frame){
        frame.setContentPane(new ShowTableForm().TopPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm {
    private JButton jbuttonGenerate;
    private JButton jbuttonShowTable;
    JPanel TopPanel;

    public MenuForm() {
        jbuttonGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableGeneratorForm.changeView(Main.frame);
            }
        });
        jbuttonShowTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowTableForm.changeView(Main.frame);
            }
        });
    }

    public static void changeView(JFrame frame){
        frame.setContentPane(new MenuForm().TopPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

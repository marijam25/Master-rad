package GUI;

import javax.swing.*;

public class Main {
    public static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Menu");
        frame.setContentPane(new MenuForm().TopPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
    }
}

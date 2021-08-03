package academy.Bentilzone;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Handlers ui = new Handlers();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame("Day 5 Java Swing UI - MOUSE HANDLERS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

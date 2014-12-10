package com.pestov.swing.port.chapter2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pestovaleksey on 04/12/14.
 */
public class InnerClassEvents extends JFrame {

    public static void main(String[] args) {
        new InnerClassEvents();
    }

    public InnerClassEvents() {
        super("InnerClassEvents");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //getContentPane().setLayout(new FlowLayout());
        getContentPane().add(text = new JTextField(10));
        getContentPane().add(button = new JButton("Press me"), "South");

        button.addActionListener(new ButtonL());

        pack();
        setVisible(true);
    }

    private JTextField text;
    private JButton button;

    class ButtonL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(text.getText());
        }
    }
}

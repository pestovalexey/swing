package com.pestov.swing.port.chapter2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by pestovaleksey on 05/12/14.
 */
public class InvokeLaterEvents extends JFrame {

    public InvokeLaterEvents() {
        super("InvokeLaterEvents");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        button = new JButton("Выполнить сложную работу");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ComplexJobThread().start();
                button.setText("Подождите...");
            }
        });

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JTextField(20));
        getContentPane().add(button);
        setSize(300, 200);
        setVisible(true);
    }

    public JButton button;

    class ComplexJobThread extends Thread {
        @Override
        public void run() {
            try {
                sleep(3000);
                EventQueue.invokeAndWait(new Runnable() {
                    @Override
                    public void run() {
                        button.setText("Работа завершена");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new InvokeLaterEvents();
    }
}

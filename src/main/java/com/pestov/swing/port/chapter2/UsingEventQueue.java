package com.pestov.swing.port.chapter2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by pestovaleksey on 05/12/14.
 */
public class UsingEventQueue extends JFrame {

    public static void main(String[] args) {
        new UsingEventQueue();
    }

    public UsingEventQueue() {
        super("UsingEventQueue");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button = new JButton("Close");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getToolkit().getSystemEventQueue().postEvent(new WindowEvent(UsingEventQueue.this,
                        WindowEvent.WINDOW_CLOSING));
            }
        });

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(button);

        setSize(400, 300);
        setVisible(true);
    }
}

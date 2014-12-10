package com.pestov.swing.port.chapter2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by pestovaleksey on 03/12/14.
 */
public class LowLevelEvents extends JFrame {

    public static void main(String[] args) {
        new LowLevelEvents();
    }

    public LowLevelEvents() {
        super("LowLevelEvents");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(new JScrollPane(out = new JTextArea()));
        MyButton button = new MyButton("Источник событий");
        getContentPane().add(button, "South");

        getToolkit().getSystemEventQueue().push(new InterceptorEventQueue());
        getToolkit().getSystemEventQueue().invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });


        MouseL mouseL = new MouseL();
        button.addMouseListener(mouseL);

        setSize(400, 300);
        setVisible(true);
    }

    private JTextArea out;

    class MouseL extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            out.append(e.toString() + "\n");
        }
    }

    class MyButton extends JButton {

        public MyButton() {
            super();
        }

        public MyButton(String label) {
            super(label);
        }

        public void processMouseEvent(MouseEvent e) {
            if (e.getID() == MouseEvent.MOUSE_CLICKED) {
                if (e.getClickCount() == 2) {
                    return;
                } else {
                    super.processMouseEvent(e);
                }
            } else {
                super.processMouseEvent(e);
            }
        }
    }
}


class InterceptorEventQueue extends EventQueue {

    @Override
    protected void dispatchEvent(AWTEvent event) {

        System.out.println(event.toString());
        super.dispatchEvent(event);
    }
}

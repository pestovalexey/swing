package com.pestov.swing.port.chapter2;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by pestovaleksey on 03/12/14.
 */
public class FirstEvents extends JFrame {

    public FirstEvents() {
        super("First Events");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new KeyL());
        addWindowListener(new WindowL());
        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FirstEvents();
    }
}

class KeyL extends KeyAdapter {

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e);
    }
}

class WindowL implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println(e);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println(e);
    }
}

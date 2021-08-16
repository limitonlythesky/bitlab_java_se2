package Multithreading.Task2;

import Module2.GUI.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Window");
        setLayout(null);

        JLabel label = new JLabel("#");
        label.setSize(30, 30);
        label.setLocation(235, 100);
        add(label);

        JButton button = new JButton("FIRE");
        button.setSize(100, 50);
        button.setLocation(225, 200);
        add(button);

        button.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyThread thread = new MyThread();
                try {
                    for (int i = 0; i < 470; i += 30) {
                        label.setSize(30, 30);
                        label.setLocation(500 + (int) Math.random() * 500, 500 + (int)Math.random() * 500);
                        add(label);
                        Thread.sleep(100);
                    }
                } catch (Exception interruptedException) {
                    interruptedException.printStackTrace( );
                }
            }
        });
    }
}

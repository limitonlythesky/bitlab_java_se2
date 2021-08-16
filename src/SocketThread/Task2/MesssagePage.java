package SocketThread.Task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MesssagePage extends JPanel {
    private MainFrame parent;

    public MesssagePage(MainFrame parent){
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);

        JTextField textField = new JTextField();
        textField.setSize(200, 200);
        textField.setLocation(150, 150);
        add(textField);

        JButton button = new JButton("SEND");
        button.setSize(100, 30);
        button.setLocation(200, 400);
        add(button);

        button.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(parent.getSocket().getOutputStream());
                    String message = textField.getText();
                    outputStream.writeObject(message);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}

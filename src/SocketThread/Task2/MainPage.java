package SocketThread.Task2;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JPanel {
    public MainPage(MainFrame parent){
        setSize(500, 500);
        setLayout(null);

        JLabel ip = new JLabel("IP: ");
        ip.setSize(50, 30);
        ip.setLocation(100, 100);
        add(ip);

        JTextField ipText = new JTextField(  );
        ipText.setSize(100, 30);
        ipText.setLocation(200, 100);
        add(ipText);

        JLabel port = new JLabel("Port: ");
        ip.setSize(50, 30);
        ip.setLocation(100, 150);
        add(ip);

        JTextField portText = new JTextField();
        portText.setSize(100, 30);
        portText.setLocation(200, 150);
        add(portText);

        JButton connect = new JButton("CONNECT");
        connect.setSize(100, 30);
        connect.setLocation(200, 250);
        add(connect);

        connect.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMainPage().setVisible(false);
                parent.getMesssagePage().setVisible(true);
            }
        });
    }
}

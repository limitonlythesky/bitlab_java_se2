package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MainMenu extends JPanel {
    private MainFrame parent;

    public MainMenu(MainFrame parent){
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);

        JButton button1 = new JButton("ADD STUDENT");
        button1.setSize(200, 30);
        button1.setLocation(150, 100);
        add(button1);

        button1.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMenu().setVisible(false);
                parent.getAddPage().setVisible(true);
            }
        });

        JButton button2 = new JButton("LIST STUDENT");
        button2.setSize(200, 30);
        button2.setLocation(150, 150);
        add(button2);

        button2.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList <Student> students = new ArrayList<>();
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(parent.getSocket().getInputStream());
                    ObjectOutputStream outputStream = new ObjectOutputStream(parent.getSocket().getOutputStream());

                    PackageData packageData = new PackageData("LIST_STUDENTS");
                    outputStream.writeObject(packageData);
                    students = (ArrayList<Student>) inputStream.readObject();
                } catch (Exception exception) {
                    exception.printStackTrace( );
                }
                parent.getListPage().generateTable(students);
                parent.getMenu().setVisible(false);
                parent.getListPage().setVisible(true);
            }
        });

        JButton button3 = new JButton("EXIT");
        button3.setSize(200, 30);
        button3.setLocation(150, 200);
        add(button3);

        button3.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

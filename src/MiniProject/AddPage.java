package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AddPage extends JPanel {
    private MainFrame parent;

    public AddPage(MainFrame parent){
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);

        JLabel name = new JLabel("NAME: ");
        name.setSize(70, 30);
        name.setLocation(100, 100);
        add(name);

        JTextField nameText = new JTextField("");
        nameText.setSize(200, 30);
        nameText.setLocation(200, 100);
        add(nameText);

        JLabel surname = new JLabel("SURNAME: ");
        surname.setSize(70, 30);
        surname.setLocation(100, 150);
        add(surname);

        JTextField surnameText = new JTextField("");
        surnameText.setSize(200, 30);
        surnameText.setLocation(200, 150);
        add(surnameText);

        JLabel age = new JLabel("AGE: ");
        age.setSize(70, 30);
        age.setLocation(100, 200);
        add(age);

        JTextField ageText = new JTextField("");
        ageText.setSize(200, 30);
        ageText.setLocation(200, 200);
        add(ageText);

        JButton button1 = new JButton("ADD");
        button1.setSize(100, 30);
        button1.setLocation(100, 250);
        add(button1);

        button1.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket socket = new Socket( "localhost", 3160);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                    Student student = new Student(nameText.getText(), surnameText.getText(), Integer.parseInt(ageText.getText()));
                    PackageData packageData = new PackageData("ADD_STUDENT", student);
                    outputStream.writeObject(packageData);
                    outputStream.reset();
                } catch (Exception Exception) {
                    Exception.printStackTrace( );
                }
                parent.getAddPage().setVisible(false);
                parent.getMenu().setVisible(true);
            }
        });

        JButton button2 = new JButton("BACK");
        button2.setSize(100, 30);
        button2.setLocation(300, 250);
        add(button2);

        button2.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAddPage().setVisible(false);
                parent.getMenu().setVisible(true);
            }
        });
    }
}

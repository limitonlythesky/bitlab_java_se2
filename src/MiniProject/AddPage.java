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
        name.setSize(50, 30);
        name.setLocation(100, 100);
        add(name);

        JTextField nameText = new JTextField("");
        nameText.setSize(100, 30);
        nameText.setLocation(250, 100);
        add(nameText);

        JLabel surname = new JLabel("SURNAME: ");
        surname.setSize(50, 30);
        surname.setLocation(100, 150);
        add(surname);

        JTextField surnameText = new JTextField("");
        surnameText.setSize(100, 30);
        surnameText.setLocation(250, 150);
        add(surnameText);

        JLabel age = new JLabel("AGE: ");
        age.setSize(50, 30);
        age.setLocation(100, 200);
        add(age);

        JTextField ageText = new JTextField("");
        ageText.setSize(100, 30);
        ageText.setLocation(250, 200);
        add(ageText);

        JButton button1 = new JButton("ADD");
        button1.setSize(100, 30);
        button1.setLocation(100, 250);
        add(button1);

        button1.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(parent.getSocket().getOutputStream());

                    Student student = new Student(nameText.getText(), surnameText.getText(), Integer.parseInt(ageText.getText()));
                    PackageData packageData = new PackageData("ADD_STUDENT", student);
                    outputStream.writeObject(packageData);
                } catch (IOException ioException) {
                    ioException.printStackTrace( );
                }
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

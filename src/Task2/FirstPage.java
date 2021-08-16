package Task2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JPanel {
    private MainFrame parent;
    private String []faculties = {"IT", "Economics", "Logistics", "Mathematics", "Engeeniring"};
    private JButton addition;
    private JButton back;

    public FirstPage(MainFrame parent){

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        JLabel name = new JLabel( "NAME:");
        name.setSize(70, 30);
        name.setLocation(50, 100);
        add(name);

        JTextArea nameText = new JTextArea();
        nameText.setSize(300, 30);
        nameText.setLocation(150, 100);
        add(nameText);

        JLabel surname = new JLabel("SURNAME:");
        surname.setSize(70, 30);
        surname.setLocation(50, 150);
        add(surname);

        JTextArea surnameText = new JTextArea();
        surnameText.setSize(300,30);
        surnameText.setLocation(150, 150);
        add(surnameText);

        JLabel faculty = new JLabel("FACULTY:");
        faculty.setSize(70, 30);
        faculty.setLocation(50, 200);
        add(faculty);

        JComboBox facultyChoice = new JComboBox(faculties);
        facultyChoice.setSize(300, 30);
        facultyChoice.setLocation(150, 200);
        add(facultyChoice);

        JLabel group = new JLabel("GROUP:");
        group.setSize(70, 30);
        group.setLocation(50, 250);
        add(group);

        JTextArea groupText = new JTextArea();
        groupText.setSize(300, 30);
        groupText.setLocation(150, 250);
        add(groupText);

        addition = new JButton("ADD");
        addition.setSize(130, 30);
        addition.setLocation(100, 350);
        add(addition);

        addition.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.addStudent(new Student(101 + parent.getSizeOfStudent(), nameText.getText(), surnameText.getText(), (String)facultyChoice.getSelectedItem(), groupText.getText()));
                parent.getFirstPage().setVisible(false);
                parent.getMainMenu().setVisible(true);
                nameText.setText("");
                surnameText.setText("");
                facultyChoice.setSelectedIndex(0);
                groupText.setText("");
            }
        });

        back = new JButton("BACK");
        back.setSize(130, 30);
        back.setLocation(270, 350);
        add(back);

        back.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getFirstPage().setVisible(false);
                parent.getMainMenu().setVisible(true);
            }
        });

    }
}

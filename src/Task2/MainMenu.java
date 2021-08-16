package Task2;

import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JPanel{
    private MainFrame parent;
    private JButton firstPage;
    private JButton secondPage;
    private JButton exit;

    public MainMenu(MainFrame parent){
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);

        firstPage = new JButton("ADD STUDENT");
        firstPage.setSize(300, 30);
        firstPage.setLocation(100, 100);

        firstPage.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMainMenu().setVisible(false);
                parent.getFirstPage().setVisible(true);
            }
        });

        add(firstPage);

        secondPage = new JButton("LIST STUDENTS");
        secondPage.setSize(300, 30);
        secondPage.setLocation(100, 150);
        add(secondPage);

        secondPage.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getSecondPage().generateTable(parent.getStudents());
                parent.getMainMenu().setVisible(false);
                parent.getSecondPage().setVisible(true);
            }
        });

        exit = new JButton("EXIT");
        exit.setSize(300, 30);
        exit.setLocation(100, 200);
        add(exit);

        exit.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

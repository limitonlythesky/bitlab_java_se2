package Module2.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private MainFrame parent;

    public MainMenu(MainFrame parent){

        this.parent = parent;
        setSize(500, 500);
        setLayout(null);

        JButton button = new JButton("Go to the next page ->");
        button.setSize(300, 30);
        button.setLocation(100, 100);
        add(button);

        button.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMenu().setVisible(false);
                parent.getPage().setVisible(true);
            }
        });

        JButton button1 = new JButton("List of Products");
        button1.setSize(300, 30);
        button1.setLocation(100, 150);
        add(button1);

        button1.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getPageList().generateTable(parent.getProducts());
                parent.getPageList().setVisible(true);
                parent.getMenu().setVisible(false);
            }
        });

        JButton exit = new JButton("EXIT");
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

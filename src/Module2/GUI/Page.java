package Module2.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page extends JPanel {
    private MainFrame parent;

    public Page(MainFrame parent){
        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Welcome");
        label.setSize(300, 80);
        label.setLocation(100, 100);
        add(label);

        JButton back = new JButton("BACK");
        back.setSize(300, 30);
        back.setLocation(100, 300);
        add(back);

        back.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getPage().setVisible(false);
                parent.getMenu().setVisible(true);
            }
        });
    }
}

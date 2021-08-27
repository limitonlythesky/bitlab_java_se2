package MiniProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ListPage extends JPanel {
    private MainFrame parent;
    private JTable table;
    private String []header = {"Id", "Name", "Surname", "Age"};
    public ListPage(MainFrame parent){
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);

        table = new JTable();
        table.setFont(new Font("Colibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(500, 400);
        scrollPane.setLocation(0, 0);
        add(scrollPane);

        JButton button = new JButton("BACK");
        button.setSize(100, 30);
        button.setLocation(200, 420);
        add(button);

        button.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getListPage().setVisible(false);
                parent.getMenu().setVisible(true);
            }
        });
    }

    public void generateTable(ArrayList <Student> list){
        Object data[][] = new Object[list.size()][4];
        for(int i = 0; i < list.size(); i++){
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getName();
            data[i][2] = list.get(i).getSurname();
            data[i][3] = list.get(i).getAge();
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }

}

package Task2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondPage extends JPanel {
    private MainFrame parent;

    private JTable list;
    private String []header = {"ID", "NAME", "SURNAME", "FACULTY", "GROUP"};
    public SecondPage(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        JLabel label = new JLabel("LIST OF STUDENTS");
        label.setSize(300, 30);
        label.setLocation(100, 100);
        add(label);

        list = new JTable();
        list.setFont(new Font("Calibri", Font.PLAIN, 12));
        list.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setSize(300, 200);
        scrollPane.setLocation(100, 200);
        add(scrollPane);

        JButton back = new JButton("BACK");
        back.setSize(300, 30);
        back.setLocation(100, 420);
        add(back);

        back.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getSecondPage().setVisible(false);
                parent.getMainMenu().setVisible(true);
            }
        });
    }

    public void generateTable(Student[] students){
        try {
            Object data[][] = new Object[parent.getSizeOfStudent( )][5];

            for (int i = 0; i < parent.getSizeOfStudent( ); i++) {
                data[i][0] = students[i].getId( );
                data[i][1] = students[i].getName( );
                data[i][2] = students[i].getSurname( );
                data[i][3] = students[i].getFaculty( );
                data[i][4] = students[i].getGroup( );
            }
            DefaultTableModel model = new DefaultTableModel(data, header);
            list.setModel(model);
        }catch(Exception e){
            Object data[][] = new Object[5][5];
            DefaultTableModel model = new DefaultTableModel(data, header);
            list.setModel(model);
        }
    }
}

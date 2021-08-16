package Module2.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageList extends JPanel {
    private MainFrame parent;
    private JTable table;
    private String[] header = {"Name", "Cost", "Count", "Total"};

    public PageList(MainFrame parent){
        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(300, 200);
        scrollPane.setLocation(100, 100);
        add(scrollPane);

        JButton back = new JButton("BACK");
        back.setSize(300, 30);
        back.setLocation(100, 400);
        add(back);

        back.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getPageList().setVisible(false);
                parent.getMenu().setVisible(true);
            }
        });
    }

    public void generateTable(Food[] products){
        Object data[][] = new Object[products.length][4];

        for(int i = 0; i < products.length; i++){
            data[i][0] = products[i].getName();
            data[i][1] = products[i].getCost();
            data[i][2] = products[i].getCount();
            data[i][3] = products[i].getCount() * products[i].getCost();
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
}
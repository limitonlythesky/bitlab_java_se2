package MiniProject;

import javax.swing.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private MainMenu menu;
    private AddPage addPage;
    private ListPage listPage;
    private Socket socket;

    public MainFrame(Socket socket){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Students Application");
        setLayout(null);
        this.socket = socket;

        menu = new MainMenu(this);
        menu.setVisible(true);
        add(menu);

        addPage = new AddPage(this);
        addPage.setVisible(false);
        add(addPage);

        listPage = new ListPage(this);
        listPage.setVisible(false);
        add(listPage);
    }

    public MainMenu getMenu() {
        return menu;
    }

    public AddPage getAddPage() {
        return addPage;
    }

    public ListPage getListPage() {
        return listPage;
    }

    public Socket getSocket() {
        return socket;
    }
}

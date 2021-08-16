package SocketThread.Task2;

import Module2.GUI.Main;

import javax.swing.*;
import java.net.Socket;

public class MainFrame extends JFrame {

    private MainPage mainPage;
    private MesssagePage messsagePage;
    private Socket socket;
    public MainFrame(Socket socket){
        setSize(500, 500);
        setTitle("Client Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        this.socket = socket;

        mainPage = new MainPage(this);
        mainPage.setVisible(true);
        add(mainPage);

        messsagePage = new MesssagePage(this);
        messsagePage.setVisible(false);
        add(messsagePage);
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public MesssagePage getMesssagePage() {
        return messsagePage;
    }

    public Socket getSocket() {
        return socket;
    }
}

package MiniProject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 3160);
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);
            while(true){
            }
        } catch (Exception e) {
            e.printStackTrace( );
        }
    }
}

package SocketThread.Task2;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        try{
            Socket socket = new Socket("127.0.0.1", 2121);
            MainFrame mainFrame = new MainFrame(socket);
            mainFrame.setVisible(true);

            while(true){

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

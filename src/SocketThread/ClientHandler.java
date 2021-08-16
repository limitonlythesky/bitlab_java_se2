package SocketThread;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread{
    private Socket socket;
    private int id;

    public ClientHandler(Socket socket, int id){
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run() {
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Client connected");

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            while(true){
                String message = (String)inputStream.readObject();
                System.out.println(message);
                if(message.equalsIgnoreCase("hello")){
                    outputStream.writeObject("Hello, dear user" + id);
                }else{
                    outputStream.writeObject(in.next());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

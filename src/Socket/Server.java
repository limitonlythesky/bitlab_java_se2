package Socket;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <Message> list = new ArrayList<>();
        try{

            ServerSocket server = new ServerSocket(2145);
            Socket socket = server.accept();

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            outputStream.writeObject("Hi, dear Client, please enter your username:");
            String userName = (String) inputStream.readObject();
            while(true){
                outputStream.writeObject("PRESS [1] TO SEND MESSAGE\n" +
                                         "PRESS [2] TO EXIT");
                int choice = (int)inputStream.readObject();
                if(choice == 1){
                    outputStream.writeObject("Insert message text:");
                    String message = (String) inputStream.readObject();
                    SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    list.add(new Message(userName, message, formatter.format(date)));
                }else{
                    break;
                }
            }

            for(Message m: list){
                System.out.println(m.toString());
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

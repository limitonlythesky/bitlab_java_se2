package SocketThread;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        try{
            Socket socket = new Socket("127.0.0.1", 2070);

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                outputStream.writeObject(in.next());
                String message = (String)inputStream.readObject();
                System.out.println(message);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

package SocketThread.Task1;

import javax.security.sasl.SaslClient;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        try{
            Socket socket = new Socket("localhost", 1451);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            while(true){
                System.out.println(inputStream.readObject());
                int choice = in.nextInt();
                outputStream.writeObject(choice);
                if(choice == 1){
                    System.out.println(inputStream.readObject());
                }else if(choice == 2){
                    System.out.println(inputStream.readObject());
                    outputStream.writeObject(in.next());
                    System.out.println(inputStream.readObject());
                    outputStream.writeObject(in.next());
                    System.out.println(inputStream.readObject());
                }else{
                   break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

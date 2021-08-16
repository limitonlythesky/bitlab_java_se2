package SocketThread;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        try{
            ServerSocket server = new ServerSocket(2070);
            int id = 1;
            while(true){
                Socket socket = server.accept();
                ClientHandler clientHandler = new ClientHandler(socket, id);
                clientHandler.start();
                id++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

package SocketThread.Task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String args[]){
        try{
            ServerSocket server = new ServerSocket(1451);
            int id = 1;
            PackageData packageData = new PackageData("add");
            while(true){
                Socket socket = server.accept();
                ClientHandler clientHandler = new ClientHandler(socket, id, packageData);
                clientHandler.start();
                id++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

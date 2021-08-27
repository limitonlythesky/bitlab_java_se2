package MiniProject;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        DBManager dbManager = new DBManager();
        dbManager.connect();
        try{
            ServerSocket server = new ServerSocket(3160);
            while(true) {
                Socket socket = server.accept( );
                ClientHandler clientHandler = new ClientHandler(socket, dbManager);
                clientHandler.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

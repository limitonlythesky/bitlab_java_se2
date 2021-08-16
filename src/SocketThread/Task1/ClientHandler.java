package SocketThread.Task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread{
    private Socket socket;
    private int id;
    private PackageData packageData;

    public ClientHandler(Socket socket, int id, PackageData packageData){
        this.socket = socket;
        this.id = id;
        this.packageData = packageData;
    }

    @Override
    public void run() {
        try{
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            while(true){
                outputStream.writeObject("PRESS 1 TO LIST BOOKS\n" +
                        "PRESS 2 TO ADD BOOKS\n" +
                        "PRESS 0 TO DISCONNECT FROM SERVER");
                int choice = (int)inputStream.readObject();
                if(choice == 1){
                    outputStream.writeObject(packageData.getBooks().toString());
                }else if(choice == 2){
                    outputStream.writeObject("Enter name: ");
                    String name = (String)inputStream.readObject();
                    outputStream.writeObject("Enter author: ");
                    String author = (String)inputStream.readObject();
                    packageData.addBook(new Book(name, author));
                    outputStream.writeObject("This book is successfully added");
                }else{
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

package MiniProject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread {
    private Socket socket;
    private DBManager dbManager;

    public ClientHandler(Socket socket, DBManager dbManager){
        this.socket = socket;
        this.dbManager = dbManager;
    }

    @Override
    public void run() {
        try{
            System.out.println("Client connected");

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            while(true){
                PackageData packageData = (PackageData)inputStream.readObject();
                System.out.println(packageData.getOperationType());
                if(packageData.getOperationType().equals("ADD_STUDENT")){
                    dbManager.addStudent(packageData.getStudent());
                }else{
                    outputStream.writeObject(dbManager.getAllStudents());
                    outputStream.reset();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

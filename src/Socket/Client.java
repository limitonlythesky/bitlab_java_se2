package Socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try{
            Socket socket = new Socket("127.0.0.1", 2145);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println(inputStream.readObject());
            outputStream.writeObject(in.next());
            while (true){
                System.out.println(inputStream.readObject());
                int choice = in.nextInt();
                outputStream.writeObject(choice);
                if(choice == 1){
                    System.out.println(inputStream.readObject());
                    String message = in.next();
                    outputStream.writeObject(message);
                }else{
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

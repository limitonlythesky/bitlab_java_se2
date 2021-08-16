package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <User> users = getUserList();
        while(true){
            System.out.println("PRESS [1] TO ADD USERS\n" +
                    "PRESS [2] TO LIST USERS\n" +
                    "PRESS [3] TO DELETE USERS\n" +
                    "PRESS [4] TO EXIT");
            int choice = in.nextInt();
            if(choice == 1){
                int id = in.nextInt();
                String login = in.next();
                String password = in.next();
                users.add(new User(id, login, password));
                saveUserList(users);
            }else if(choice == 2){
                users = getUserList();
                System.out.println(users.toString());
            }else if(choice == 3){
                users.clear();
                saveUserList(users);
            }else{
                break;
            }
        }

    }

    public static ArrayList<User> getUserList(){
        ArrayList <User> users = new ArrayList<>();
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test2.txt"));
            users = (ArrayList<User>)inputStream.readObject();
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static void saveUserList(ArrayList <User> users){
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test2.txt"));
            outputStream.writeObject(users);
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

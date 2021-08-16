package Buffer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <User> list = getUsersList();
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
                list.add(new User(id, login, password));
                saveUsersList(list);
            }else if(choice == 2){
                list = getUsersList();
                for(User s: list){
                    System.out.println(s.toString());
                }
            } else if (choice == 3) {
                list.clear();
                saveUsersList(list);
            }else{
                break;
            }
        }
    }

    public static void saveUsersList(ArrayList <User> list){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("test.txt"));
            for(User s: list){
                bf.write(s.getId() + "\n");
                bf.write(s.getLogin() + "\n");
                bf.write(s.getPassword() + "\n");
            }
            bf.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList <User> getUsersList(){
        ArrayList <User> list = new ArrayList<>();
        try{
            BufferedReader bf = new BufferedReader(new FileReader("test.txt"));
            String id = "";
            while((id = bf.readLine()) != null){
                int ID = Integer.parseInt(id);
                String login = bf.readLine();
                String password = bf.readLine();
                list.add(new User(ID, login, password));
            }
            bf.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}

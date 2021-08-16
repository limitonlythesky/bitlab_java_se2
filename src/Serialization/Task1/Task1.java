package Serialization.Task1;

import Serialization.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <Student> students = getList();
        while(true){
            System.out.println("PRESS [1] TO ADD STUDENT\n" +
                    "PRESS [2] TO LIST STUDENTS\n" +
                    "PRESS [0] TO EXIT");

            int choice = in.nextInt();

            if(choice == 1){
                System.out.println("Name: ");
                String name = in.next();
                System.out.println("Surname: ");
                String surname = in.next();
                ArrayList <Subject> subjects = new ArrayList<>();

                while(true){
                    System.out.println("PRESS [1] TO ADD SUBJECT\n" +
                            "PRESS [0] TO GO TO MAIN MENU"
                            );

                    int choice1 = in.nextInt();

                    if(choice1 == 1){
                        System.out.println("Name: ");
                        String name1 = in.next();
                        System.out.println("Credits: ");
                        int credits = in.nextInt();

                        subjects.add(new Subject(name1, credits));
                    }else{
                        break;
                    }
                }
                students.add(new Student(name, surname, subjects));
                saveList(students);
            }else if(choice == 2){
                students = getList();
                System.out.println(students.toString());
            }else{
                System.exit(0);
            }
        }
    }

    public static ArrayList<Student> getList(){
        ArrayList <Student> students = new ArrayList<>();
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test2.txt"));
            students = (ArrayList<Student>)inputStream.readObject();
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static void saveList(ArrayList <Student> students){
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test2.txt"));
            outputStream.writeObject(students);
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

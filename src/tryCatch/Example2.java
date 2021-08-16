package tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        User []users = new User[5];
        for(int i = 0; i < 5; i++){
            String name = in.next();
            String surname = in.next();
            int age = in.nextInt();
            users[i] = new User(name, surname, age);
        }
        /*Library library = new Library("Pushkin", "Almaty");
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("ID: ");
            int id = in.nextInt();
            System.out.println("Name:");
            String name = in.next();
            System.out.println("Author: ");
            String author = in.next();
            if(id == 0){
                Book book = null;
                library.addBook(book);
            }else{
                Book book = new Book(id, name, author);
                library.addBook(book);
            }
        }
        library.printBooks();*/
    }
}

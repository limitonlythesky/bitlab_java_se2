package SocketThread.Task1;

import java.io.*;
import java.util.ArrayList;

public class PackageData {
    private String operationType;
    private ArrayList <Book> books;
    private Book book;

    public PackageData(String operationType) {
        this.operationType = operationType;
        this.books = read();
        this.book = null;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Book> getBooks() {
        this.books = read();
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        write(books);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void addBook(Book book){
        books.add(book);
        write(books);
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", books=" + books +
                ", book=" + book +
                '}';
    }

    public static void write(ArrayList<Book> books){
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\limit\\OneDrive\\Desktop\\bitlabacademy\\src\\SocketThread\\Task1\\books.txt"));
            outputStream.writeObject(books);
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList <Book> read(){
        ArrayList <Book> books = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\limit\\OneDrive\\Desktop\\bitlabacademy\\src\\SocketThread\\Task1\\books.txt"));
            books = (ArrayList)inputStream.readObject();
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return books;
    }
}

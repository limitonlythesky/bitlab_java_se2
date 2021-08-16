package Multithreading;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Operation op1 = new Operation("Add client", 5);
        Operation op2 = new Operation("Delete client", 4);
        Operation op3 = new Operation("Clear history", 8);
        Operation op4 = new Operation("Restore history", 5);
        Operation op5 = new Operation("Take money", 3);
        Operation op6 = new Operation("Deposit money", 1);
        Operation op7 = new Operation("List clients", 2);
        Operation op8 = new Operation("Create account", 6);
        Operation op9 = new Operation("Check account", 7);

        op1.start();
        op2.start();
        op3.start();
        op4.start();
        op5.start();
        op6.start();
        op7.start();
        op8.start();
        op9.start();
    }
}

package com.company;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class CityBankATM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hi, Dear User of our ATM!");
        System.out.println("Please, write your Bank Account number and PIN-Code.");
        String accountNumber = in.next();
        String pinCode = in.next();

        BankAccount account = new NationalBankAccount();
        for(int i = 0; i < Database.allAccounts.length; i++){
            if(Database.allAccounts[i].getAccountNumber().equals(accountNumber) && Database.allAccounts[i].getPinCode().equals(pinCode)){
                account = Database.allAccounts[i];
                break;
            }
        }

        if(account instanceof CityBankAccount){
            int choice = 1;
            while(true){
                System.out.println("PRESS [1] TO CASH WITHDRAWAL");
                System.out.println("PRESS [2] TO VIEW BALANCE");
                System.out.println("PRESS [3] TO CHANGE PIN CODE");
                System.out.println("PRESS [4] TO CASH IN ACCOUNT");
                System.out.println("PRESS [5] TO VIEW ACCOUNT DATA");
                System.out.println("PRESS [6] TO EXIT");
                choice = in.nextInt();
                if(choice == 1){
                    int credit = in.nextInt();
                    account.creditBalance(credit);
                }else if(choice == 2){
                    System.out.println(account.totalBalance());
                }else if(choice == 3){
                    System.out.println("Entry your new Pin-Code.");
                    String pin = in.next();
                    account.setPinCode(pin);
                }else if(choice == 4){
                    int debet = in.nextInt();
                    account.debetBalance(debet);
                }else if(choice == 5){
                    System.out.println(account.accountData());
                }else{
                    break;
                }
            }
        }else{
            while(true) {
                System.out.println("PRESS [1] TO CASH WITHDRAWAL");
                System.out.println("PRESS [2] TO VIEW BALANCE");
                System.out.println("PRESS [3] TO EXIT");
                int choice = in.nextInt();
                if(choice == 1){
                    int credit = in.nextInt();
                    account.creditBalance(credit);
                }else if(choice == 2){
                    System.out.println(account.totalBalance());
                }else{
                    break;
                }
            }
        }
    }
}

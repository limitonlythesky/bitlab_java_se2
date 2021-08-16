package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        int i = a.indexOf(b);
        int j = 0;
        while(i!=-1)
        {
            j++;
            a = a.substring(i+1);
            i = a.indexOf(b);
        }
        System.out.println(j);
    }

}

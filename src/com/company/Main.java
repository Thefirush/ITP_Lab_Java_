package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(" Comparing strings with compareTo:");
        if (s1.compareTo(s2) == 0) {
            System.out.println("This stings are equal");
        } else {
            System.out.println("This strings are not equal");
        }
    }
}

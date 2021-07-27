package org.example;

/*
    Creator: Noah Seligson
*/

import java.net.URL;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        while (true) {
            try {
                Scanner nameScan = new Scanner(System.in);
                System.out.print("Who is the professor you want to search for? ");
                Link link = new Link();
                URL url = new URL(link.getLink(nameScan.nextLine()));
                System.out.println(link.getRating(url));
                System.out.println("More info: " + link.theLink);
                Thread.sleep(1000);
                System.out.print("\nWould you like to search for another professor (y/n)? ");
                String string = new Scanner(System.in).nextLine().toLowerCase(Locale.ROOT);
                if(string.equals("n") || string.equals("no")){
                    System.out.print("Thank you for using this application.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("An error has occurred. Make sure you type an accurate professor name.\n");
            }
        }
    }
}

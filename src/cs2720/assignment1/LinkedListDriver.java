 package cs2720.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cs2720.assignment1.*;

public class LinkedListDriver {


    public static void main(String[] args) {

        // Creating an empty linked list
        SortedLinkedList linkedList = new SortedLinkedList();


        // creates a file object using the command line argment and a scanner object to read it.
        try {
            File text = new File(args[0]);
            Scanner scan1 = new Scanner(text);

            // Taking numbers from the file and adding them to our linkedList. We don't need to
            // worry about sorting here because the linkedList.insert() already does this.
            while(scan1.hasNext()) {
                linkedList.insertItem(new ItemType(scan1.nextInt()));
            } // while
        } catch (FileNotFoundException e) {
            System.out.print("File not found");
        }

        // Boolean variable to control the menu.
        boolean again = true;

        // Scanner to read user input.
        Scanner scan2 = new Scanner(System.in);

        while(again) {

            System.out.println();
            System.out.println("Commands:");
            System.out.println("(i) - Insert value");
            System.out.println("(d) - Delete value");
            System.out.println("(s) - Search value");
            System.out.println("(n) - Print next iterator value");
            System.out.println("(r) - Reset Iterator");
            System.out.println("(a) - Delete alternate nodes");
            System.out.println("(m) - Merge Lists");
            System.out.println("(t) - Find intersection");
            System.out.println("(p) - Print list");
            System.out.println("(l) - Print length");
            System.out.println("(q) - Quit program");

            System.out.println("Enter a command: ");

            String input = scan2.next();



            switch (input) {

            case "i":
                //linkedList.insertItem();
                break;
            case "d":
                //linkedList.deleteItem();
                break;
            case "s":
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a number to search: ");
                int searchValue = scanner.nextInt();
                //linkedList.search(searchValue);
                break;
            case "n":
                System.out.println("You want to print the next iterator value");
                break;
            case "r":
                System.out.println("You want to reset the iterator");
                break;
            case "a":
                System.out.println("You want to delete alternate nodes");
                break;
            case "m":
                System.out.println("You want to merge lists");
                linkedList.merge();
                break;
            case "t":
                System.out.println("You want to find the intersection");
                break;
            case "p": System.out.println("The list is: ");
                break;
            case "l": System.out.println("The length of the list is ");
                break;
            case "q":
                again = false;
                break;
            default:
                System.out.println("Invalid command, try again!");

            } // switch

        } // while
    } // main

} // LinkedListDriver

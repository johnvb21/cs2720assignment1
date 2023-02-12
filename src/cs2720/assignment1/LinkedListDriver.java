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

            do {

                linkedList.insertItem(new ItemType(scan1.nextInt()));

            } while(scan1.hasNext());
        } catch (FileNotFoundException e) {
            System.out.print("File not found");
        }

        // Boolean variable to control the menu.
        boolean again = true;

        // Scanner to read user input.
        Scanner scan2 = new Scanner(System.in);


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

        while(again) {

            System.out.print("Enter a command: ");
            String input = scan2.next();



            switch (input) {

            case "i":
                Scanner scan3 = new Scanner(System.in);
                System.out.print("\tEnter a number to insert: ");
                ItemType item1 = new ItemType(scan3.nextInt());
                System.out.print("\tOriginal List: ");
                linkedList.printList();
                linkedList.insertItem(item1);
                System.out.print("\tNew List: ");
                linkedList.printList();

                break;
            case "d":
                Scanner scan4 = new Scanner(System.in);
                System.out.print("\tEnter a number to delete: ");
                ItemType item2 = new ItemType(scan4.nextInt());
                if (linkedList.getLength() == 0) {
                    System.out.println("\tYou cannot delete from an empty list");
                    break;
                } // if
                System.out.print("\tOriginal List: ");
                linkedList.printList();
                linkedList.deleteItem(item2);
                System.out.print("\tNew List: ");
                linkedList.printList();
                break;
            case "s":
                Scanner scanner = new Scanner(System.in);
                System.out.print("\tEnter a number to search: ");
                int searchValue = scanner.nextInt();
                int index = linkedList.searchItem(new ItemType(searchValue));
                System.out.print("\tOriginal List: ");
                linkedList.printList();
                if (index == -2) {
                  System.out.println("\tItem is not present in the array");
                } else if (index == -1) {
                  System.out.println("\tThe list is empty");
                } else {
                  System.out.println("\tThe item is present at index " + index);
             }
                break;
            case "n":
                ItemType item = linkedList.getNextItem();
                if (item != null) {
                    System.out.println(item.getValue());
                } // if
                break;
            case "r":
                linkedList.resetIterator();
                break;
            case "a":
                System.out.print("\tOriginal list: ");
                linkedList.printList();
                linkedList.deleteAlternate();
                System.out.print("\tNew List: ");
                linkedList.printList();
                break;
            case "m":
                linkedList.merge();
                break;
            case "t":
                linkedList.intersection();
                break;
            case "p": System.out.print("\tThe list is: ");
                linkedList.printList();
                break;
            case "l": System.out.print("\tThe length of the list is ");
                System.out.println(linkedList.getLength());
                break;
            case "q":
                again = false;
                break;
            default:
                System.out.println("\tInvalid command, try again!");

            } // switch

        } // while
    } // main

} // LinkedListDriver

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
            //linkedList.insert(scan1.nextInt());
                System.out.println(scan1.nextInt() + " ");
            } // while
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        // Boolean variable to control the menu.
        boolean again = true;

        // Scanner to read user input.
        Scanner scan2 = new Scanner(System.in);

        while(again) {

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

            String input = scan2.next();



            switch (input) {

            case "i":
                break;
            case "d":
                break;
            case "s":
                break;
            case "n":
                break;
            case "r":
                break;
            case "a":
                break;
            case "m":
                break;
            case "t":
                break;
            case "p":
                break;
            case "l":
                break;
            case "q":
                again = false;
                break;
            default:
                System.out.println("Invalid command, try again!");

            } // switch

        } // while
    } // main

    // Bubble sort method to sort file input before becoming a Linked list
    // Maybe not necessary...maybe  better to just insert these into an empty linked list and let
    // the insert method take care of the sorting.
    /*
    private static int[] sort(int[] unsorted) {
        int n = unsorted.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (unsorted[j] > unsorted[j+1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                } // if
            } // for
        } // for
        return unsorted;
    } // sort
    */

} // LinkedListDriver

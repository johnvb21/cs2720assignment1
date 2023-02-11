package cs2720.assignment1;

import java.lang.Integer;
import java.util.Scanner;

public class SortedLinkedList {
    private NodeType head;
    private NodeType predloc;
    private NodeType currentPos;

    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;

    } // SortedLinkedList

    // method for getting the length of the linkedlist
    public int getLength() {
        int length = 1;
        currentPos = head;
        if (head == null) {
            return 0;
        } // if
        while (currentPos.next != null) {
            length++;
            currentPos = currentPos.next;
        } // while
        return length;
    } // getLength




    // method for printing the list
    public void printList() {
        currentPos = head;
        while (currentPos != null) {
            System.out.print(currentPos.info.getValue() + " ");
            currentPos = currentPos.next;
        } // for
        System.out.println();
    } // printList




    // method for inserting an item into the list
    public void insertItem(ItemType item) {
        if (getLength() > 1) {
            predloc = this.head;
            currentPos = predloc.next;
        }
        // check if the list is empty
        if (this.head == null) {
            this.head = new NodeType(item);
            currentPos = this.head;
            predloc = this.head;
            return;
        } // if
        // checks if the item is less than head
        if (this.head.info.compareTo(item) == 1) {
            NodeType node = new NodeType(item);
            node.next = this.head;
            this.head = node;
            predloc = this.head;
            currentPos = predloc.next;
            return;
        } // if
        // sees if current position is less than item, if so, it moves forward
        while (currentPos.next != null) {
            if (currentPos.info.compareTo(item) == -1) {
                predloc = currentPos;
                currentPos = predloc.next;
            } // if
            if (currentPos.info.compareTo(item) == 1) {
                NodeType node = new NodeType(item);
                predloc.next = node;
                node.next = currentPos;
                break;
            } // if
        } // while

        if (currentPos.next == null && (currentPos.info.compareTo(item) == -1)) {
            currentPos.next = new NodeType(item);
        } // if
    } // insertItem


    public void deleteItem(ItemType item) {
        if (getLength() > 1) {
            predloc = this.head;
            currentPos = predloc.next;
        } // if
        while (currentPos.next != null) {
            if (currentPos.info.compareTo(item) == 0) {
                predloc.next = currentPos.next;
                break;
            } else {
                predloc = currentPos;
                currentPos = predloc.next;
            } // else
        } // while
    } // deleteItem


    public int searchItem(ItemType item) {
        return 0;
    } // searchItem


    public ItemType getNextItem() {
        return null;
    } // getNextItem


    public void resetList() {
        this.currentPos = null;
        this.head = null;
    } // resetList

    public void merge() {

        // Part#1 Ask for length of new list//
/*------------------------------------------------*/
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Enter the length of the new list: ");
        int length = scan1.nextInt();


        //Part#2 Ask for numbers in new list//
/*------------------------------------------------*/
        int[] values = new int[length];
        System.out.print("Enter the new numbers ");

        for (int i = 0; i < length; i++) {
            values[i] = scan1.nextInt();
        } // for

        //Part#3 Print current list//
/*------------------------------------------------*/
        System.out.print("List 1: ");
        this.printList();

        //Part#4 Print new list to be merged//
/*------------------------------------------------*/
        System.out.print("List 2: ");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        } // for
        System.out.println();

        //Part#5 Merge the lists//
/*------------------------------------------------*/
        for (int i = 0; i < values.length; i++) {
            this.insertItem(new ItemType(values[i]));
        }

        //Part#6 Print merged list//
/*------------------------------------------------*/
        System.out.print("Merged List: ");
         this.printList();
    } // merge


    public void intersection() {




    } // intersection


} // SortedLinkedList

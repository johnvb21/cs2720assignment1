package cs2720.assignment1;

import java.util.Scanner;
import java.lang.Integer;

public class SortedLinkedList {
    private NodeType head;
    private NodeType predloc;
    private NodeType currentPos;
    private NodeType iterator;
    // constructor method
    public SortedLinkedList() {
        this.iterator = head;
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

        NodeType temp = currentPos;



        currentPos = head;
        while (currentPos != null) {
            System.out.print(currentPos.info.getValue() + " ");
            currentPos = currentPos.next;
        } // while
        System.out.println();
        currentPos = temp;
    } // printList



    // method for inserting into a linked list
    public void insertItem(ItemType item) {
        if ((searchItem(item) != -2) && (searchItem(item) != -1)) {
             System.out.println("\tItem already exists");

        } else {
            if (getLength() > 1) {
                predloc = this.head;
                currentPos = predloc.next;
            }
            // check if the list is empty
            if (this.head == null) {
                this.head = new NodeType(item);
                currentPos = this.head;
                predloc = this.head;
                iterator = head;
            // checks if this.head is greater than item
            } else if (this.head.info.compareTo(item) == 1) {
                NodeType node = new NodeType(item);
                node.next = this.head;
                this.head = node;
                predloc = this.head;
                currentPos = predloc.next;

            } else {
                // sees if current position is less than item, if so, it moves forward
                while (currentPos.next != null) {
                    if (currentPos.info.compareTo(item) == -1) {
                        predloc = currentPos;
                        currentPos = predloc.next;

                    } // if
                    // if currentPos is greater than item, the item is inserted between
                    // predloc and currentPos
                    if (currentPos.info.compareTo(item) == 1) {
                        NodeType node = new NodeType(item);
                        predloc.next = node;
                        node.next = currentPos;
                        break;
                    } // if



                } // while
                // This is responsible for ensuring that the end of the list is updated
                if (currentPos.next == null && (currentPos.info.compareTo(item) == -1)) {
                    currentPos.next = new NodeType(item);
                } // if
            } // else
            } // else

        // special case if length is of list two and new item needs to be inserted between the two
        if ((this.getLength() == 2) && (head.info.compareTo(item) == -1)
        && (head.next.info.compareTo(item) == 1)) {
            NodeType node = new NodeType(item);
            NodeType temp;
            temp = head.next;
            head.next = node;
            node.next = temp;
        }

    } // insertItem


    // method to delete an item from the linked list
    public void deleteItem(ItemType item) {
        int hasItem = 0;
        currentPos = this.head;
        predloc = this.head;
        if (this.currentPos == null) {
            System.out.println("\tYou cannot delete from an empty list");

        } else {

            if (getLength() > 1) {
                predloc = this.head;
                currentPos = predloc.next;
            } else if ((getLength() == 1) && (currentPos.info.compareTo(item) == 0)) {
                this.head = null;
                currentPos = null;
                hasItem = 1;
            } // else if
            if ((hasItem == 0) && (predloc.info.compareTo(item) == 0)) {
                this.head = predloc.next;
                hasItem = 1;
            } // if


            while ((hasItem == 0) && (currentPos.next != null)) {
                if (currentPos.info.compareTo(item) == 0) {
                    predloc.next = currentPos.next;
                    hasItem = 1;
                    break;
                } else {
                    predloc = currentPos;
                    currentPos = predloc.next;
                } // else

            } // while
            if ((hasItem == 0) && (currentPos.next == null) &&
            (currentPos.info.compareTo(item) == 0)) {
                predloc.next = null;
                hasItem = 1;
            } // if
            if (hasItem == 0) {
                System.out.println("\tThe item is not present in the list");
            } // if
        } // else

    } // deleteItem


    // method for searching for an item
    public int searchItem(ItemType item) {

        // If list is empty
        if (this.getLength() == 0) {
            //System.out.println("The list is empty");
            return -1;
        }
        else {
            NodeType node = head;
            int index = 1;

            while (node.next != null) {

                if (node.info.compareTo(item) == 0) {
                    //System.out.println("The item is present at index " + index);
                    return index;
                } // if

                index++;
                node = node.next;
            } // while

            if (node.info.compareTo(item) == 0) {
                //System.out.println("The item is present at index " + index);
                return index;
            } // if

            // If item is not present in the list
            //System.out.println("Item is not present in the list");
            return -2;
        } // if - esle
    } // searchItem

// method to get next item
    public ItemType getNextItem() {
        ItemType item = new ItemType(0);
        if (this.head == null || iterator == null) {
            System.out.println("List is empty");
            item = null;
        } else if (iterator.next == null) {
            System.out.println("The end of the list has been reached");
            item = null;
        } else {
            item = iterator.info;
            iterator = iterator.next;
        } // else
        return item;
    } // getNextItem


    // method to reset the linked list
    public void resetList() {
        this.currentPos = null;
        this.head = null;
    } // resetList


    // method to merge the list with a new list
    public void merge() {

        // Part#1 Ask for length of new list//
        /*----------------------------------*/
        Scanner scan1 = new Scanner(System.in);
        System.out.print("\tEnter the length of the new list: ");
        int length = scan1.nextInt();


        //Part#2 Ask for numbers in new list//
        /*----------------------------------*/
        int[] values = new int[length];
        System.out.print("\tEnter the new numbers: ");

        SortedLinkedList linkedList = new SortedLinkedList();

        for (int i = 0; i < length; i++) {
            values[i] = scan1.nextInt();
            if ((linkedList.searchItem(new ItemType(values[i])) == -2) ||
            (linkedList.searchItem(new ItemType(values[i])) == -1)
                ) {
            linkedList.insertItem(new ItemType(values[i]));
            } // if
        } // for

        String duplicates = "";

        for (int i = 0; i < values.length; i++) {
            if (
                (this.searchItem(new ItemType(values[i])) != -2) &&
                (linkedList.searchItem(new ItemType(values[i])) != -2)
                ) {
                duplicates = duplicates + values[i] + " ";
            } // if
        } //for

        //Part#3 Print current list//
        /*-------------------------*/
        System.out.print("\tList 1: ");
        this.printList();

        //Part#4 Print new list to be merged//
        /*----------------------------------*/
        System.out.print("\tList 2: ");

        linkedList.printList();


        //Part#5 Merge the lists//
        /*----------------------*/

        for (int i = 0; i < values.length; i++) {

            if (this.searchItem(new ItemType(values[i])) == -2) {


            this.insertItem(new ItemType(values[i]));

            } // if
        } // for

        //Part#6 Print merged list//
        /*------------------------*/
        System.out.print("\tMerged List: ");
         this.printList();

         // removes merged items from list

         for ( int i = 0; i < values.length; i++) {
             if (this.searchItem(new ItemType(values[i])) != -2) {
             this.deleteItem(new ItemType(values[i]));
             } // if
         } // for




         // adds back in duplicates
         String[] duplicateValues = duplicates.split(" ");

         if (duplicateValues[0].equals("") == false) {

             for (int i = 0; i < duplicateValues.length; i++) {

                 if (this.searchItem(new ItemType(Integer.parseInt(duplicateValues[i]))) == -2) {
                     this.insertItem(new ItemType(Integer.parseInt(duplicateValues[i])));
                 } // if

             } // for

         } // if


    } // merge


    // method to find intersection of list and new list
    public void intersection() {

      // Part#1 Ask for length of new list//
      /*----------------------------------*/
        Scanner scan1 = new Scanner(System.in);
        System.out.print("\tEnter the length of the new list: ");
        int length = scan1.nextInt();


      // Part#2 Ask for numbers in new list//
      /*-----------------------------------*/
        int[] values = new int[length];
        System.out.print("\tEnter the new numbers: ");

        SortedLinkedList linkedList = new SortedLinkedList();

        for (int i = 0; i < length; i++) {
            values[i] = scan1.nextInt();
            linkedList.insertItem(new ItemType(values[i]));
        } // for


      //Part#3 Print current list//
      /*-------------------------*/
        System.out.print("\tList 1: ");
        this.printList();


      //Part#4 Print new list to be merged//
      /*----------------------------------*/
        System.out.print("\tList 2: ");

        linkedList.printList();


      //Part#5 Intersect the lists//
      /*--------------------------*/

        SortedLinkedList intersectedList = new SortedLinkedList();

        for (int i = 0; i < values.length; i++) {

      if ((this.searchItem(new ItemType(values[i])) != -2) &&
      (linkedList.searchItem(new ItemType(values[i])) != -2)) {
          intersectedList.insertItem(new ItemType(values[i]));

      }
      }

      //Part#6 Print intersected list//
      /*-----------------------------*/
      System.out.print("\tIntersection of lists: ");
      intersectedList.printList();

    } // intersection


    // method to delete alternate nodes
    public void deleteAlternate() {

        if (this.getLength() == 0) {

            System.out.println("\tThe list is empty");
        } // if
        else {


            currentPos = this.head;
            predloc = this.head;
            while (currentPos != null) {
                try {
                    currentPos = currentPos.next;
                    NodeType node = currentPos.next;
                    predloc.next = currentPos.next;
                    currentPos = node;
                    predloc = currentPos;
                } catch (Exception e) {
                    currentPos = null;
                } // catch
            } // while

        } // if-else

    } // deleteAlternate

    // method to reset the iterator
    public void resetIterator() {
      iterator = head;
      System.out.println("\tIterator is reset");
    }

} // SortedLinkedList

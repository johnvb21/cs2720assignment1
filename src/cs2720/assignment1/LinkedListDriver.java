package cs2720.assignment1;

public class LinkedListDriver {

    public static void main(String[] args) {
        ItemType t = new ItemType(2);
        ItemType f = new ItemType(9);
        ItemType s = new ItemType(4);
        ItemType q = new ItemType(1);

        SortedLinkedList list = new SortedLinkedList();

        list.insertItem(q);
        System.out.println(list.getLength());

    } // main
} // LinkedListDriver

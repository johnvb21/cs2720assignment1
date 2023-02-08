package cs2720.assignment1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;

    public SortedLinkedList() {
        this.head = new NodeType();
        this.currentPos = null;

    } // SortedLinkedList

    public int getLength() {

    } // getLength
    public void insertItem(ItemType item) {
        if (this.getLength() == 0) {
            this.head.next = item;
        } // if
    } // insertItem
    public void deleteItem(ItemType item {

    } // deleteItem
    public int searchItem(ItemType item) {

    } // searchItem
    public ItemType getNextItem() {

    } // getNextItem
    public void resetList() {
        this.currentPos = null;
    } // resetList
} // SortedLinkedList

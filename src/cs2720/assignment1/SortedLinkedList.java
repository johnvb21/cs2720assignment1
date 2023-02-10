package cs2720.assignment1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType predloc;
    private NodeType currentPos;

    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;

    } // SortedLinkedList

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
    public void insertItem(ItemType item) {

        if (this.head == null) {
            head = new NodeType(item);
            currentPos = head;
        } // if
        currentPos = head;

        while (currentPos != null) {
            if (currentPos.info.getValue() < item.getValue()) {
                predloc = currentPos;
                currentPos = currentPos.next;
            } else if (currentPos.info.getValue() > item.getValue()) {
                NodeType node = new NodeType(item);
                predloc.next = node;
                node.next = currentPos;
            } // else if
        } // while


    } // insertItem
    public void deleteItem(ItemType item) {

    } // deleteItem
    public int searchItem(ItemType item) {
        return 0;
    } // searchItem
    public ItemType getNextItem() {
        return null;
    } // getNextItem
    public void resetList() {
        this.currentPos = null;
    } // resetList
} // SortedLinkedList

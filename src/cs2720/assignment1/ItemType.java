package cs2720.assignment1;

public class ItemType {
    private int value;

    public int compareTo(ItemType item) {
        if (item.getValue() == this.value) {
            return 0;
        } else if (item.getValue() < this.value) {
            return 1;
        } else {
            return -1;
        } // else
    } // compareTo

    public int getValue() {
        return this.value;
    } // getValue

    public ItemType(int num) {
        this.value = num;
    } // initialize

} // ItemType

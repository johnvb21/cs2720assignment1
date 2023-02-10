package cs2720.assignment1;

public class NodeType {
    public ItemType info;
    public NodeType next;

    public NodeType(ItemType item) {
        this.info = item;
        this.next = null;
    }
} // NodeType

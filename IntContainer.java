// IntContainer.java
public class IntContainer {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public IntContainer() {
        head = null;
        size = 0;
    }
}
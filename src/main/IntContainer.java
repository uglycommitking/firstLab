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

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void add(int index, int value) {
        checkIndexForAdd(index);
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    public int get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    private Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Индекс " + index + " выходит за пределы. Размер: " + size);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                "Индекс " + index + " выходит за пределы. Размер: " + size);
        }
    }
        public int removeLast() {
        if (size == 0) throw new RuntimeException("Контейнер пуст!");
        return remove(size - 1);
    }

    public int remove(int index) {
        checkIndex(index);
        int removed;
        if (index == 0) {
            removed = head.value;
            head = head.next;
        } else {
            Node prev = getNode(index - 1);
            removed = prev.next.value;
            prev.next = prev.next.next;
        }
        size--;
        return removed;
    }

    public boolean removeByValue(int value) {
        boolean found = false;

        while (head != null && head.value == value) {
            head = head.next;
            size--;
            found = true;
        }

        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                size--;
                found = true;
            } else {
                current = current.next;
            }
        }

        return found;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
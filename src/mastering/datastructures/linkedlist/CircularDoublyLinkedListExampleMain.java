package mastering.datastructures.linkedlist;

public class CircularDoublyLinkedListExampleMain {
    public static void main(String[] args) {
        var linkedList = new CircularDoublyLinkedList<>(new Integer[]{6, 9, 2, 7, 8});

        linkedList.display();

        linkedList.delete(3);

        linkedList.display();

        linkedList.insert(5, 1);

        linkedList.display();
    }
}

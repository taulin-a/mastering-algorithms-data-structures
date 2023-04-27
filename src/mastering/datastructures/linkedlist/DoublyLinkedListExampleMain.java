package mastering.datastructures.linkedlist;

public class DoublyLinkedListExampleMain {
    public static void main(String[] args) {
        var linkedList = new DoublyLinkedList<>(new Integer[]{1, 2, 3, 4, 5, 6});

        linkedList.display();

        linkedList.insert(-1, 0);
        linkedList.insert(7, 7);

        linkedList.display();

        linkedList.delete(0);
        linkedList.delete(6);

        linkedList.display();

        linkedList.reverse();

        linkedList.display();

        linkedList.reverse();

        linkedList.display();
    }
}

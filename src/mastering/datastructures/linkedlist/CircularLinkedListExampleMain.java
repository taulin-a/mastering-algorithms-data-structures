package mastering.datastructures.linkedlist;

public class CircularLinkedListExampleMain {
    public static void main(String[] args) {
        var linkedList1 = new CircularLinkedList<>(new Integer[]{8, 3, 9, 6, 2});
        linkedList1.displayRecursive();

        linkedList1.insert(6, 1);

        linkedList1.display();

        linkedList1.delete(5);

        linkedList1.display();
    }
}

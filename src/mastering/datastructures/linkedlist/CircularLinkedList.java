package mastering.datastructures.linkedlist;

public class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public CircularLinkedList() {
        head = tail = null;
    }

    public CircularLinkedList(T element) {
        head = new Node<>(element);
        head.setNext(head);
        tail = head;
    }

    public CircularLinkedList(T[] elements) {
        head = new Node<>(elements[0]);

        Node<T> last = head;
        for (int i = 1; i < elements.length; i++) {
            var newNode = new Node<>(elements[i]);

            last.setNext(newNode);
            last = newNode;
        }

        last.setNext(head);
        tail = last;
    }

    public void display() {
        System.out.print("\n[ ");

        var iterator = head;
        do {
            System.out.print(iterator.getValue() + (iterator.getNext() != head ? ", " : ""));
            iterator = iterator.getNext();
        } while (iterator != head);

        System.out.print(" ]\n");
    }

    public void displayRecursive() {
        displayRecursive(head, true);
    }

    private void displayRecursive(Node<T> node, boolean firstTime) {
        if (node == head || firstTime) {
            if (firstTime)
                System.out.print("\n[ ");
        }

        if (node == head && !firstTime) {
            System.out.print(" ]\n");
            return;
        }

        System.out.print(node.getValue());

        if (node.getNext() != head) {
            System.out.print(", ");
        }

        displayRecursive(node.getNext(), false);
    }

    public void insert(T element, int index) {
        var newNode = new Node<>(element);

        if (index == 0) {
            newNode.setNext(head);
            tail.setNext(newNode);
            head = newNode;
            return;
        }

        var iterator = head;
        for (int i = 0; i < index - 1; i++) {
            iterator = iterator.getNext();
        }

        newNode.setNext(iterator.getNext());
        iterator.setNext(newNode);

        if (iterator == tail)
            tail = newNode;
    }

    public void append(T element) {
        var newNode = new Node<>(element);

        if (head == null) {
            head = tail = newNode;
            tail.setNext(head);
            return;
        }

        tail.setNext(newNode);
        newNode.setNext(head);
        tail = newNode;
    }

    public T delete(int index) {
        T aux;
        if (index == 0) {
            aux = head.getValue();
            tail.setNext(head.getNext());
            head = head.getNext();
            return aux;
        }

        var previous = head;
        var current = head.getNext();
        for (int i = 1; i < index; i++) {
            previous = current;
            current = current.getNext();
        }
        aux = current.getValue();

        previous.setNext(current.getNext());
        if (current == tail)
            tail = previous;

        return aux;
    }
}

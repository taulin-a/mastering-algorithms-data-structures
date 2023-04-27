package mastering.datastructures.linkedlist;

public class DoublyLinkedList<T> {
    private DNode<T> head;

    public DoublyLinkedList(T[] elements) {
        head = new DNode<>(elements[0]);

        DNode<T> previous = head;
        for (int i = 1; i < elements.length; i++) {
            var newNode = new DNode<>(elements[i]);
            previous.setNext(newNode);
            newNode.setPrevious(previous);
            previous = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("[empty]");
            return;
        }

        System.out.print("\n[ ");

        var iterator = head;
        do {
            System.out.print(iterator.getValue() + (iterator.getNext() != null ? ", " : ""));
            iterator = iterator.getNext();
        } while (iterator != null);

        System.out.print(" ]\n");
    }

    public void displayRecursive() {
        displayRecursive(head);
    }

    public int size() {
        var counter = 1;
        var iterator = head;
        while (iterator.getNext() != null) {
            counter++;
            iterator = iterator.getNext();
        }

        return counter;
    }

    private void displayRecursive(DNode<T> node) {
        if (node == head) {
            System.out.print("\n[ ");
        }

        if (node == null) {
            System.out.print(" ]\n");
            return;
        }

        System.out.print(node.getValue());

        if (node.getNext() != null) {
            System.out.print(", ");
        }

        displayRecursive(node.getNext());
    }

    public void insert(T element, int index) {
        var newNode = new DNode<>(element);

        if (index == 0) {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
            return;
        }

        var iterator = head;
        for (int i = 0; i < index - 1; i++) {
            iterator = iterator.getNext();
        }

        newNode.setNext(iterator.getNext());
        newNode.setPrevious(iterator);
        iterator.setNext(newNode);
        if (newNode.getNext() != null)
            newNode.getNext().setPrevious(newNode);
    }

    public void delete(int index) {
        if (index >= size())
            return;

        if (index == 0) {
            head = head.getNext();
            head.setPrevious(null);
            return;
        }

        var previous = head;
        var current = head.getNext();
        for (int i = 1; i < index; i++) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(current.getNext());

        if (previous.getNext() != null)
            previous.getNext().setPrevious(previous);
    }

    public void reverse() {
        if (head == null)
            return;

        var iterator = head;
        do {
            var aux = iterator.getPrevious();
            iterator.setPrevious(iterator.getNext());
            iterator.setNext(aux);

            if (iterator.getPrevious() == null)
                head = iterator;

            iterator = iterator.getPrevious();
        } while (iterator != null);
    }
}

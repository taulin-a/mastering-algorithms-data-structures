package mastering.datastructures.linkedlist;

public class CircularDoublyLinkedList<T> {
    private DNode<T> head;

    public CircularDoublyLinkedList(T[] elements) {
        head = new DNode<>(elements[0]);

        DNode<T> last = head;
        for (int i = 1; i < elements.length; i++) {
            var newNode = new DNode<>(elements[i]);

            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
        }

        last.setNext(head);
        head.setPrevious(last);
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

    public void insert(T element, int index) {
        var newNode = new DNode<>(element);

        if (index == 0) {
            newNode.setNext(head);
            newNode.setPrevious(head.getPrevious());
            head.getPrevious().setNext(newNode);
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
        iterator.getNext().setPrevious(newNode);
        iterator.setNext(newNode);
    }

    public void delete(int index) {
        if (index == 0) {
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            head = head.getNext();
            return;
        }

        var current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
    }
}

package mastering.datastructures.linkedlist;

public class Iterator<T> {
    private Node<T> current;

    public Iterator(Node<T> current) {
        this.current = current;
    }

    public T getValue() {
        return current.getValue();
    }

    public void next() {
        current = current.getNext();
    }

    public boolean currentIsNull() {
        return current == null;
    }

    public boolean hasNext() {
        return current.getNext() != null;
    }
}

package mastering.datastructures.linkedlist;

public class DNode<T> {
    private DNode<T> previous;
    private T value;
    private DNode<T> next;

    public DNode(T value) {
        this.value = value;
    }

    public DNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DNode<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DNode<T> getNext() {
        return next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }
}

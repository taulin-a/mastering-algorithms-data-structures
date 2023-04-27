package mastering.datastructures.linkedlist;

import javax.naming.OperationNotSupportedException;
import java.util.AbstractMap;

public class LinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;

    public LinkedList() {
    }

    public void append(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(value);
            lastNode = firstNode;
            return;
        }

        var iterator = firstNode;
        while (iterator.getNext() != null) iterator = iterator.getNext();

        iterator.setNext(new Node<>(value));
        lastNode = iterator.getNext();
    }

    public int size() {
        var count = 0;

        var iterator = firstNode;
        while (iterator != null) {
            count++;
            iterator = iterator.getNext();
        }

        return count;
    }

    public int sizeRecursive() {
        return sizeRecursive(firstNode);
    }

    private int sizeRecursive(Node<T> node) {
        if (node == null)
            return 0;

        return 1 + sizeRecursive(node.getNext());
    }

    public void display() {
        if (firstNode == null) {
            System.out.println("[empty]");
            return;
        }

        System.out.print("\n[ ");

        var iterator = firstNode;
        do {
            System.out.print(iterator.getValue() + (iterator.getNext() != null ? ", " : ""));
            iterator = iterator.getNext();
        } while (iterator != null);

        System.out.print(" ]\n");
    }

    public void displayRecursive() {
        displayRecursive(firstNode);
    }

    private void displayRecursive(Node<T> node) {
        if (node == firstNode) {
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

    public Integer sum() throws OperationNotSupportedException {
        if (firstNode == null)
            return null;

        if (firstNode.getValue() instanceof Integer) {
            var sum = 0;

            var iterator = firstNode;
            do {
                sum += (Integer) iterator.getValue();
                iterator = iterator.getNext();
            } while (iterator != null);

            return sum;
        } else {
            throw new OperationNotSupportedException();
        }
    }

    public Integer sumRecursive() throws OperationNotSupportedException {
        if (firstNode == null) {
            return 0;
        }

        if (!(firstNode.getValue() instanceof Integer)) {
            throw new OperationNotSupportedException();
        }

        return sumRecursive((Node<Integer>) firstNode);
    }

    private Integer sumRecursive(Node<Integer> node) {
        if (node == null)
            return 0;

        return node.getValue() + sumRecursive(node.getNext());
    }

    public T max() throws OperationNotSupportedException {
        if (firstNode == null)
            return null;

        if (!(firstNode.getValue() instanceof Comparable))
            throw new OperationNotSupportedException();

        var iterator = (Node<Comparable>) firstNode;
        var max = iterator.getValue();

        while (iterator != null) {
            if (iterator.getValue().compareTo(max) > 0) {
                max = iterator.getValue();
            }

            iterator = iterator.getNext();
        }

        return (T) max;
    }

    public T maxRecursive() throws OperationNotSupportedException {
        if (firstNode == null)
            return null;

        if (!(firstNode.getValue() instanceof Comparable))
            throw new OperationNotSupportedException();

        return (T) maxRecursive((Node<Comparable>) firstNode);
    }

    private Comparable maxRecursive(Node<Comparable> node) {
        if (node == null)
            return null;

        var result = maxRecursive(node.getNext());

        return result != null && result.compareTo(node.getValue()) > 0
                ? result
                : node.getValue();
    }

    public Node<T> linearSearch(T element) {
        var iterator = firstNode;
        while (iterator != null) {
            if (iterator.getValue().equals(element))
                return iterator;

            iterator = iterator.getNext();
        }

        return null;
    }

    public Node<T> linearSearchRecursive(T element) {
        return linearSearchRecursive(element, firstNode);
    }

    private Node<T> linearSearchRecursive(T element, Node<T> node) {
        if (node == null)
            return null;

        if (element.equals(node.getValue()))
            return node;

        return linearSearchRecursive(element, node.getNext());
    }

    public Node<T> linearSearchHead(T element) {
        var current = firstNode;
        var previous = firstNode;
        while (current != null) {
            if (current.getValue().equals(element) && current == previous) {
                return current;
            } else if (current.getValue().equals(element)) {
                previous.setNext(current.getNext());

                current.setNext(firstNode);

                firstNode = current;

                return current;
            }

            previous = current;
            current = current.getNext();
        }

        return null;
    }

    public void insert(T element, int index) {
        if (index > size())
            return;

        if (index == 0) {
            var newNode = new Node<>(element);
            newNode.setNext(firstNode);
            firstNode = newNode;

            if (firstNode.getNext() == null) lastNode = firstNode;

            return;
        }

        var i = 1;
        var previous = firstNode;
        var current = firstNode.getNext();

        while (i != index) {
            previous = current;
            current = current.getNext();
            i++;
        }

        var newNode = new Node<>(element);
        previous.setNext(newNode);
        newNode.setNext(current);

        if (current == null)
            lastNode = newNode;
    }

    public void insertLast(T element) {
        var node = new Node<>(element);
        if (firstNode == null) {
            firstNode = node;
            lastNode = firstNode;
            return;
        }

        lastNode.setNext(node);
        lastNode = node;
    }

    public void insertSorted(T element) throws OperationNotSupportedException {
        if (!(element instanceof Comparable))
            throw new OperationNotSupportedException();

        var node = new Node<>(element);
        if (firstNode == null) {
            firstNode = node;
            lastNode = firstNode;
            return;
        }

        var compElement = (Comparable) element;

        if (compElement.compareTo(firstNode.getValue()) <= 0) {
            node.setNext(firstNode);
            firstNode = node;
            return;
        }

        var previous = firstNode;
        var current = firstNode.getNext();
        while (current != null && compElement.compareTo(current.getValue()) > 0) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(node);
        node.setNext(current);

        if (node.getNext() == null)
            lastNode = node;
    }

    public T pop() {
        var value = firstNode.getValue();
        firstNode = firstNode.getNext();
        return value;
    }

    public T delete(int index) {
        if (index >= size() || index < 0)
            return null;

        T value;
        if (index == 0) {
            value = firstNode.getValue();
            firstNode = firstNode.getNext();
        } else {
            var i = 1;
            var previous = firstNode;
            var current = firstNode.getNext();
            while (i != index) {
                previous = current;
                current = current.getNext();
                i++;
            }
            value = current.getValue();
            previous.setNext(current.getNext());
        }

        return value;
    }

    public boolean isListSorted() {
        if (!(firstNode.getValue() instanceof Comparable))
            throw new UnsupportedOperationException();

        var x = (Comparable) firstNode.getValue();
        var current = firstNode.getNext();
        while (current != null) {
            if (x.compareTo(current.getValue()) > 0) return false;

            x = (Comparable) current.getValue();
            current = current.getNext();
        }

        return true;
    }

    public void removeDuplicates() {
        var previous = firstNode;
        var current = firstNode.getNext();
        while (current != null) {
            if (previous.getValue().equals(current.getValue())) {
                previous.setNext(current.getNext());
                current = previous.getNext();
            } else {
                previous = current;
                current = current.getNext();
            }
        }
    }

    public void reverse() {
        var i = 0;
        var current = firstNode;
        var elements = new Object[size()];
        while (current != null) {
            elements[i] = current.getValue();
            i++;
            current = current.getNext();
        }

        current = firstNode;
        i--;

        while (current != null) {
            current.setValue((T) elements[i--]);
            current = current.getNext();
        }
    }

    public void reverseSliding() {
        Node<T> previous;
        Node<T> current = null;
        var next = firstNode;
        while (next != null) {
            previous = current;
            current = next;
            next = next.getNext();

            current.setNext(previous);
        }
        firstNode = current;
    }

    public void reverseRecursive() {
        doReverseRecursive(null, firstNode);
    }

    private void doReverseRecursive(final Node<T> previous, final Node<T> current) {
        if (current != null) {
            doReverseRecursive(current, current.getNext());
            current.setNext(previous);
        } else {
            firstNode = previous;
        }
    }

    public void concat(LinkedList<T> linkedList) {
        var iterator = firstNode;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }

        iterator.setNext(linkedList.firstNode);
    }

    public void mergeInto(LinkedList<T> linkedList) {
        if (!(firstNode.getValue() instanceof Comparable))
            throw new UnsupportedOperationException();

        var first = firstNode;
        var second = linkedList.firstNode;
        Node<T> last = null;
        while (first != null && second != null) {
            if (((Comparable) first.getValue()).compareTo(second.getValue()) < 0) {
                if (last != null) last.setNext(first);
                last = first;
                first = first.getNext();
                last.setNext(null);
            } else {
                if (last != null) last.setNext(second);
                last = second;
                second = second.getNext();
                last.setNext(null);
            }
        }

        if (first != null && last != null) last.setNext(first);

        if (second != null && last != null) last.setNext(second);
    }

    public boolean isCircular() {
        var iterator = firstNode.getNext();
        while (iterator != null && iterator != firstNode) {
            iterator = iterator.getNext();
        }

        return iterator == firstNode;
    }

    public T findMiddle() {
        var middlePos = (int) Math.floor(((double) size()) / 2d);

        var iterator = firstNode;
        for (int i = 0; i < middlePos; i++) {
            iterator = iterator.getNext();
        }

        return iterator.getValue();
    }

    public T findMiddleImproved() {
        var previous = firstNode;
        var nextAhead = firstNode.getNext();

        while (nextAhead != null) {
            previous = previous.getNext();
            nextAhead = nextAhead.getNext();

            if (nextAhead != null)
                nextAhead = nextAhead.getNext();
        }

        return previous.getValue();
    }

    public T findMiddleStack() {
        var stack = new java.util.LinkedList<T>();

        var iterator = firstNode;
        while (iterator != null) {
            stack.add(iterator.getValue());
            iterator = iterator.getNext();
        }

        var middlePos = (int) Math.floor(((double) stack.size()) / 2d);
        for (int i = 1; i <= middlePos; i++) stack.pop();

        return stack.pop();
    }

    public AbstractMap.SimpleImmutableEntry<T, T> getIntersection(LinkedList<T> other) {
        var stack1 = new java.util.LinkedList<T>();
        var iterator1 = firstNode;
        while (iterator1 != null) {
            stack1.push(iterator1.getValue());
            iterator1 = iterator1.getNext();
        }

        var stack2 = new java.util.LinkedList<T>();
        var iterator2 = other.firstNode;
        while (iterator2 != null) {
            stack2.push(iterator2.getValue());
            iterator2 = iterator2.getNext();
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            var value1 = stack1.pop();
            var value2 = stack2.pop();
            if (value1 != value2)
                return new AbstractMap.SimpleImmutableEntry<>(value1, value2);
        }

        return null;
    }

    public Iterator<T> getIterator() {
        return new Iterator<>(firstNode);
    }
}

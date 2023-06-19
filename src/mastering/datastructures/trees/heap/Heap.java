package mastering.datastructures.trees.heap;

import mastering.datastructures.trees.binarytree.BinaryTreeArr;

public class Heap<T extends Comparable<T>> extends BinaryTreeArr<T> {
    public Heap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    public Heap(Class<T> clazz, int size, T[] elements) {
        super(clazz, size);

        for (T e : elements) {
            insert(e);
        }
    }

    public Heap(Class<T> clazz, T[] elements) {
        super(clazz, elements.length + 1);
        heapify(elements);
    }

    private void heapify(T[] elements) {
        var lastIndex = elements.length - 1;

        for (int i = lastIndex; i >= 0; i--) {
            if (indexIsLeaf(i, elements.length))
                continue;

            var currentIndex = i;

            do {
                var lChildIndex = calculateLChildPos(currentIndex);
                var rChildIndex = calculateRChildPos(currentIndex);

                var indexToCompare = lChildIndex;

                if (rChildIndex <= elements.length - 1 && elements[rChildIndex].compareTo(elements[lChildIndex]) > 0)
                    indexToCompare = rChildIndex;

                if (elements[indexToCompare].compareTo(elements[currentIndex]) > 0) {
                    var aux = elements[currentIndex];
                    elements[currentIndex] = elements[indexToCompare];
                    elements[indexToCompare] = aux;

                    currentIndex = indexToCompare;
                } else {
                    break;
                }
            } while (!indexIsLeaf(currentIndex, elements.length));
        }

        System.arraycopy(elements, 0, nodes, 0, elements.length);
    }

    private boolean indexIsLeaf(int index, int length) {
        var lChildIndex = calculateLChildPos(index);
        var rChildIndex = calculateRChildPos(index);

        return lChildIndex > length - 1 && rChildIndex > length - 1;
    }

    private int getAvailableIndex() {
        var index = 0;
        while (nodes[index] != null) index++;

        return index;
    }

    public void insert(T key) {
        var index = getAvailableIndex();

        nodes[index] = key;

        if (index == 0)
            return;

        var parentIndex = calculateParentPos(index);
        while (nodes[index].compareTo(nodes[parentIndex]) > 0) {
            var aux = nodes[parentIndex];
            nodes[parentIndex] = nodes[index];
            nodes[index] = aux;

            index = parentIndex;

            if (index == 0)
                break;

            parentIndex = calculateParentPos(index);
        }
    }

    public T delete() {
        var lastIndex = getAvailableIndex() - 1;

        var elementToBeDeleted = nodes[0];

        nodes[0] = nodes[lastIndex];
        nodes[lastIndex] = null;

        var currentIndex = 0;
        var childIndex = calculateLChildPos(currentIndex);

        while ((childIndex + 1) < lastIndex) {
            if (nodes[childIndex + 1].compareTo(nodes[childIndex]) > 0) {
                childIndex = childIndex + 1;
            }

            if (nodes[childIndex].compareTo(nodes[currentIndex]) > 0) {
                var aux = nodes[currentIndex];
                nodes[currentIndex] = nodes[childIndex];
                nodes[childIndex] = aux;

                currentIndex = childIndex;
                childIndex = calculateLChildPos(currentIndex);
            } else {
                break;
            }
        }

        return elementToBeDeleted;
    }

    public boolean isEmpty() {
        return nodes[0] == null;
    }
}

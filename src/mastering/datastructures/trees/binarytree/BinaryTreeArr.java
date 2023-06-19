package mastering.datastructures.trees.binarytree;

import java.lang.reflect.Array;

public class BinaryTreeArr<T extends Comparable<T>> {
    protected final T[] nodes;

    public BinaryTreeArr(Class<T> clazz, int size) {
        this.nodes = (T[]) Array.newInstance(clazz, size);
    }

    protected int calculateLChildPos(int index) {
        return ((index + 1) * 2) - 1;
    }

    protected int calculateRChildPos(int index) {
        return (index + 1) * 2;
    }

    protected int calculateParentPos(int childIndex) {
        return ((childIndex + 1) / 2) - 1;
    }

    public void addNode(T parentLabel, T lChildLabel, T rChildLabel) {
        if (nodes[0] == null) {
            nodes[0] = parentLabel;
            nodes[1] = lChildLabel;
            nodes[2] = rChildLabel;
            return;
        }

        int i = 0;
        while (!nodes[i].equals(parentLabel)) i++;

        nodes[calculateLChildPos(i)] = lChildLabel;
        nodes[calculateRChildPos(i)] = rChildLabel;
    }

    public void display() {
        for (int i = 0; i < nodes.length; i++) {
            final var lChildPos = calculateLChildPos(i);
            final var rChildPos = calculateRChildPos(i);

            if (lChildPos >= nodes.length || rChildPos >= nodes.length)
                break;

            var parent = nodes[i];
            var lChild = nodes[lChildPos];
            var rChild = nodes[rChildPos];

            if (lChild != null && rChild != null)
                System.out.println("parent (" + parent + "): leftChild(" + lChild + ") - rightChild(" + rChild + ")");
            else
                break;
        }
    }
}

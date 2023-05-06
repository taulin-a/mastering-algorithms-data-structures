package mastering.datastructures.trees;

import mastering.datastructures.queue.Queue;
import mastering.datastructures.stack.Stack;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryNode<T> root;
    private final Queue<BinaryNode<T>> traversalQueue;

    public BinaryTree() {
        traversalQueue = new Queue<>();
    }

    public void add(T element) {
        var newNode = new BinaryNode<>(element);
        if (root == null) {
            root = newNode;
            traversalQueue.enqueue(newNode);
            return;
        }

        var currentNode = traversalQueue.first();

        if (currentNode.getLeft() == null) {
            currentNode.setLeft(newNode);
        } else if (currentNode.getRight() == null) {
            currentNode.setRight(newNode);
        }

        if (element != null)
            traversalQueue.enqueue(newNode);

        if (currentNode.getLeft() != null && currentNode.getRight() != null)
            traversalQueue.dequeue();
    }

    public void display() {
        display(TraversalType.PREORDER);
    }

    public void display(TraversalType traversalType) {
        switch (traversalType) {
            case INORDER:
                displayRecursiveInOrder(root);
                break;
            case PREORDER:
                displayRecursivePreOrder(root);
                break;
            case POSTORDER:
                displayRecursivePostOrder(root);
                break;
        }
    }

    private void displayRecursivePreOrder(BinaryNode<T> node) {
        if (node == null)
            return;

        if (node.getData() != null)
            System.out.print(node.getData() + ",");

        displayRecursivePreOrder(node.getLeft());
        displayRecursivePreOrder(node.getRight());
    }

    private void displayRecursiveInOrder(BinaryNode<T> node) {
        if (node == null)
            return;

        displayRecursiveInOrder(node.getLeft());

        if (node.getData() != null)
            System.out.print(node.getData() + ",");

        displayRecursiveInOrder(node.getRight());
    }

    private void displayRecursivePostOrder(BinaryNode<T> node) {
        if (node == null)
            return;

        displayRecursiveInOrder(node.getLeft());
        displayRecursiveInOrder(node.getRight());

        if (node.getData() != null)
            System.out.print(node.getData() + ",");
    }

    public void displayPreOrder() {
        System.out.print("\n");

        var iterationStack = new Stack<BinaryNode<T>>();
        var currentNode = root;

        do {
            if (currentNode == null || currentNode.getData() == null) {
                var parent = iterationStack.pop();
                currentNode = parent != null
                        ? parent.getRight()
                        : null;
                continue;
            }

            System.out.print(currentNode.getData() + ",");

            iterationStack.push(currentNode);

            currentNode = currentNode.getLeft();
        } while (currentNode != null || !iterationStack.isEmpty());
    }

    public void displayInOrder() {
        System.out.print("\n");

        var iterationStack = new Stack<BinaryNode<T>>();
        var currentNode = root;

        do {
            if (currentNode == null || currentNode.getData() == null) {
                var parent = iterationStack.pop();

                if (parent != null) {
                    System.out.print(parent.getData() + ",");

                    currentNode = parent.getRight();
                } else {
                    currentNode = null;
                }

                continue;
            }

            iterationStack.push(currentNode);

            currentNode = currentNode.getLeft();
        } while (currentNode != null || !iterationStack.isEmpty());
    }

    public void displayPostOrder() {
        System.out.print("\n");

        var iterationStack = new Stack<BinaryNode<T>>();
        var currentNode = root;

        do {
            if (currentNode == null || currentNode.getData() == null) {
                var parent = iterationStack.pop();

                if (parent != null) {
                    if (parent instanceof PrintableNode) {
                        ((PrintableNode<T>) parent).print();
                        currentNode = null;
                    } else {
                        iterationStack.push(new PrintableNode<>(parent));
                        currentNode = parent.getRight();
                    }
                } else {
                    currentNode = null;
                }

                continue;
            }

            iterationStack.push(currentNode);

            currentNode = currentNode.getLeft();
        } while (currentNode != null || !iterationStack.isEmpty());
    }

    public void displayLevelOrder() {
        System.out.print("\n");

        var iterationQueue = new Queue<BinaryNode<T>>();
        iterationQueue.enqueue(root);

        while (!iterationQueue.isEmpty()) {
            var currentNode = iterationQueue.dequeue();

            if (currentNode.getData() != null)
                System.out.print(currentNode.getData() + ",");

            if (currentNode.getLeft() != null)
                iterationQueue.enqueue(currentNode.getLeft());

            if (currentNode.getRight() != null)
                iterationQueue.enqueue(currentNode.getRight());
        }
    }

    public int getCount() {
        return count(root);
    }

    private int count(BinaryNode<T> node) {
        if (node != null && node.getData() != null) {
            var x = count(node.getLeft());
            var y = count(node.getRight());
            return x + y + 1;
        }

        return 0;
    }

    public int getLeafCount() {
        return countLeafs(root);
    }

    private int countLeafs(BinaryNode<T> node) {
        if (node != null && node.getData() != null) {
            var x = countLeafs(node.getLeft());
            var y = countLeafs(node.getRight());

            if (node.getLeft() == null && node.getRight() == null)
                return x + y + 1;
            else
                return x + y;
        }

        return 0;
    }

    public int getHeight() {
        return countHeight(root);
    }

    private int countHeight(BinaryNode<T> node) {
        if (node != null && node.getData() != null) {
            var x = countHeight(node.getLeft());
            var y = countHeight(node.getRight());

            if (x > y)
                return x + 1;
            else
                return y + 1;
        }

        return 0;
    }

    public int getNodesDegreeTwoCount() {
        return countDegreeTwo(root);
    }

    private int countDegreeTwo(BinaryNode<T> node) {
        if (node != null && node.getData() != null) {
            var x = countDegreeTwo(node.getLeft());
            var y = countDegreeTwo(node.getRight());

            if ((node.getLeft() != null && node.getLeft().getData() != null)
                    && (node.getRight() != null && node.getRight().getData() != null))
                return x + y + 1;
            else
                return x + y;
        }

        return 0;
    }

    public int getNodesDegreeOneCount() {
        return countDegreeOne(root);
    }

    private int countDegreeOne(BinaryNode<T> node) {
        if (node != null && node.getData() != null) {
            var x = countDegreeOne(node.getLeft());
            var y = countDegreeOne(node.getRight());

            if (((node.getLeft() != null && node.getLeft().getData() != null) && (node.getRight() == null || node.getRight().getData() == null))
                    || ((node.getLeft() == null || node.getLeft().getData() == null) && (node.getRight() != null && node.getRight().getData() != null)))
                return x + y + 1;
            else
                return x + y;
        }

        return 0;
    }
}

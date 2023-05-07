package mastering.datastructures.trees.binarysearchtree;

import mastering.datastructures.trees.BinaryNode;
import mastering.datastructures.trees.TraversalType;
import mastering.datastructures.trees.binarytree.BinaryTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    private static final String SEPARTOR = ",";

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(TraversalType traversalType, String preorderStr, final Class<T> clazz) {
        if (traversalType == TraversalType.INORDER)
            throw new UnsupportedOperationException();

        var preorderList = Arrays.stream(preorderStr.split(SEPARTOR))
                .map(str -> strValueToType(str, clazz))
                .collect(Collectors.toList());

        if (traversalType == TraversalType.POSTORDER)
            Collections.reverse(preorderList);

        root = new BinaryNode<>(preorderList.get(0));

        var iterator = root;
        var iterationStack = new Stack<BinaryNode<T>>();

        var pos = 1;
        while (pos < preorderList.size()) {
            var currentValue = preorderList.get(pos);

            if (currentValue.compareTo(iterator.getData()) < 0) {
                iterator.setLeft(new BinaryNode<>(currentValue));
                iterationStack.push(iterator);
                iterator = iterator.getLeft();
                pos++;
            } else if (currentValue.compareTo(iterator.getData()) > 0) {
                if (!iterationStack.isEmpty() && currentValue.compareTo(iterationStack.peek().getData()) >= 0) {
                    iterator = iterationStack.pop();
                }

                iterator.setRight(new BinaryNode<>(currentValue));
                iterator = iterator.getRight();
                pos++;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private T strValueToType(String input, Class<T> clazz) {
        if (clazz.isAssignableFrom(String.class)) {
            return (T) input;
        } else if (clazz.isAssignableFrom(Integer.class)) {
            return (T) Integer.valueOf(input);
        } else if (clazz.isAssignableFrom(Boolean.class)) {
            return (T) Boolean.valueOf(input);
        } else if (clazz.isAssignableFrom(Double.class)) {
            return (T) Double.valueOf(input);
        } else {
            throw new IllegalArgumentException("Bad type.");
        }
    }

    public T recursiveSearch(T data) {
        return recursiveSearch(root, data);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void add(T element) {
        var newNode = new BinaryNode<>(element);

        if (root == null) {
            root = newNode;
            return;
        }

        BinaryNode<T> previous = null;
        var iterator = root;
        while (iterator != null && iterator.getData() != null) {
            previous = iterator;
            if (iterator.getData().compareTo(element) == 0) {
                return;
            } else if (element.compareTo(iterator.getData()) < 0) {
                iterator = iterator.getLeft();
            } else {
                iterator = iterator.getRight();
            }
        }

        if (element.compareTo(previous.getData()) < 0) {
            previous.setLeft(newNode);
        } else {
            previous.setRight(newNode);
        }
    }

    public void addRecursive(T element) {
        if (root == null) {
            root = addRecursive(null, element);
        } else {
            addRecursive(root, element);
        }
    }

    private BinaryNode<T> addRecursive(BinaryNode<T> node, T element) {
        if (node == null) {
            return new BinaryNode<>(element);
        }

        if (element.compareTo(node.getData()) < 0) {
            node.setLeft(addRecursive(node.getLeft(), element));
        } else if (element.compareTo(node.getData()) > 0) {
            node.setRight(addRecursive(node.getRight(), element));
        }

        return node;
    }

    public void delete(T element) {
        delete(root, element);
    }

    public BinaryNode<T> delete(BinaryNode<T> node, T element) {
        if (node == null)
            return null;

        if (node.getRight() == null && node.getLeft() == null) {
            if (node == root) root = null;
            return null;
        }

        if (element.compareTo(node.getData()) < 0) {
            node.setLeft(delete(node.getLeft(), element));
        } else if (element.compareTo(node.getData()) > 0) {
            node.setRight(delete(node.getRight(), element));
        } else {
            if (countHeight(node.getLeft()) > countHeight(node.getRight())) {
                var aux = findInOrderPredecessor(node.getLeft());
                node.setData(aux.getData());
                node.setLeft(delete(node.getLeft(), aux.getData()));
            } else {
                var aux = findInOrderSuccessor(node.getRight());
                node.setData(aux.getData());
                node.setRight(delete(node.getRight(), aux.getData()));
            }
        }

        return node;
    }

    private BinaryNode<T> findInOrderPredecessor(BinaryNode<T> node) {
        while (node != null && node.getRight() != null)
            node = node.getRight();

        return node;
    }

    private BinaryNode<T> findInOrderSuccessor(BinaryNode<T> node) {
        while (node != null && node.getLeft() != null)
            node = node.getLeft();

        return node;
    }

    private T recursiveSearch(BinaryNode<T> node, T data) {
        if (node == null || node.getData() == null)
            return null;

        if (node.getData().compareTo(data) == 0) {
            return node.getData();
        } else if (data.compareTo(node.getData()) < 0) {
            return recursiveSearch(node.getLeft(), data);
        } else {
            return recursiveSearch(node.getRight(), data);
        }
    }

    public T search(T data) {
        var iterator = root;
        while (iterator != null && iterator.getData() != null) {
            if (iterator.getData().compareTo(data) == 0) {
                return iterator.getData();
            } else if (data.compareTo(iterator.getData()) < 0) {
                iterator = iterator.getLeft();
            } else {
                iterator = iterator.getRight();
            }
        }

        return null;
    }
}

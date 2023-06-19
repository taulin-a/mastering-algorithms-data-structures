package mastering.datastructures.trees.avltree;

import mastering.datastructures.trees.BinaryNode;
import mastering.datastructures.trees.binarysearchtree.BinarySearchTree;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    @Override
    public void add(T element) {
        super.add(element);
    }

    @Override
    protected int countHeight(BinaryNode<T> node) {
        var bNode = (BalancedBinaryNode<T>) node;

        var heightLeft = getHeightLeft(bNode);
        var heightRight = getHeightRight(bNode);

        return heightLeft > heightRight ? heightLeft + 1 : heightRight + 1;
    }

    private int getHeightLeft(BalancedBinaryNode<T> bNode) {
        return bNode != null && bNode.getLeft() != null && bNode.getLeft().getData() != null
                ? bNode.getLeft().getHeight()
                : 0;
    }

    private int getHeightRight(BalancedBinaryNode<T> bNode) {
        return bNode != null && bNode.getRight() != null && bNode.getRight().getData() != null
                ? bNode.getRight().getHeight()
                : 0;
    }

    protected int calculateBalanceFactor(BalancedBinaryNode<T> bNode) {
        var heightLeft = getHeightLeft(bNode);
        var heightRight = getHeightRight(bNode);

        return heightLeft - heightRight;
    }

    @Override
    protected BinaryNode<T> addRecursive(BinaryNode<T> node, T element) {
        var bNode = (BalancedBinaryNode<T>) node;

        if (bNode == null) {
            return new BalancedBinaryNode<>(element);
        }

        if (element.compareTo(bNode.getData()) < 0) {
            bNode.setLeft(addRecursive(bNode.getLeft(), element));
        } else if (element.compareTo(bNode.getData()) > 0) {
            bNode.setRight(addRecursive(bNode.getRight(), element));
        }

        bNode.setHeight(countHeight(bNode));

        var balanceFactor = calculateBalanceFactor(bNode);

        if (balanceFactor == 2 && calculateBalanceFactor(bNode.getLeft()) == 1) {
            return LLRotate(bNode);
        } else if (balanceFactor == 2 && calculateBalanceFactor(bNode.getLeft()) == -1) {
            return LRRotate(bNode);
        } else if (balanceFactor == -2 && calculateBalanceFactor(bNode.getRight()) == -1) {
            return RRRotate(bNode);
        } else if (balanceFactor == -2 && calculateBalanceFactor(bNode.getRight()) == 1) {
            return RLRotate(bNode);
        }

        return node;
    }

    protected BalancedBinaryNode<T> LLRotate(BalancedBinaryNode<T> bNode) {
        var leftNode = bNode.getLeft();
        var leftNodeRightChild = leftNode.getRight();

        leftNode.setRight(bNode);
        bNode.setLeft(leftNodeRightChild);

        bNode.setHeight(countHeight(bNode));
        leftNode.setHeight(countHeight(leftNode));

        if (root == bNode)
            root = leftNode;

        return leftNode;
    }

    protected BalancedBinaryNode<T> LRRotate(BalancedBinaryNode<T> bNode) {
        var leftNode = bNode.getLeft();
        var leftNodeRightChild = leftNode.getRight();

        leftNode.setRight(leftNodeRightChild.getLeft());

        bNode.setLeft(leftNodeRightChild.getRight());

        leftNodeRightChild.setLeft(leftNode);
        leftNodeRightChild.setRight(bNode);

        leftNode.setHeight(countHeight(leftNode));
        bNode.setHeight(countHeight(bNode));
        leftNodeRightChild.setHeight(countHeight(leftNodeRightChild));

        if (bNode == root)
            root = leftNodeRightChild;

        return leftNodeRightChild;
    }

    protected BalancedBinaryNode<T> RRRotate(BalancedBinaryNode<T> bNode) {
        var rightNode = bNode.getRight();
        var rightNodeLeftChild = rightNode.getLeft();

        rightNode.setLeft(bNode);
        bNode.setRight(rightNodeLeftChild);

        bNode.setHeight(countHeight(bNode));
        rightNode.setHeight(countHeight(rightNode));

        if (root == bNode)
            root = rightNode;

        return rightNode;
    }

    protected BalancedBinaryNode<T> RLRotate(BalancedBinaryNode<T> bNode) {
        var rightNode = bNode.getRight();
        var rightNodeLeftChild = rightNode.getLeft();

        rightNode.setLeft(rightNodeLeftChild.getRight());

        bNode.setRight(rightNodeLeftChild.getLeft());

        rightNodeLeftChild.setRight(rightNode);
        rightNodeLeftChild.setLeft(bNode);

        rightNode.setHeight(countHeight(rightNode));
        bNode.setHeight(countHeight(bNode));
        rightNodeLeftChild.setHeight(countHeight(rightNodeLeftChild));

        if (bNode == root)
            root = rightNodeLeftChild;

        return rightNodeLeftChild;
    }

    @Override
    protected BinaryNode<T> delete(BinaryNode<T> node, T element) {
        if (node == null || node.getData() == null)
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
            BinaryNode<T> aux;
            T data;
            if (countHeight(node.getLeft()) >= countHeight(node.getRight())) {
                aux = findInOrderPredecessor(node.getLeft());
                data = aux != null ? aux.getData() : null;
                node.setData(data);
                node.setLeft(delete(node.getLeft(), data));
            } else {
                aux = findInOrderSuccessor(node.getRight());
                data = aux != null ? aux.getData() : null;
                node.setData(data);
                node.setRight(delete(node.getRight(), data));
            }
        }

        var bNode = (BalancedBinaryNode<T>) node;

        bNode.setHeight(countHeight(bNode));

        var balanceFactor = calculateBalanceFactor(bNode);
        
        if (balanceFactor == 2 && calculateBalanceFactor(bNode.getLeft()) == 1) { // L1
            return LLRotate(bNode);
        } else if (balanceFactor == 2 && calculateBalanceFactor(bNode.getLeft()) == -1) { // L-1
            return LRRotate(bNode);
        } else if (balanceFactor == 2 && calculateBalanceFactor(bNode.getLeft()) == 0) { // L0
            return LLRotate(bNode);
        } else if (balanceFactor == -2 && calculateBalanceFactor(bNode.getRight()) == -1) { // R1
            return RRRotate(bNode);
        } else if (balanceFactor == -2 && calculateBalanceFactor(bNode.getRight()) == 1) { // R-1
            return RLRotate(bNode);
        } else if (balanceFactor == -2 && calculateBalanceFactor(bNode.getRight()) == 0) { // R0
            return RRRotate(bNode);
        }

        return node;
    }
}

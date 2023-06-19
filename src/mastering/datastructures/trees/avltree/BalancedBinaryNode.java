package mastering.datastructures.trees.avltree;

import mastering.datastructures.trees.BinaryNode;

public class BalancedBinaryNode<T> extends BinaryNode<T> {
    private int height;

    public BalancedBinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        super(data, left, right);
        height = 1;
    }

    public BalancedBinaryNode(T data) {
        super(data);
        height = 1;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLeft(BalancedBinaryNode<T> left) {
        super.setLeft(left);
    }

    @Override
    public BalancedBinaryNode<T> getLeft() {
        return (BalancedBinaryNode<T>) super.getLeft();
    }

    public void setRight(BalancedBinaryNode<T> right) {
        super.setRight(right);
    }

    @Override
    public BalancedBinaryNode<T> getRight() {
        return (BalancedBinaryNode<T>) super.getRight();
    }
}

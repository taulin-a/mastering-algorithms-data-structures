package mastering.datastructures.trees.twothreetree;

public class TwoThreeNode<T extends Comparable<T>> {
    private TwoThreeNode<T> parent;
    private T firstKey;
    private T secondKey;
    private TwoThreeNode<T> left;
    private TwoThreeNode<T> middle;
    private TwoThreeNode<T> right;

    public TwoThreeNode(T firstKey) {
        this.firstKey = firstKey;
    }

    public TwoThreeNode(T firstKey, T secondKey) {
        this.firstKey = firstKey;
        this.secondKey = secondKey;
    }

    public TwoThreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TwoThreeNode<T> parent) {
        this.parent = parent;
    }

    public T getFirstKey() {
        return firstKey;
    }

    public void setFirstKey(T firstKey) {
        this.firstKey = firstKey;
    }

    public T getSecondKey() {
        return secondKey;
    }

    public void setSecondKey(T secondKey) {
        this.secondKey = secondKey;
    }

    public TwoThreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TwoThreeNode<T> left) {
        this.left = left;
    }

    public TwoThreeNode<T> getMiddle() {
        return middle;
    }

    public void setMiddle(TwoThreeNode<T> middle) {
        this.middle = middle;
    }

    public TwoThreeNode<T> getRight() {
        return right;
    }

    public void setRight(TwoThreeNode<T> right) {
        this.right = right;
    }
}

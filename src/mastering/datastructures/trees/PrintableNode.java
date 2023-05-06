package mastering.datastructures.trees;

/**
 * Decorator para classe BinaryNode que permite distinguir quando nó deve ser printado
 */
public class PrintableNode<T> extends BinaryNode<T> {
    public PrintableNode(BinaryNode<T> node) {
        super(node.getData(), node.getLeft(), node.getRight());
    }

    public void print() {
        System.out.print(getData() + ",");
    }
}

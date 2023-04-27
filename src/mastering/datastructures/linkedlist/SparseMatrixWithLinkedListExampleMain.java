package mastering.datastructures.linkedlist;

public class SparseMatrixWithLinkedListExampleMain {
    public static void main(String[] args) {
        LinkedList<MatrixColumn>[] arr = new LinkedList[5];
        arr[0] = new LinkedList<>();
        arr[0].append(new MatrixColumn(4, 8));

        arr[1] = new LinkedList<>();
        arr[1].append(new MatrixColumn(3, 7));

        arr[2] = new LinkedList<>();
        arr[2].append(new MatrixColumn(0, 5));
        arr[2].append(new MatrixColumn(4, 9));

        arr[3] = new LinkedList<>();
        arr[3].append(new MatrixColumn(5, 3));

        arr[4] = new LinkedList<>();
        arr[4].append(new MatrixColumn(0, 6));
        arr[4].append(new MatrixColumn(3, 4));

        var sparseMatrix = new SparseMatrixWithLinkedList(5, 6, arr);

        sparseMatrix.display();

        System.out.println("-------------");

        LinkedList<MatrixColumn>[] arr2 = new LinkedList[5];
        arr2[0] = new LinkedList<>();
        arr2[0].append(new MatrixColumn(4, 2));

        arr2[1] = new LinkedList<>();
        arr2[1].append(new MatrixColumn(2, 3));

        arr2[2] = new LinkedList<>();
        arr2[2].append(new MatrixColumn(0, 2));
        arr2[2].append(new MatrixColumn(5, 1));

        arr2[3] = new LinkedList<>();
        arr2[3].append(new MatrixColumn(3, 1));

        arr2[4] = new LinkedList<>();
        arr2[4].append(new MatrixColumn(0, 1));
        arr2[4].append(new MatrixColumn(1, 6));
        arr2[4].append(new MatrixColumn(3, 2));

        var sparseMatrix2 = new SparseMatrixWithLinkedList(5, 6, arr2);

        sparseMatrix2.display();

        System.out.println("-------------");

        var sparseMatrixSum = sparseMatrix.sum(sparseMatrix2);

        sparseMatrixSum.display();
    }
}

package mastering.datastructures.sparsematrix;

public class SparseMatrixExampleMain {
    public static void main(String[] args) {
        var matrix = new SparseMatrix3Row(new int[][]{
                {5, 0, 1, 2, 2, 4},
                {6, 3, 1, 1, 3, 0},
                {5, 6, 7, 2, 5, 4}
        });

        matrix.display();

        System.out.println("\n\n");

        var matrix2 = new SparseMatrix3Row(new int[][]{
                {5, 1, 1, 2, 2, 3, 4},
                {6, 1, 4, 2, 5, 3, 0},
                {6, 3, 5, 2, 7, 9, 8}
        });

        matrix2.display();

        System.out.println("\n\n");

        var matrix3 = matrix.sum(matrix2);

        matrix3.display();
    }
}

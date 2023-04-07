package mastering.datastructures.lowertrimatrix;

import mastering.datastructures.RepresentationType;

public class LowerTriangularMatrixExampleMain {
    public static void main(String[] args) {
        System.out.println("-------" + RepresentationType.ROW_MAJOR.name() + "-------");

        var matrix = new LowerTriangularMatrix(RepresentationType.ROW_MAJOR,
                11, 21, 22, 31, 32, 33, 41, 42, 43, 44, 51, 52, 53, 54, 55);

        System.out.println(matrix.get(3, 1));

        matrix.display();

        System.out.println("-------" + RepresentationType.COLUMN_MAJOR.name() + "-------");

        var matrix2 = new LowerTriangularMatrix(RepresentationType.COLUMN_MAJOR,
                11, 21, 31, 41, 51, 22, 32, 42, 52, 33, 43, 53, 44, 54, 55);

        System.out.println(matrix2.get(3, 3));

        matrix2.display();
    }
}

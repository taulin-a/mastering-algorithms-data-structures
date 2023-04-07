package mastering.datastructures.uppertrimatrix;

import mastering.datastructures.RepresentationType;

public class UpperTriangularMatrixExampleMain {
    public static void main(String[] args) {
        System.out.println("-----" + RepresentationType.ROW_MAJOR + "-----");

        var matrix = new UpperTriangularMatrix(RepresentationType.ROW_MAJOR,
                11, 12, 13, 14, 15, 22, 23, 24, 25, 33, 34, 35, 44, 45, 55);

        matrix.display();

        System.out.println("-----" + RepresentationType.COLUMN_MAJOR + "-----");

        var matrix2 = new UpperTriangularMatrix(RepresentationType.COLUMN_MAJOR,
                11, 12, 22, 13, 23, 33, 14, 24, 34, 44, 15, 25, 35, 45, 55);

        matrix2.display();
    }
}

package mastering.datastructures.symmectricmatrix;

import mastering.datastructures.RepresentationType;

public class SymmetricMatrixExampleMain {
    public static void main(String[] args) {
        var matrix = new SymmetricMatrix(RepresentationType.ROW_MAJOR,
                2, 2, 3, 2, 3, 4, 2, 3, 4, 5, 2, 3, 4, 5, 6);

        matrix.display();
    }
}

package mastering.datastructures.diagonalmatrix;

public class DiagonalMatrixExampleMain {
    public static void main(String[] args) {
        var diagonalMat = new DiagonalMatrix(1, 2, 3, 4, 5);
        diagonalMat.display();

        diagonalMat.set(1, 1, 5);

        System.out.println("-----");

        System.out.println(diagonalMat.get(2, 2));

        System.out.println("-----");

        diagonalMat.display();
    }
}

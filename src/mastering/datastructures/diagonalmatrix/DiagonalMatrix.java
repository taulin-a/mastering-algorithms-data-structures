package mastering.datastructures.diagonalmatrix;

public class DiagonalMatrix {
    private int[] elements;

    public DiagonalMatrix(int... elements) {
        this.elements = elements;
    }

    public void set(int row, int column, int value) {
        if (row == column)
            elements[row] = value;
    }

    public int get(int row, int column) {
        if (row == column)
            return elements[row];

        return 0;
    }

    public void display() {
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (i == j) {
                    System.out.print(elements[i] + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.print("\n");
        }
    }
}

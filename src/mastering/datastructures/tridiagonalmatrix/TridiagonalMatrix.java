package mastering.datastructures.tridiagonalmatrix;

public class TridiagonalMatrix {
    private final int dimension;
    private final int[] elements;

    public TridiagonalMatrix(int... elements) {
        dimension = (elements.length + 2) / 3;
        this.elements = elements;
    }

    public int get(int i, int j) {
        if (Math.abs(i - j) <= 1) {
            var actualIndex = calculateIndex(i, j);
            return elements[actualIndex];
        } else {
            return 0;
        }
    }

    public void set(int i, int j, int value) {
        if (Math.abs(i - j) <= 1) {
            var actualIndex = calculateIndex(i, j);
            elements[actualIndex] = value;
        }
    }

    private int calculateIndex(int i, int j) {
        if (i - j == 1) {
            return i - 1;
        } else if (i - j == 0) {
            return dimension - 1 + i - 1;
        } else {
            return 2 * dimension - 1 + i - 1;
        }
    }

    public void display() {
        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension; j++) {
                var value = get(i, j);
                System.out.print(value + (value == 0 ? "  " : " "));
            }
            System.out.print("\n");
        }
    }
}

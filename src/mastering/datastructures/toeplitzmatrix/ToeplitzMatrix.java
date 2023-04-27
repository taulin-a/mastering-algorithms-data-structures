package mastering.datastructures.toeplitzmatrix;

public class ToeplitzMatrix {
    private final int[] elements;
    private final int dimension;

    public ToeplitzMatrix(int... elements) {
        this.elements = elements;
        dimension = (elements.length + 1) / 2;
    }

    public int get(int i, int j) {
        var actualIndex = calculateIndex(i, j);
        return elements[actualIndex];
    }

    private int calculateIndex(int i, int j) {
        if (i <= j) {
            return j - i;
        } else {
            return dimension + i - j - 1;
        }
    }

    public void display() {
        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension; j++) {
                System.out.print(get(i, j) + "  ");
            }
            System.out.print("\n");
        }
    }
}

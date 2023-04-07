package mastering.datastructures.lowertrimatrix;

import mastering.datastructures.RepresentationType;

public class LowerTriangularMatrix {
    private final int[] elements;
    private final RepresentationType representationType;

    public LowerTriangularMatrix(RepresentationType representationType, int... elements) {
        this.representationType = representationType;
        this.elements = elements;
    }

    public void set(int row, int column, int value) {
        if (row < column)
            return;

        if (representationType == RepresentationType.ROW_MAJOR) {
            setRowMajor(row, column, value);
        } else {
            setColumnMajor(row, column, value);
        }
    }

    private void setRowMajor(int row, int column, int value) {
        var actualRow = calculateIndexRowMajor(row, column);
        elements[actualRow] = value;
    }

    private void setColumnMajor(int row, int column, int value) {
        var actualRow = calculateIndexColumnMajor(row, column);
        elements[actualRow] = value;
    }

    public int get(int row, int column) {
        if (row < column)
            return 0;

        return representationType == RepresentationType.ROW_MAJOR
                ? getRowMajor(row, column)
                : getColumnMajor(row, column);
    }

    private int getRowMajor(int row, int column) {
        var actualRow = calculateIndexRowMajor(row, column);
        return elements[actualRow];
    }

    private int getColumnMajor(int row, int column) {
        var actualRow = calculateIndexColumnMajor(row, column);
        return elements[actualRow];
    }

    private int calculateIndexRowMajor(int i, int j) {
        return i * (i - 1) / 2 + j - 1;
    }

    private int calculateIndexColumnMajor(int i, int j) {
        var n = getActualLength(elements.length);

        return n * (j - 1) - (j - 2) * (j - 1) / 2 + i - j;
    }

    private int getActualLength(int len) {
        return (int) Math.sqrt(2 * (len + 1));
    }

    public void display() {
        var len = getActualLength(elements.length);
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (i >= j) {
                    if (representationType == RepresentationType.ROW_MAJOR)
                        System.out.print(getRowMajor(i, j) + "  ");
                    else
                        System.out.print(getColumnMajor(i, j) + " ");
                } else {
                    System.out.print("0  ");
                }
            }
            System.out.print("\n");
        }
    }
}

package mastering.datastructures.linkedlist;

public class MatrixColumn {
    private int column;
    private int value;

    public MatrixColumn(int column, int value) {
        this.column = column;
        this.value = value;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

package mastering.datastructures.sparsematrix;

public class SparseMatrix3Row {
    private final int[][] representation;

    public SparseMatrix3Row(int[][] representation) {
        this.representation = representation;
    }

    public int getRows() {
        return representation[0][0];
    }

    public int getColumns() {
        return representation[1][0];
    }

    public int getNumOfElements() {
        return representation[2][0];
    }

    public int get(int i, int j) {
        var numOfElements = getNumOfElements();
        var column = 1;

        while (column <= numOfElements) {
            if (representation[0][column] == i && representation[1][column] == j) {
                return representation[2][column];
            } else if (representation[0][column] < i
                    || (representation[0][column] == i && representation[1][column] < j)) {
                column++;
            } else {
                return 0;
            }
        }

        return 0;
    }

    public int[][] getRepresentation() {
        return representation;
    }

    public void display() {
        var numOfRows = getRows();
        var numOfColumns = getColumns();

        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                var value = get(i, j);
                System.out.print(value + (String.valueOf(value).length() >= 2 ? " " : "  "));
            }
            System.out.print("\n");
        }
    }

    public SparseMatrix3Row sum(SparseMatrix3Row sm) {
        var newNumOfColumns = getNumOfElements() + sm.getNumOfElements();
        var newRep = new int[3][newNumOfColumns];

        newRep[0][0] = getRows();
        newRep[1][0] = getColumns();

        int i = 1, j = 1, k = 1;

        while (i <= getNumOfElements() && j <= sm.getNumOfElements()) {
            if (representation[0][i] == sm.getRepresentation()[0][j]
                    && representation[1][i] == sm.getRepresentation()[1][j]) {
                newRep[0][k] = representation[0][i];
                newRep[1][k] = representation[1][i];
                newRep[2][k] = representation[2][i] + sm.getRepresentation()[2][j];
                i++;
                j++;
                k++;
            } else if (representation[0][i] < sm.getRepresentation()[0][j]
                    || (representation[0][i] == sm.getRepresentation()[0][j]
                    && representation[1][i] < sm.getRepresentation()[1][j])) {
                newRep[0][k] = representation[0][i];
                newRep[1][k] = representation[1][i];
                newRep[2][k] = representation[2][i];
                i++;
                k++;
            } else {
                newRep[0][k] = sm.getRepresentation()[0][j];
                newRep[1][k] = sm.getRepresentation()[1][j];
                newRep[2][k] = sm.getRepresentation()[2][j];
                j++;
                k++;
            }
        }

        newRep[2][0] = k - 1;

        return new SparseMatrix3Row(newRep);
    }
}

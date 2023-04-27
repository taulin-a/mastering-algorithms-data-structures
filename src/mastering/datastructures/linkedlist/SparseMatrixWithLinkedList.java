package mastering.datastructures.linkedlist;

public class SparseMatrixWithLinkedList {
    private int nRows;
    private int nColumns;
    private final LinkedList<MatrixColumn>[] representation;

    public SparseMatrixWithLinkedList(int nRows, int nColumns, LinkedList<MatrixColumn>[] representation) {
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.representation = representation;
    }

    public void display() {
        for (int i = 0; i < nRows; i++) {
            var iterator = representation[i].getIterator();
            for (int j = 0; j < nColumns; j++) {
                if (j == iterator.getValue().getColumn()) {
                    var value = iterator.getValue().getValue();
                    System.out.print(value + (String.valueOf(value).length() >= 2 ? " " : "  "));
                    iterator.next();
                } else {
                    System.out.print("0  ");
                }
            }
            System.out.print("\n");
        }
    }

    public SparseMatrixWithLinkedList sum(SparseMatrixWithLinkedList sm) {
        LinkedList<MatrixColumn>[] newRep = new LinkedList[nRows];

        for (int i = 0; i < nRows; i++) {
            newRep[i] = new LinkedList<>();
            var iterator = representation[i].getIterator();
            var iterator2 = sm.representation[i].getIterator();
            for (int j = 0; j < nColumns; j++) {
                if (j == iterator.getValue().getColumn() && j == iterator2.getValue().getColumn()) {
                    var newValue = iterator.getValue().getValue() + iterator2.getValue().getValue();

                    newRep[i].append(new MatrixColumn(j, newValue));

                    iterator.next();
                    iterator2.next();
                } else if (j == iterator.getValue().getColumn()) {
                    newRep[i].append(new MatrixColumn(j, iterator.getValue().getValue()));
                    iterator.next();
                } else if (j == iterator2.getValue().getColumn()) {
                    newRep[i].append(new MatrixColumn(j, iterator2.getValue().getValue()));
                    iterator2.next();
                }
            }
        }

        return new SparseMatrixWithLinkedList(nRows, nColumns, newRep);
    }
}

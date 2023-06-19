package mastering.algorithms.sorting.insertion;

import mastering.algorithms.sorting.BaseSwapableMain;
import mastering.datastructures.linkedlist.LinkedList;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class InsertionSortExampleMain extends BaseSwapableMain {
    private static final int DEFAULT_VALUE = -999;

    public static void main(String[] args) throws OperationNotSupportedException {
        var unsortedArr = new int[]{8, 5, 7, 3, 2};
        unsortedArr = insertionSort(unsortedArr);

        System.out.println(Arrays.toString(unsortedArr));

        var unsortedArr2 = new int[]{8, 5, 7, 3, 2};
        var orderedList = insertionSortWithLinkedList(unsortedArr2);
        orderedList.display();

        var unsortedArr3 = new int[]{8, 5, 7, 3, 2};
        insertionSortSingleArr(unsortedArr3);
        System.out.println(Arrays.toString(unsortedArr3));
    }

    public static int[] insertionSort(int[] unsortedArr) {
        var orderedArr = new int[unsortedArr.length];
        Arrays.fill(orderedArr, DEFAULT_VALUE);

        for (int element : unsortedArr) {
            for (int j = 0; j < orderedArr.length; j++) {
                if (orderedArr[j] == DEFAULT_VALUE) {
                    orderedArr[j] = element;
                    break;
                } else if (element < orderedArr[j]) {
                    shiftArr(j, orderedArr);
                    orderedArr[j] = element;
                    break;
                }
            }
        }

        return orderedArr;
    }

    public static void shiftArr(int shiftIndex, int[] arr) {
        for (int i = arr.length - 1; i > shiftIndex; i--) {
            if ((i - 1) >= 0)
                arr[i] = arr[i - 1];
        }
    }

    public static LinkedList<Integer> insertionSortWithLinkedList(int[] unsortedArr) throws OperationNotSupportedException {
        var orderedList = new LinkedList<Integer>();

        for (int k : unsortedArr) {
            orderedList.insertSorted(k);
        }

        return orderedList;
    }

    public static void insertionSortSingleArr(int[] unsortedArr) {
        for (int i = 1; i < unsortedArr.length; i++) {
            var curr = unsortedArr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (unsortedArr[j] > curr) {
                    swap(j, j + 1, unsortedArr);
                }
            }
        }
    }
}

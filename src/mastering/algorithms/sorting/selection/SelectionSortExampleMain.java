package mastering.algorithms.sorting.selection;

import mastering.algorithms.sorting.BaseSwapableMain;

import java.util.Arrays;

public class SelectionSortExampleMain extends BaseSwapableMain {
    public static void main(String[] args) {
        var unsortedArr = new int[]{8, 6, 3, 2, 5, 4};
        selectionSort(unsortedArr);

        System.out.println(Arrays.toString(unsortedArr));
    }

    private static void selectionSort(int[] unsortedArr) {
        for (int i = 0; i < unsortedArr.length; i++) {

            int minIndex = i;
            for (int j = i + 1; j < unsortedArr.length; j++) {
                if (unsortedArr[j] < unsortedArr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(i, minIndex, unsortedArr);
        }
    }
}

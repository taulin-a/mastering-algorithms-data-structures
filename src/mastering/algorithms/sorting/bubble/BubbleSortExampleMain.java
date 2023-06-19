package mastering.algorithms.sorting.bubble;

import mastering.algorithms.sorting.BaseSwapableMain;

import java.util.Arrays;

public class BubbleSortExampleMain extends BaseSwapableMain {
    public static void main(String[] args) {
        var unsortedArr = new int[]{8, 5, 7, 3, 2};
        bubbleSort(unsortedArr);

        System.out.println(Arrays.toString(unsortedArr));
    }

    private static void bubbleSort(int[] unsortedArr) {
        boolean ordered = true;
        var limit = unsortedArr.length;

        while (limit > 0) {
            for (int i = 0; i < limit; i++) {
                if ((i + 1) < limit && unsortedArr[i] > unsortedArr[i + 1]) {
                    swap(i, i + 1, unsortedArr);
                    ordered = false;
                }
            }
            if (ordered) break;

            limit--;
        }
    }
}

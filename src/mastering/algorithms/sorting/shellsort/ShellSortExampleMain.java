package mastering.algorithms.sorting.shellsort;

import mastering.algorithms.sorting.BaseSwapableMain;

import java.util.Arrays;

public class ShellSortExampleMain extends BaseSwapableMain {
    public static void main(String[] args) {
        var unsortedArr = new int[]{9, 5, 16, 8, 13, 6, 12, 10, 4, 2, 3};
        shellSort(unsortedArr);

        System.out.println(Arrays.toString(unsortedArr));
    }

    private static void shellSort(int[] unsortedArr) {
        var gap = unsortedArr.length;

        do {
            gap /= 2;

            var i = 0;
            var j = gap;

            while (j < unsortedArr.length) {
                var current = i;
                var afterGap = j;

                while (current >= 0 && unsortedArr[current] > unsortedArr[afterGap]) {
                    swap(current, afterGap, unsortedArr);
                    current -= gap;
                    afterGap -= gap;
                }

                i++;
                j++;
            }
        } while (gap != 1);
    }
}

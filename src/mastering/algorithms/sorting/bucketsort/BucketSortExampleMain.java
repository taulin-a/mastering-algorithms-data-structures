package mastering.algorithms.sorting.bucketsort;

import mastering.datastructures.queue.Queue;

import java.util.Arrays;
import java.util.Objects;

public class BucketSortExampleMain {
    public static void main(String[] args) {
        var unorderedArr = new int[]{6, 8, 3, 10, 15, 6, 9, 12, 6, 3};
        bucketSort(unorderedArr);

        System.out.println(Arrays.toString(unorderedArr));
    }

    @SuppressWarnings("unchecked")
    private static void bucketSort(int[] unorderedArr) {
        int max = unorderedArr[0];
        for (int i = 1; i < unorderedArr.length; i++) {
            if (unorderedArr[i] > max)
                max = unorderedArr[i];
        }

        var bucketArr = new Queue[max + 1];

        for (int n : unorderedArr) {
            if (Objects.isNull(bucketArr[n]))
                bucketArr[n] = new Queue<Integer>();

            bucketArr[n].enqueue(n);
        }

        int i = 0;
        for (Queue<Integer> bkt : bucketArr) {
            while (Objects.nonNull(bkt) && !bkt.isEmpty()) {
                unorderedArr[i++] = bkt.dequeue();
            }
        }
    }
}

package mastering.datastructures;

public class ArrayExampleMain {
    public static void main(String[] args) {
        var arr = new Array<>(new Integer[25], 25);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(4);
        arr.append(5);

        arr.insert(2, 1);

        arr.display();

        System.out.println("Deleted the element: " + arr.delete(3));

        arr.display();

        System.out.println("index of element 5: " + arr.linearSearch(5));

        System.out.println("index of element 4: " + arr.binarySearch(4));

        System.out.println("index of element 12: " + arr.binarySearch(12));

        System.out.println("index of element 5: " + arr.binarySearchRecursive(0, arr.getLength() - 1, 5));

        System.out.println("max element in array: " + arr.max());
        System.out.println("min element in array: " + arr.min());
        System.out.println("sum of elements in array: " + arr.sum());
        System.out.println("average of elements in array: " + arr.average());

        arr.reverseTransposition();

        arr.display();

        arr.leftShift();

        arr.display();

        arr.rightShift();
        arr.rightShift();

        arr.display();

        var arr2 = new Array<>(new Integer[25], 25);
        arr2.append(3);
        arr2.append(-3);
        arr2.append(1);
        arr2.append(-2);
        arr2.append(2);
        arr2.append(-1);
        arr2.append(0);

        arr2.display();

        arr2.sortNegativePositive();

        arr2.display();

        var arr3 = new Array<>(new Integer[25], 25);
        arr3.append(-1);
        arr3.append(0);
        arr3.append(1);
        arr3.append(3);
        arr3.append(4);

        arr3.display();

        arr3.insertOrdered(2);

        arr3.display();

        System.out.println("Is it sorted: " + (arr3.isSorted() ? "yes" : "no"));

        System.out.println("Is it sorted: " + (arr.isSorted() ? "yes" : "no"));

        var arr4 = new Array<>(new Integer[25], 25);
        arr4.append(3);
        arr4.append(8);
        arr4.append(16);
        arr4.append(20);
        arr4.append(25);

        var arr5 = new Array<>(new Integer[25], 25);
        arr5.append(4);
        arr5.append(10);
        arr5.append(12);
        arr5.append(22);
        arr5.append(23);

        arr4.display();
        arr5.display();

        arr4.merge(arr5);

        arr4.display();

        var arr6 = new Array<>(new Integer[5], 5);
        arr6.append(3);
        arr6.append(5);
        arr6.append(10);
        arr6.append(4);
        arr6.append(6);

        var arr7 = new Array<>(new Integer[5], 5);
        arr7.append(12);
        arr7.append(4);
        arr7.append(7);
        arr7.append(2);
        arr7.append(5);

        var unionArr2 = arr6.unionNonOrdered(arr7);
        unionArr2.display();

        var arr8 = new Array<>(new Integer[5], 5);
        arr8.append(3);
        arr8.append(4);
        arr8.append(5);
        arr8.append(6);
        arr8.append(10);

        var arr9 = new Array<>(new Integer[5], 5);
        arr9.append(2);
        arr9.append(4);
        arr9.append(5);
        arr9.append(7);
        arr9.append(12);

        var unionArr3 = arr8.unionOrdered(arr9);
        unionArr3.display();

        var arr10 = new Array<>(new Integer[5], 5);
        arr10.append(3);
        arr10.append(5);
        arr10.append(10);
        arr10.append(4);
        arr10.append(6);

        var arr11 = new Array<>(new Integer[5], 5);
        arr11.append(12);
        arr11.append(4);
        arr11.append(7);
        arr11.append(2);
        arr11.append(5);

        var unionArr4 = arr10.intersection(arr11);
        unionArr4.display();

        var arr12 = new Array<>(new Integer[5], 5);
        arr12.append(3);
        arr12.append(4);
        arr12.append(5);
        arr12.append(6);
        arr12.append(10);

        var arr13 = new Array<>(new Integer[5], 5);
        arr13.append(2);
        arr13.append(4);
        arr13.append(5);
        arr13.append(7);
        arr13.append(12);

        var unionArr5 = arr12.intersectionOrdered(arr13);
        unionArr5.display();
    }
}

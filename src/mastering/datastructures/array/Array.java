package mastering.datastructures.array;

import java.util.Arrays;

public class Array<T extends Number> {
    private T[] elements;
    private int size;
    private int length;

    public Array(T[] elements, int size) {
        this.elements = elements;
        this.size = size;
        this.length = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print("  " + elements[i]);

            if (i != (length - 1))
                System.out.print(", ");
        }

        System.out.println(" ]");
    }

    public boolean append(T element) {
        if (elements == null || length >= elements.length)
            return false;

        elements[length] = element;
        length++;
        return true;
    }

    public boolean insert(T element, int index) {
        if (elements == null || length >= elements.length || index < 0 || index >= elements.length)
            return false;

        for (int i = length; i > index; i--)
            elements[i] = elements[i - 1];

        elements[index] = element;
        length++;

        return true;
    }

    public T delete(int index) {
        if (elements == null || length >= elements.length || index < 0 || index >= elements.length)
            return null;

        var aux = elements[index];
        elements[index] = null;

        for (int i = index; i < (length - 1); i++)
            elements[i] = elements[i + 1];

        elements[--length] = null;

        return aux;
    }

    public int linearSearch(T key) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(key))
                return i;
        }

        return -1;
    }

    /**
     * Tries to improve time of linear search by moving the found element forward each time
     * it is found
     *
     * @param key
     * @return
     */
    public int linearSearchTransposition(T key) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(key)) {
                if (i != 0) {
                    var aux = elements[i - 1];
                    elements[i - 1] = elements[i];
                    elements[i] = aux;
                    return i - 1;
                }

                return i;
            }
        }

        return -1;
    }

    /**
     * Tries to improve linear search time by moving found element to position 0 so that next time it
     * is searched the search will be performed in linear time O(1)
     *
     * @param key
     * @return
     */
    public int linearSearchHead(T key) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(key)) {
                if (i != 0) {
                    var aux = elements[0];
                    elements[0] = elements[i];
                    elements[i] = aux;
                    return 0;
                }

                return i;
            }
        }

        return -1;
    }

    public int binarySearch(T element) {
        var low = 0;
        var high = length - 1;
        var middle = (int) Math.floor((low + high) / 2d);

        do {
            if (elements[middle].equals(element)) {
                return middle;
            } else if (element.intValue() > elements[middle].intValue()) {
                low = middle + 1;
                middle = (int) Math.floor((low + high) / 2d);
            } else {
                high = middle - 1;
                middle = (int) Math.floor((low + high) / 2d);
            }
        } while (low <= high);

        return -1;
    }

    public int binarySearchRecursive(int low, int high, T element) {
        if (low > high)
            return -1;

        var middle = (int) Math.floor((low + high) / 2d);

        if (elements[middle].equals(element)) {
            return middle;
        } else if (element.intValue() > elements[middle].intValue()) {
            return binarySearchRecursive(middle + 1, high, element);
        } else {
            return binarySearchRecursive(low, middle - 1, element);
        }
    }

    public T get(int index) {
        return (index < 0 || index >= length) ? null : elements[index];
    }

    public boolean set(int index, T element) {
        if (index <= 0 || index >= length)
            return false;

        elements[index] = element;

        return true;
    }

    public T max() {
        var max = elements[0];

        for (int i = 1; i < length; i++) {
            if (elements[i].intValue() > max.intValue())
                max = elements[i];
        }

        return max;
    }

    public T min() {
        var min = elements[0];

        for (int i = 1; i < length; i++) {
            if (elements[i].intValue() < min.intValue())
                min = elements[i];
        }

        return min;
    }

    public int sum() {
        var total = 0;
        for (int i = 0; i < length; i++)
            total += elements[i].intValue();

        return total;
    }

    public float average() {
        return sum() / ((float) length);
    }

    public void reverseAux() {
        var aux = elements.clone();

        for (int i = length - 1, j = 0; i >= 0; i--, j++) {
            aux[j] = elements[i];
        }

        elements = aux;
    }

    public void reverseTransposition() {
        T aux;
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            aux = elements[i];
            elements[i] = elements[j];
            elements[j] = aux;
        }
    }

    public void leftShift() {
        T aux = null;
        for (int i = 0; i < length; i++) {
            if ((i - 1) < 0) {
                aux = elements[i];
                continue;
            }

            elements[i - 1] = elements[i];
        }

        elements[length - 1] = aux;
    }

    public void rightShift() {
        T aux = null;
        for (int i = length - 1; i >= 0; i--) {
            if ((i + 1) == length) {
                aux = elements[i];
                continue;
            }

            elements[i + 1] = elements[i];
        }

        elements[0] = aux;
    }

    public boolean insertOrdered(T element) {
        if (elements == null || length >= elements.length)
            return false;

        var i = length - 1;
        while (i >= 0 && elements[i].intValue() > element.intValue()) {
            elements[i + 1] = elements[i];
            i--;
        }

        elements[i + 1] = element;
        length++;

        return true;
    }

    public boolean isSorted() {
        for (int i = 0; i < length - 1; i++) {
            if (elements[i].intValue() > elements[i + 1].intValue())
                return false;
        }

        return true;
    }

    public void sortNegativePositive() {
        var i = 0;
        var j = length - 1;

        while (i < j) {
            while ((elements[i]).intValue() < 0) {
                i++;
            }

            while ((elements[j]).intValue() >= 0) {
                j--;
            }

            if (i < j) {
                var aux = elements[i];
                elements[i] = elements[j];
                elements[j] = aux;
            }
        }
    }

    public void merge(Array<T> array) {
        var i = 0;
        var j = 0;
        var k = 0;

        var newElements = new Number[length + array.getLength()];

        while (i < length && j < array.getLength()) {
            if (elements[i].intValue() < array.get(j).intValue()) {
                newElements[k++] = elements[i++];
            } else {
                newElements[k++] = array.get(j++);
            }
        }

        while (i < length) {
            newElements[k++] = elements[i++];
        }

        while (j < array.getLength()) {
            newElements[k++] = array.get(j++);
        }

        var newLength = length + array.getLength();
        elements = (T[]) newElements;
        length = newLength;
    }

    public Array<?> unionNonOrdered(Array<T> array) {
        var newLength = length + array.getLength();
        var newArray = new Array<>(new Number[newLength], newLength);

        for (int i = 0; i < length; i++) {
            newArray.append(elements[i]);
        }

        for (int j = 0; j < array.getLength(); j++) {
            if (newArray.linearSearch(array.get(j)) == -1)
                newArray.append(array.get(j));
        }

        return newArray;
    }

    public Array<?> unionOrdered(Array<T> array) {
        var newLength = length + array.getLength();
        var newArray = new Array<>(new Number[newLength], newLength);

        var i = 0;
        var j = 0;

        while (i < length && j < array.getLength()) {
            if (elements[i].intValue() < array.get(j).intValue()) {
                newArray.append(elements[i++]);
            } else if (elements[i].intValue() == array.get(j).intValue()) {
                newArray.append(elements[i++]);
                j++;
            } else {
                newArray.append(array.get(j++));
            }
        }

        while (i < length) {
            newArray.append(elements[i++]);
        }

        while (j < array.getLength()) {
            newArray.append(array.get(j++));
        }

        return newArray;
    }

    public Array<?> intersection(Array<T> array) {
        var newLength = length + array.getLength();
        var newArray = new Array<>(new Number[newLength], newLength);

        for (T element : elements) {
            if (array.linearSearch(element) != -1)
                newArray.append(element);
        }

        return newArray;
    }

    public Array<?> intersectionOrdered(Array<T> array) {
        var newLength = length + array.getLength();
        var newArray = new Array<>(new Number[newLength], newLength);

        var i = 0;
        var j = 0;

        while (i < length && j < array.getLength()) {
            if (elements[i].intValue() < array.get(j).intValue()) {
                i++;
            } else if (elements[i].intValue() == array.get(j).intValue()) {
                newArray.append(elements[i++]);
                j++;
            } else {
                j++;
            }
        }

        return newArray;
    }

    public Array<?> difference(Array<T> array) {
        var newLength = length + array.getLength();
        var newArray = new Array<>(new Number[newLength], newLength);

        for (T element : elements) {
            if (array.linearSearch(element) == -1)
                newArray.append(element);
        }

        return newArray;
    }

    public Array<?> differenceOrdered(Array<T> array) {
        var newLength = length + array.getLength();
        var newArray = new Array<>(new Number[newLength], newLength);

        var i = 0;
        var j = 0;

        while (i < length && j < array.getLength()) {
            if (elements[i].intValue() < array.get(j).intValue()) {
                newArray.append(elements[i++]);
            } else if (elements[i].intValue() == array.get(j).intValue()) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        while (i < length) {
            newArray.append(elements[i++]);
        }

        return newArray;
    }

    public void findMissingElementStartsFromOne() {
        var n = elements[length - 1].intValue();
        var expectedValue = (n * (n + 1)) / 2;
        var sum = sum();

        if (sum != expectedValue)
            System.out.println("Missing element found: " + (expectedValue - sum));
        else
            System.out.println("There are no missing elements");
    }

    public void findMissingElementUnorderedStartsFromAny() {
        var diff = elements[0].intValue();

        for (int i = 0; i < length; i++) {
            if ((elements[i].intValue() - i) != diff) {
                System.out.println("Missing element found: " + (i + diff));
                return;
            }
        }

        System.out.println("There are no missing elements");
    }

    public void findMultipleMissingElements() {
        var diff = elements[0].intValue();

        for (int i = 0; i < length; i++) {
            if ((elements[i].intValue() - i) != diff) {
                while (diff < elements[i].intValue() - i) {
                    System.out.println("Missing element found: " + (i + diff));
                    diff++;
                }
            }
        }

        System.out.println("There are no more missing elements");
    }

    public void findMissingElementsUnordered() {
        var l = min().intValue();
        var h = max().intValue() + 1;

        var bitset = new Integer[h];
        Arrays.fill(bitset, 0);

        for (T element : elements) {
            bitset[element.intValue()]++;
        }

        for (int i = l; i < h; i++) {
            if (bitset[i] == 0) {
                System.out.println("Missing element found: " + i);
            }
        }

        System.out.println("There are no more missing elements");
    }

    public void findDuplicatesOrdered() {
        Integer lastDuplicate = null;

        for (int i = 0; i < (length - 1); i++) {
            if (elements[i].equals(elements[i + 1])
                    && (lastDuplicate == null || elements[i].intValue() != lastDuplicate)) {
                System.out.println("Duplicate element found: " + elements[i].intValue());
                lastDuplicate = elements[i].intValue();
            }
        }
    }

    public void findDuplicatesOrderedCount() {
        for (int i = 0; i < (length - 1); i++) {
            if (elements[i].equals(elements[i + 1])) {
                int j = i + 1;
                while (elements[j].equals(elements[i])) j++;

                System.out.println("Duplicate element found: " + elements[i].intValue() + " - " + (j - i) + " times");

                i += (j - i);
            }
        }
    }

    public void findDuplicatesHashing() {
        var l = min().intValue();
        var h = max().intValue() + 1;

        var bitset = new Integer[h];
        Arrays.fill(bitset, 0);

        for (T element : elements) {
            bitset[element.intValue()]++;
        }

        for (int i = l; i < h; i++) {
            if (bitset[i] > 1) {
                System.out.println("Duplicate element found: " + i + " - duplicated times: " + (bitset[i]));
            }
        }

        System.out.println("There are no more duplicate elements");
    }

    public void findDuplicatesUnsorted() {
        var auxArray = elements.clone();

        for (int i = 0; i < (length - 1); i++) {
            if (auxArray[i] == null)
                continue;

            var count = 1;
            for (int j = i + 1; j < length; j++) {
                if (auxArray[i].equals(auxArray[j])) {
                    count++;
                    auxArray[j] = null;
                }
            }

            if (count > 1) {
                System.out.println("Duplicate element found: " + auxArray[i] + " - duplicated times: " + count);
            }
        }
    }

    public void findPair(int sum) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (elements[i].intValue() + elements[j].intValue() == sum)
                    System.out.println("Pair found: " + elements[i].intValue() + " + " + elements[j].intValue()
                            + " = " + sum);
            }
        }
    }

    public void findPairHashing(int sum) {
        var l = min().intValue();
        var h = max().intValue() + 1;

        var bitset = new Integer[h];
        Arrays.fill(bitset, 0);

        for (T element : elements) {
            var rest = sum - element.intValue();
            if (rest >= l && rest < h && bitset[rest] >= 1) {
                System.out.println("Pair found: " + element.intValue() + " + " + rest
                        + " = " + sum);
            }
            bitset[element.intValue()]++;
        }
    }

    public void findPairSorted(int sum) {
        int i = 0, j = length - 1;
        while (i < j) {
            var result = elements[i].intValue() + elements[j].intValue();
            if (result < sum) {
                i++;
            } else if (result > sum) {
                j--;
            } else {
                System.out.println("Pair found: " + elements[i] + " + " + elements[j]
                        + " = " + sum);
                i++;
                j--;
            }
        }
    }

    public void findMinAndMax() {
        int min, max;
        min = max = elements[0].intValue();

        for (int i = 1; i < length; i++) {
            if (elements[i].intValue() < min) {
                min = elements[i].intValue();
            } else if (elements[i].intValue() > max) {
                max = elements[i].intValue();
            }
        }

        System.out.println("Min = " + min + " - Max = " + max);
    }
}

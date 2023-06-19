package mastering.datastructures.hashtable;

public class QuadraticProbingExampleMain {
    public static void main(String[] args) {
        var hashTable = new HashTableQuadraticProbing();
        hashTable.put(23);
        hashTable.put(43);
        hashTable.put(13);
        hashTable.put(27);
        hashTable.put(17);
    }
}

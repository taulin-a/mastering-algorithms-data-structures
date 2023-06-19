package mastering.datastructures.hashtable;

public class LinearProbingExampleMain {
    public static void main(String[] args) {
        var hashTable = new HashTableLinearProbing();
        hashTable.put(26);
        hashTable.put(30);
        hashTable.put(45);
        hashTable.put(23);
        hashTable.put(25);
        hashTable.put(43);
        hashTable.put(74);
        hashTable.put(19);
        hashTable.put(29);
    }
}

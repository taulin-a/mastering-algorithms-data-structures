package mastering.datastructures.hashtable;

public class DoubleHashingExampleMain {
    public static void main(String[] args) {
        var hashTable = new HashTableDoubleHashing();
        hashTable.put(5);
        hashTable.put(25);
        hashTable.put(15);
        hashTable.put(35);
        hashTable.put(95);
        hashTable.put(1);
    }
}

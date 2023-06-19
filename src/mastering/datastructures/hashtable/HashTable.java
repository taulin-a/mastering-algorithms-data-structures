package mastering.datastructures.hashtable;

public interface HashTable<T extends Comparable<T>> {
    void put(T key);

    T find(T key);

    Integer hash(T key);

    T delete(T key);
}

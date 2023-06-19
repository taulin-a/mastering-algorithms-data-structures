package mastering.datastructures.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTableDoubleHashing implements HashTable<Integer> {
    private final Integer[] hashArr;

    public HashTableDoubleHashing() {
        this.hashArr = new Integer[10];
    }

    @Override
    public void put(Integer key) {
        int i = 0;

        var hashKey = hash(key);
        while (hashArr[hashKey] != null) hashKey = calculateNextPos(++i, key);

        hashArr[hashKey] = key;
    }

    @Override
    public Integer find(Integer key) {
        int i = 0;

        var hashKey = hash(key);

        while (hashArr[hashKey] != null && !hashArr[hashKey].equals(key))
            hashKey = calculateNextPos(++i, key);

        return hashArr[hashKey];
    }

    @Override
    public Integer hash(Integer key) {
        return key % 10;
    }

    public Integer auxiliaryHash(Integer key) {
        return 7 - (key % 7);
    }

    private Integer calculateNextPos(int index, int key) {
        return (hash(key) + index * auxiliaryHash(key)) % 10;
    }

    @Override
    public Integer delete(Integer key) {
        int i = 0;

        var hashKey = hash(key);

        while (hashArr[hashKey] != null && !hashArr[hashKey].equals(key))
            hashKey = calculateNextPos(++i, key);

        if (hashArr[hashKey] != null) {
            var aux = hashArr[hashKey];
            hashArr[hashKey] = null;

            rehash();

            return aux;
        }

        return null;
    }

    private void rehash() {
        List<Integer> keys = new ArrayList<>();

        for (int i = 0; i < hashArr.length; i++) {
            if (hashArr[i] != null) {
                keys.add(hashArr[i]);
                hashArr[i] = null;
            }
        }

        keys.forEach(this::put);
    }
}

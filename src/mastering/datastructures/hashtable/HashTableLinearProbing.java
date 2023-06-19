package mastering.datastructures.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTableLinearProbing implements HashTable<Integer> {
    private final Integer[] hashArr;

    public HashTableLinearProbing() {
        this.hashArr = new Integer[10];
    }

    @Override
    public void put(Integer key) {
        int i = 0;

        var hashKey = hash(key + i);
        while (hashArr[hashKey] != null) hashKey = hash(key + (++i));

        hashArr[hashKey] = key;
    }

    @Override
    public Integer find(Integer key) {
        int i = 0;

        var hashKey = hash(key + i);

        while (hashArr[hashKey] != null && !hashArr[hashKey].equals(key))
            hashKey = hash(key + (++i));

        return hashArr[hashKey];
    }

    @Override
    public Integer hash(Integer key) {
        return key % 10;
    }

    @Override
    public Integer delete(Integer key) {
        int i = 0;

        var hashKey = hash(key + i);

        while (hashArr[hashKey] != null && !hashArr[hashKey].equals(key))
            hashKey = hash(key + (++i));

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

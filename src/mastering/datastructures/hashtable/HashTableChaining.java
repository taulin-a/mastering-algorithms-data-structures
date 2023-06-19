package mastering.datastructures.hashtable;

import mastering.datastructures.linkedlist.LinkedList;

import javax.naming.OperationNotSupportedException;

public class HashTableChaining implements HashTable<Integer> {
    private final LinkedList<Integer>[] hashArr;

    @SuppressWarnings("unchecked")
    public HashTableChaining() {
        this.hashArr = new LinkedList[10];
    }

    @Override
    public void put(Integer key) {
        try {
            var hashKey = hash(key);

            if (hashArr[hashKey] == null)
                hashArr[hashKey] = new LinkedList<>();

            hashArr[hashKey].insertSorted(key);
        } catch (OperationNotSupportedException e) {
            System.out.println("Erro ao inserir key");
        }
    }

    @Override
    public Integer find(Integer key) {
        var hashKey = hash(key);

        if (hashArr[hashKey] == null)
            return null;

        return hashArr[hashKey].linearSearch(key).getValue();
    }

    @Override
    public Integer hash(Integer key) {
        return key % 10;
    }

    @Override
    public Integer delete(Integer key) {
        var hashKey = hash(key);

        if (hashArr[hashKey] == null)
            return null;

        var iterator = hashArr[hashKey].getIterator();

        var index = 0;
        while (iterator.hasNext()) {
            if (iterator.getValue().equals(key))
                return hashArr[hashKey].delete(index);

            iterator.next();
            index++;
        }

        return null;
    }
}

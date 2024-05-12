package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K k, V v) {
        boolean res;
        if (capacity * LOAD_FACTOR <= count) {
            extend();
        }
        int h = hash(Objects.hashCode(k));
        int indexBuket = indexFor(h);
        if (table[indexBuket] != null) {
            res = false;
        } else {
            table[indexBuket] = new MapEntry<>(k, v);
            res = true;
            modCount++;
            count++;
        }
        return res;
    }

    private int hash(int hashCode) {
        int h = hashCode;
        return (h == 0) ? 0 : (h ^ (h >>> 16));
    }

    private int indexFor(int hash) {
        int n = capacity;
        return (n - 1) & hash;
    }

    private void extend() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> res : table) {
            if (res != null) {
                int h = hash(Objects.hashCode(res.key));
                int indexBuket = indexFor(h);
                newTable[indexBuket] = res;
            }
        }
        table = newTable;


    }

    @Override
    public V get(K k) {
        V result = null;
        int h = hash(Objects.hashCode(k));
        int indexBuket = indexFor(h);
        if (table[indexBuket] != null
                && Objects.hashCode(table[indexBuket].key) == Objects.hashCode(k)
                && Objects.equals(table[indexBuket].key, k)) {
            result = table[indexBuket].value;
        }
        return result;
    }

    @Override
    public boolean remove(K k) {
        boolean result = false;
        int h = hash(Objects.hashCode(k));
        int indexBuket = indexFor(h);
        if (table[indexBuket] != null && Objects.hashCode(table[indexBuket].key) == Objects.hashCode(k)
                && Objects.equals(table[indexBuket].key, k)) {
            table[indexBuket] = null;
            result = true;
            count--;
            modCount++;
        }

        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            int index = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < capacity && table[index] == null) {
                    index++;
                }

                return index < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        NonCollisionMap map = new NonCollisionMap<>();
        int h = Objects.hashCode(8);
        int res = map.hash(h);
        int back = map.indexFor(res);
        System.out.println(h);
        System.out.println(res);
        System.out.println(back);
    }
}

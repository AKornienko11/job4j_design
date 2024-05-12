package ru.job4j.map;

public interface SimpleMap<K, V> extends Iterable<K> {

    boolean put(K k, V v);
    V get(K k);
    boolean remove(K k);
}

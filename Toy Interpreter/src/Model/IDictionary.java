/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model;

import java.util.Collection;

public interface IDictionary <K,V>
{
    void add(K key, V value);
    void update(K key, V value);
    boolean contains(K key);
    V get(K key);
    Iterable<K> getAll();
    Collection<V> getValues();
    Iterable<K> getKeys();
    IDictionary<K,V> makeCopy();
}
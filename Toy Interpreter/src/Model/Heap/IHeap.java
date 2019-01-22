/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Heap;

import java.util.Map;

public interface IHeap<K,V>
{
    K add( V value);
    V get(K key);
    void update(K key, V value);
    boolean contains(K key);
    Map<K,V> getContent();
    Iterable<K> getKeys();
    Iterable<V> getValues();
    void setContent(Map<K,V> newContent);
}

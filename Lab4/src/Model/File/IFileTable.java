/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.File;

public interface IFileTable<K,V>
{
    void add(K key, V val);
    void remove(K key);
    boolean contains(K key);
    V get(K key);
    V find(K key);
    Iterable<K> getAll();
    Iterable<V> getValues();
}
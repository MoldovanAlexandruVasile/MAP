/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package File;

import java.util.HashMap;

public class FileTable<K, V> implements IFileTable<K, V>
{
    private HashMap<K,V> dict;
    public void FileTable()
    {
        dict = new HashMap<>();
    }

    public void add(K key, V value)
    {
        dict.put(key, value);
    }

    public void remove(K key)
    {
        dict.remove(key);
    }

    public V get(K key)
    {
        return dict.get(key);
    }

    public Iterable<K> getAll()
    {
        return dict.keySet();
    }

    public Iterable<V> getValues()
    {
        return dict.values();
    }

    public boolean contains(K key)
    {
        return dict.containsKey(key);
    }
}

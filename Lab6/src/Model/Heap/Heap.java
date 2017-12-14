/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Heap;

import java.util.HashMap;
import java.util.Map;

public class Heap<V> implements IHeap<Integer, V>
{
    private Map<Integer,V> dict = new HashMap<>();
    private int nextFree = 0;

    @Override
    public Integer add(V value)
    {
        nextFree++;
        dict.put(nextFree, value);
        return nextFree;
    }

    @Override
    public Map<Integer, V> getContent() { return dict; }

    @Override
    public void setContent(Map<Integer, V> newContent)
    {
        dict = newContent;
    }

    @Override
    public void update(Integer key, V value)
    {
        dict.put(key,value);
    }

    @Override
    public V get(Integer key)
    {
        return dict.get(key);
    }

    @Override
    public boolean contains(Integer key)
    {
        return dict.containsKey(key);
    }

    @Override
    public Iterable<Integer> getKeys()
    {
        return dict.keySet();
    }

    @Override
    public Iterable<V> getValues()
    {
        return dict.values();
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("\n\nHeap:");
        for (Map.Entry<Integer,V> e : dict.entrySet())
        {
            s.append('\n');
            s.append(e.getKey());
            s.append("-->");
            s.append(e.getValue());
        }
        return s.toString();
    }
}

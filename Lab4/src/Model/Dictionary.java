package Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Dictionary <K, V> implements IDictionary<K, V>
{
    private Map<K,V> dict;
    public Dictionary()
    {
        dict = new HashMap<K,V>();
    }
    public void add(K key, V value)
    {
        dict.put(key, value);
    }
    public void update(K key, V value)
    {
        dict.put(key, value);
    }
    public V get(K key)
    {
        return dict.get(key);
    }
    public boolean contains(K key)
    {
        return dict.containsKey(key);
    }
    public Iterable<K> getAll()
    {
        return dict.keySet();
    }

    @Override
    public Collection<V> getValues()
    {
        return dict.values();
    }

    @Override
    public Iterable<K> getKeys()
    {
        return dict.keySet();
    }

    public String toString()
    {
        StringBuffer buff = new StringBuffer();
        if(dict.isEmpty())
            buff.append("Dictionary: EMPTY");
        else
        {
            buff.append("\nDictionary: \n");
            for (Map.Entry<K, V> dc : dict.entrySet())
            {
                buff.append(dc.getKey());
                buff.append(" = ");
                buff.append(dc.getValue());
                buff.append('\n');
            }
        }
        return buff.toString();
    }
}

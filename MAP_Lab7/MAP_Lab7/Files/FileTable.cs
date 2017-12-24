using System.Collections.Generic;
using System.Collections;

namespace MAP_Lab7.Files
{
    public class FileTable<K, V> : IEnumerable
    {
        Dictionary<K, V> fileTable = new Dictionary<K, V>();

        public void Add(K key, V value)
        {
            fileTable[key] = value;
        }

        public void Delete(K key)
        {
            fileTable.Remove(key);
        }

        public bool Exists(K key)
        {
            return fileTable.ContainsKey(key);
        }

        public V Get(K key)
        {
            return fileTable[key];
        }

        public void Update(K key, V value)
        {
            fileTable[key] = value;
        }

        public bool ContainKey(K key)
        {
            return fileTable.ContainsKey(key);
        }

        public bool ContainValue(V value)
        {
            return fileTable.ContainsValue(value);
        }

        public IEnumerable AllValues()
        {
            return fileTable.Values;
        }

        public IEnumerator GetEnumerator()
        {
            return fileTable.GetEnumerator();
        }
    }
}

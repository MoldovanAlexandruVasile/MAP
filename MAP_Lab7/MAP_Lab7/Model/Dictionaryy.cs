using System.Collections;
using System.Collections.Generic;

namespace MAP_Lab7.Model
{
    public class Dictionaryy<K,V> : IDictionaryy<K,V>
    {
        private Dictionary<K, V> dict = new Dictionary<K, V>();

        public void Add(K key, V value)
        {
            dict[key] = value;
        }

        public void Update(K key, V value)
        {
            dict[key] = value;
        }

        public V Get(K key)
        {
            return dict[key];
        }

        public bool Contains(K key)
        {
            return dict.ContainsKey(key);
        }

        public IEnumerator GetEnumerator()
        {
            return dict.GetEnumerator();
        }
    }
}

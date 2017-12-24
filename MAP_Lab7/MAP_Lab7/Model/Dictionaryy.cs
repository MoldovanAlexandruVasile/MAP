
using System.Collections;

namespace MAP_Lab7.Model
{
    public class Dictionaryy<K,V> : IDictionaryy<K,V>
    {
        private Dictionaryy<K, V> dict = new Dictionaryy<K, V>();

        public void Add(K key, V value)
        {
            dict.Add(key, value);
        }

        public void Update(K key, V value)
        {
            dict.Add(key, value);
        }

        public V Get(K key)
        {
            return dict.Get(key);
        }

        public bool Contains(K key)
        {
            return dict.Contains(key);
        }

        public IEnumerator GetEnumerator()
        {
            return dict.GetEnumerator();
        }
    }
}

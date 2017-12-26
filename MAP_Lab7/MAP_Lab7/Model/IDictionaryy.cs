using System.Collections;

namespace MAP_Lab7.Model
{
    public interface IDictionaryy<K,V> : IEnumerable
    {
        void Add(K key, V value);
        void Update(K key, V value);
        bool Contains(K key);
        V Get(K key);
    }
}

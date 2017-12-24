using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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

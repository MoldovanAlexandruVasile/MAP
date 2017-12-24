
using System.Collections;

namespace MAP_Lab7.Model
{
    public interface IListt<T>
    {
        void Add(T x);
        IEnumerator GetEnumerator();
    }
}

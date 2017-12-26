using System.Collections;

namespace MAP_Lab7.Model
{
    public interface IListt<T>
    {
        void AddList(T x);
        IEnumerator GetEnumerator();
    }
}

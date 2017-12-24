
using System.Collections;

namespace MAP_Lab7.Model
{
    public interface IExeStack<T> : IEnumerable
    {
        void Push(T x);
        T Pop();
        bool IsEmpty();
    }
}

using System.Collections;

namespace MAP_Lab7.Model
{
    public interface IExeStack<T> : IEnumerable
    {
        void PushS(T x);
        T PopS();
        bool IsEmpty();
    }
}

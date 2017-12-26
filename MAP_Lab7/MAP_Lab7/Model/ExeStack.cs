using System.Collections;
using System.Collections.Generic;

namespace MAP_Lab7.Model
{
    public class ExeStack<T> : IExeStack<T>
    {
        private Stack<T> stack = new Stack<T>();

        public void PushS(T x)
        {
            stack.Push(x);
        }

        public T PopS()
        {
            return stack.Pop();
        }

        public bool IsEmpty()
        {
            return stack.Count == 0;
        }

        public IEnumerator GetEnumerator()
        {
            return stack.GetEnumerator();
        }
    }
}

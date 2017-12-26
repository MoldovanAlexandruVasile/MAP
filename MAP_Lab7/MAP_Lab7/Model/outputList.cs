using System.Collections;
using System.Collections.Generic;

namespace MAP_Lab7.Model
{
    public class outputList<T> : IListt<T>
    {
        private List<T> list = new List<T>();

        public void AddList(T x)
        {
            list.Add(x);
        }

        public IEnumerator GetEnumerator()
        {
            return list.GetEnumerator();
        }
    }
}

using System.Collections;

namespace MAP_Lab7.Model
{
    public class outputList<T> : IListt<T>
    {
        private IListt<T> list = new outputList<T>();

        public void Add(T x)
        {
            list.Add(x);
        }

        public IEnumerator GetEnumerator()
        {
            return list.GetEnumerator();
        }
    }
}

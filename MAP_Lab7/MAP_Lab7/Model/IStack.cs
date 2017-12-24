using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MAP_Lab7.Model
{
    public interface IStack<T>
    {
        void Push(T el);
        T Pop();
        bool IsEmpty();
    }
}

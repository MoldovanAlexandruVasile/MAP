using System;

namespace MAP_Lab7.Exceptions
{
    public class DivByZeroException: Exception
    {
        public DivByZeroException()
        {
        }

        public DivByZeroException(string message)
            : base(message){}
    }
}

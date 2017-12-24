using System;

namespace MAP_Lab7.Exceptions
{
    public class InexistentSymbolException : Exception
    {
        public InexistentSymbolException()
        {}

        public InexistentSymbolException(string message)
            : base(message) {}
    }
}

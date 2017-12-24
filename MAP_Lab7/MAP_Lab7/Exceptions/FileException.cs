using System;

namespace MAP_Lab7.Exceptions
{
    public class FileException : Exception
    {
        public FileException()
        {
        }

        public FileException(string message)
            : base(message) { }
    }
}

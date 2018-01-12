using System;

namespace MAP_Lab7.Exceptions
{
    public class CommandException : Exception
    {
        public CommandException()
        {
        }

        public CommandException(string message)
            : base(message) { }
    }
}

using System;

namespace MAP_Lab7.Exceptions
{
    public class EvaluationException : Exception
    {
        public EvaluationException()
        {}
    
        public EvaluationException(string message) 
            : base(message){}
    }
}

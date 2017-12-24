using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MAP_Lab7.Statements
{
    public class CompStmt:Statement
    {
        private Statement first, second;
        public CompStmt(Statement f, Statement s)
        {
            first = f;
            second = s;
        }

        public PrgState Execute(PrgState state)
        {
            state.ExeStack.Push(first);
            state.ExeStack.Push(second);
            return state;
        }

        public override string ToString()
        {
            return "" + first + "\n" + second;
        }
    }
}

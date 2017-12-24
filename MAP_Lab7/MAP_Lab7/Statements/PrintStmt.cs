using System;
using MAP_Lab7.Exceptions;
using MAP_Lab7.Expressions;

namespace MAP_Lab7.Statements
{
    public class PrintStmt:Statement
    {
        private IExpression expr;
        public PrintStmt(IExpression e)
        {
            expr = e;
        }

        public PrgState Execute(PrgState p)
        {
            try
            {
                int r = expr.Eval(p.Dict);
                p.OutputList.Add(r);
            }
            catch (EvaluationException e)
            {
                Console.WriteLine(e.Message);
            }
            catch (InexistentSymbolException e2)
            {
                Console.WriteLine(e2.Message);
            }
            catch (DivByZeroException e3)
            {
                Console.WriteLine(e3.Message);
            }
            return p;
        }

        public override string ToString()
        {
            return "" + expr;
        }
    }
}

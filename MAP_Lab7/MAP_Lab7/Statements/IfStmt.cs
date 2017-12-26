using MAP_Lab7.Statements;
using MAP_Lab7.Expressions;
using MAP_Lab7.Exceptions;
using System;

namespace MAP_Lab7.Model
{
    public class IfStmt : Statement
    {
        private Statement then;
        private Statement els;
        private IExpression expr;

        public IfStmt(IExpression expre, Statement t, Statement e)
        {
            then = t;
            els = e;
            expr = expre;
        }

        public PrgState Execute(PrgState state)
        {
            try
            {
                if (expr.Eval(state.Dict) != 0)
                    state.ExeStack.PushS(then);
                else
                    state.ExeStack.PushS(els);

                return state;
            }
            catch (DivByZeroException e)
            {
                Console.WriteLine(e.Message);
            }
            catch (EvaluationException e2)
            {
                Console.WriteLine(e2.Message);
            }
            catch (InexistentSymbolException e3)
            {
                Console.WriteLine(e3.Message);
            }
            return state;
        }

        public override string ToString()
        {
            return "IF (" + expr + ") THEN (" + then + ") ELSE (" + els + ")";
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using MAP_Lab7.Exceptions;
using MAP_Lab7.Expressions;

namespace MAP_Lab7.Statements
{
    public class AssignStmt:Statement
    {
        private IExpression expr;
        private string var;

        public AssignStmt(string v, IExpression e)
        {
            expr = e;
            var = v;
        }

        public PrgState Execute(PrgState state)
        {
            try
            {

                int result = expr.Eval(state.Dict);
                state.Dict.Update(var, result);

                return state;
            }
            catch(DivByZeroException e)
            {
                Console.WriteLine(e.Message);
            }
            catch(EvaluationException e2)
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
            return "Assign(" + var + "=" + expr + ")";
        }
    }
}

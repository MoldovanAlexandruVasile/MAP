/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Statement;

import Model.Expression.Expression;
import Model.IDictionary;
import Model.IExecStack;
import Model.Exception.DivByZeroException;
import Model.Exception.EvaluationException;
import Model.Exception.InexistentSymbolException;


public class IfStmt implements Statement {

    private Expression exp;
    private Statement thenS;
    private Statement elseS;

    public IfStmt(Expression e, Statement t, Statement s)
    {
        exp = e;
        thenS = t;
        elseS = s;
    }

    @Override
    public PrgState execute(PrgState state) {
        IDictionary<String, Integer> dict = state.getSymbolT();
        IExecStack<Statement> stack = state.getExecStack();
        try
        {
            int val = exp.Eval(dict,state.getHeap());

            if (val != 0)
                stack.push(thenS);
            else
                stack.push(elseS);

            return null;
        }
        catch( EvaluationException | DivByZeroException | InexistentSymbolException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "IF(" + exp + ")THEN(" + thenS + ")ELSE(" + elseS + ") ";
    }
}
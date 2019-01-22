/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Statement;

import Model.Exception.DivByZeroException;
import Model.Exception.EvaluationException;
import Model.Exception.InexistentSymbolException;
import Model.Expression.ConstExpr;
import Model.Expression.Expression;

public class SleepStmt implements Statement
{
    private Expression expr;
    public SleepStmt(Expression n)
    {
        expr = n;
    }

    @Override
    public PrgState execute(PrgState p)
    {

        try
        {
            if (expr.Eval(p.getSymbolT(), p.getHeap()) != 0)
            {
                p.getExecStack().push(new SleepStmt(new ConstExpr(expr.Eval(p.getSymbolT(), p.getHeap()) - 1)));
                return null;
            }
        }
        catch(InexistentSymbolException | DivByZeroException | EvaluationException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String toString()
    {
        return "Sleep(" + expr + ")";
    }
}

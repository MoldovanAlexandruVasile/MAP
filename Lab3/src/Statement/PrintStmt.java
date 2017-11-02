/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Statement;

import Expression.Expression;
import Exception.DivByZeroException;
import Exception.EvaluationException;
import Exception.InexistentSymbolException;

public class PrintStmt implements Statement
{
    private Expression expr;
    public PrintStmt(Expression e)
    {
        expr = e;
    }

    @Override
    public PrgState execute(PrgState p)
    {
        try
        {
            int r = expr.Eval(p.getSymbolT());
            p.getList().add(r);
        }
        catch(EvaluationException | DivByZeroException | InexistentSymbolException e)
        {
            System.out.println(e.getMessage());
        }
        return p;
    }

    @Override
    public String toString() {
        return "" + expr;
    }
}

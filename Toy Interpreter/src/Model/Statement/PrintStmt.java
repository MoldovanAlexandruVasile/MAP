/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Statement;

import Model.Expression.Expression;
import Model.Exception.DivByZeroException;
import Model.Exception.EvaluationException;
import Model.Exception.InexistentSymbolException;

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
            int r = expr.Eval(p.getSymbolT(),p.getHeap());
            p.getList().add(r);
        }
        catch(EvaluationException | DivByZeroException | InexistentSymbolException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "" + expr;
    }
}

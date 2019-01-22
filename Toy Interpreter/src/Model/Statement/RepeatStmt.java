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
import Model.Expression.DifferentExpr;
import Model.Expression.Expression;
import Model.Expression.NotExpr;

public class RepeatStmt implements Statement
{
    private Expression expr;
    private Statement statement;

    public RepeatStmt(Statement s, Expression e)
    {
        expr = e;
        statement = s;
    }

    @Override
    public PrgState execute(PrgState prgState)
    {
        try
        {
            if(expr.Eval(prgState.getSymbolT(),prgState.getHeap()) == 0)
            {
                prgState.getExecStack().push(new CompStmt(statement, new WhileStmt(new DifferentExpr(expr, new ConstExpr(1)),statement)));
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
        return "Repeat(" + statement + ") until {" + expr + "}";
    }
}

/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Statement;

import Model.Expression.*;
import Model.Exception.*;

public class WhileStmt implements Statement
{
    private Expression expr;
    private Statement statement;

    public WhileStmt(Expression e, Statement s)
    {
        expr = e;
        statement = s;
    }

    @Override
    public PrgState execute(PrgState prgState)
    {
        try
        {
            if (expr.Eval(prgState.getSymbolT(), prgState.getHeap()) != 0)
            {
                prgState.getExecStack().push(new WhileStmt(expr, statement));
                statement.execute(prgState);
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
        return "While(" + expr + "){" + statement + "}";
    }
}

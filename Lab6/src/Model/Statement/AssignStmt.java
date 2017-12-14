/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Statement;

import Model.Expression.Expression;
import Model.Exception.DivByZeroException;
import Model.Exception.EvaluationException;
import Model.IDictionary;
import Model.Exception.InexistentSymbolException;

public class AssignStmt implements Statement
{
    private String varName;
    private Expression expr;
    public AssignStmt(String vName, Expression e)
    {
        varName = vName;
        expr = e;
    }

    @Override
    public PrgState execute(PrgState state)
    {
        IDictionary<String, Integer> d = state.getSymbolT();
        try
        {
            int intr = expr.Eval(d, state.getHeap());
            if(d.contains(varName))
                d.update(varName, intr);
            else d.add(varName, intr);

        }
        catch(EvaluationException | InexistentSymbolException | DivByZeroException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String toString()
    {
        return varName + " = " + expr;
    }
}

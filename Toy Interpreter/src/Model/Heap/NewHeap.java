/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Heap;

import Model.Exception.*;
import Model.Expression.*;
import Model.Statement.*;

public class NewHeap implements Statement
{
    private String var;
    private Expression expr;

    public NewHeap(String v, Expression e)
    {
        var = v;
        expr = e;
    }

    @Override
    public PrgState execute(PrgState prgState)
    {
        try
        {
            int val = expr.Eval(prgState.getSymbolT(), prgState.getHeap());
            prgState.getSymbolT().add(var, prgState.getHeap().add(val));
            return null;
        }
        catch(DivByZeroException | EvaluationException | InexistentSymbolException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString()
    {
        return "newH(" + var +','+  expr + ");";
    }
}
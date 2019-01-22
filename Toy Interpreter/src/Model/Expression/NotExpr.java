/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Expression;

import Model.Exception.DivByZeroException;
import Model.Exception.EvaluationException;
import Model.Exception.InexistentSymbolException;
import Model.Heap.IHeap;
import Model.IDictionary;

public class NotExpr implements Expression
{
    private Expression expr;

    public NotExpr(Expression e)
    {
        expr = e;
    }

    @Override
    public int Eval(IDictionary<String, Integer> symbolT, IHeap<Integer, Integer> heap) throws InexistentSymbolException, EvaluationException, DivByZeroException
    {
        try
        {
            if (expr.Eval(symbolT, heap) == 0)
                return 1;
            return 0;
        }
        catch (InexistentSymbolException | DivByZeroException | EvaluationException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public String toString() {
        return ""+expr;
    }
}

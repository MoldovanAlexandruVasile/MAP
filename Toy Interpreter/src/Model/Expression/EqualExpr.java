/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Expression;

import Model.Exception.*;
import Model.IDictionary;
import Model.Heap.IHeap;

public class EqualExpr implements Expression
{
    private Expression left, right;

    public EqualExpr(Expression l, Expression r)
    {
        left = l;
        right = r;
    }

    @Override
    public int Eval(IDictionary<String, Integer> symbolT, IHeap<Integer, Integer> heap) throws InexistentSymbolException, EvaluationException, DivByZeroException
    {
        try
        {
            if (left.Eval(symbolT, heap) == right.Eval(symbolT, heap))
                return 1;
            return 0;
        }
        catch(InexistentSymbolException | DivByZeroException | EvaluationException e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public String toString()
    {
        return left+" = "+right;
    }
}


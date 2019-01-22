/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Expression;

import Model.Exception.EvaluationException;
import Model.Heap.*;
import Model.IDictionary;

public class VarExpr implements Expression
{
    private String x;
    public VarExpr(String str)
    {
        x = str;
    }

    public int Eval(IDictionary<String, Integer> d, IHeap<Integer, Integer> heap) throws EvaluationException
    {
        if(d.contains(x))
            return d.get(x);
        throw new EvaluationException("Can not be evaluated " + x + " !");
    }

    @Override
    public String toString()
    {
        return "" + x ;
    }
}

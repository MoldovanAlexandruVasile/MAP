/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Expression;

import Model.IDictionary;
import Model.Heap.*;

public class ConstExpr implements Expression
{
    private int value;
    public ConstExpr(int v)
    {
        value = v;
    }

    @Override
    public int Eval(IDictionary<String, Integer> d,IHeap<Integer,Integer> heap)
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "" + value;
    }
}

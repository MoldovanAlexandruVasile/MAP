
/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Expression;

import Model.IDictionary;

public class ConstExpr implements Expression
{
    private int value;
    public ConstExpr(int v)
    {
        value = v;
    }

    @Override
    public int Eval(IDictionary<String, Integer> d)
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "" + value;
    }
}

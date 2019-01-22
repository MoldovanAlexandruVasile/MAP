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

public class ArithmeticExpr implements Expression
{
    private char operator;
    private Expression left;
    private  Expression right;

    public ArithmeticExpr(char op, Expression l, Expression r)
    {
        operator = op;
        left = l;
        right = r;
    }

    @Override
    public int Eval(IDictionary<String, Integer> d, IHeap<Integer, Integer> heap) throws DivByZeroException, InexistentSymbolException
    {
        try
        {
            int l = left.Eval(d, heap);
            int r = right.Eval(d, heap);
            if (operator == '+')
                return l + r;
            else if(operator == '-')
                return l - r;
            else if(operator == '*')
                return l * r;
            else if(operator == '/')
                if(r == 0)
                    throw new DivByZeroException("\nDivision by zero in " + l + operator + r + " ! \n");
                else return l / r;
            throw new InexistentSymbolException("\nSymbol " + operator + " does not exist !\n");
        }
        catch(EvaluationException | DivByZeroException | InexistentSymbolException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public String toString()
    {
        return left + " " + operator + " " + right ;
    }
}

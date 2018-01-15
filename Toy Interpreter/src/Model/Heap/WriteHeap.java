/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Heap;

import Model.*;
import Model.Statement.*;
import Model.Expression.*;
import Model.Exception.*;

public class WriteHeap implements Statement
{

    private String name;
    private Expression expr;

    public WriteHeap(String v, Expression e)
    {
        name = v;
        expr = e;
    }

    @Override
    public PrgState execute(PrgState prgState)
    {
        IHeap<Integer,Integer> heap = prgState.getHeap();
        IDictionary<String,Integer> systemTable = prgState.getSymbolT();
        try
        {
            heap.update(systemTable.get(name), expr.Eval(systemTable,heap));
        }
        catch(EvaluationException | DivByZeroException | InexistentSymbolException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "wH(" +name+", " +expr + ");";
    }
}

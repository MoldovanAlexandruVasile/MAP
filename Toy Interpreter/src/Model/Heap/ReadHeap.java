/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Heap;

import Model.Exception.*;
import Model.*;
import Model.Expression.*;

public class ReadHeap implements Expression
{
    private String var;

    public ReadHeap(String v)
    {
        var = v;
    }

    @Override
    public int Eval(IDictionary<String, Integer> symbolTable, IHeap<Integer, Integer> heap) throws EvaluationException
    {
        if (!symbolTable.contains(var))
            throw new EvaluationException("ReadHeap - variable does not exist !");
        Integer value = symbolTable.get(var);
        if (!heap.contains(value))
            throw new EvaluationException("ReadHeap - not such value !");
        return heap.get(value);
    }

    @Override
    public String toString() {
        return "rH(" + var + ");";
    }
}

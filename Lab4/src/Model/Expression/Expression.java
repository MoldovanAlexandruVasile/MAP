/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Expression;

import Model.Heap.*;
import Model.*;
import Model.Exception.*;

public interface Expression
{
    public int Eval(IDictionary<String, Integer> d, IHeap<Integer,Integer> heap) throws EvaluationException, DivByZeroException, InexistentSymbolException;
}

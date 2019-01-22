/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Statement;

import Model.CyclicBarrier.ICyclicBarrier;
import Model.CyclicBarrier.Pair;
import Model.File.*;
import Model.*;
import Model.Heap.*;
import Model.LatchTable.ILatchTable;
import Model.LockTable.ILockTable;

import java.lang.StringBuffer;
import java.util.ArrayList;


public class PrgState
{
    private IExecStack<Statement> execStack;
    private IDictionary<String,Integer> symbolT;
    private IList<Integer> list;
    private FileTable<Integer,FileData> ft;
    private IHeap<Integer,Integer> heap;
    private Integer ID;
    private Statement statement;
    private ILockTable<Integer, Integer> lockTable;
    private ICyclicBarrier<Integer,Pair<Integer, ArrayList<Integer>>> cyclicBarrier;
    private ILatchTable<Integer,Integer> latchTable;

    public PrgState(IExecStack<Statement> s, IDictionary<String, Integer> d, IList<Integer> l, FileTable<Integer, FileData> ftable,
                    IHeap<Integer, Integer> hp, Integer i)
    {
        execStack = s;
        symbolT = d;
        list = l;
        ft = ftable;
        heap = hp;
        ID = i;
    }

    public PrgState(IExecStack<Statement> s, IDictionary<String, Integer> d, IList<Integer> l, FileTable<Integer, FileData> ftable,
                    IHeap<Integer, Integer> hp, Integer i, Statement st, ILockTable<Integer,Integer> lt,
                    ICyclicBarrier<Integer,Pair<Integer, ArrayList<Integer>>> c, ILatchTable<Integer,Integer> lat)
    {
        execStack = s;
        symbolT = d;
        list = l;
        ft = ftable;
        heap = hp;
        ID = i;
        statement = st;
        lockTable = lt;
        cyclicBarrier = c;
        latchTable = lat;

    }

    public ILatchTable<Integer, Integer> getLatchTable() {
        return latchTable;
    }

    public void setLatchTable(ILatchTable<Integer, Integer> latchTable) {
        this.latchTable = latchTable;
    }

    public ICyclicBarrier<Integer,Pair<Integer, ArrayList<Integer>>> getCyclicBarrier()
    {
        return cyclicBarrier;
    }

    public void setCyclicBarrier(ICyclicBarrier<Integer,Pair<Integer, ArrayList<Integer>>> cyclicBarrier)
    {
        this.cyclicBarrier = cyclicBarrier;
    }

    public Statement getStatement()
    {
        return statement;
    }

    public IExecStack<Statement> getExecStack()
    {
        return execStack;
    }

    public IDictionary<String, Integer> getSymbolT()
    {
        return symbolT;
    }

    public IList<Integer> getList()
    {
        return list;
    }

    public void setExecStack(IExecStack<Statement> execStack)
    {
        this.execStack = execStack;
    }

    public void setSymbolT(IDictionary<String, Integer> symbolT)
    {
        this.symbolT = symbolT;
    }

    public void setList(IList<Integer> l)
    {
        list = l;
    }

    public FileTable<Integer, FileData> getFileTable() { return ft; }

    public void setFileTable(FileTable<Integer, FileData> flt) { ft = flt; }

    public IHeap<Integer, Integer> getHeap() { return heap; }

    public Integer getID() { return ID; }

    public void setID(Integer i) { ID = i; }

    public ILockTable<Integer, Integer> getLockTable()
    {
        return lockTable;
    }

    public void setLockTable(ILockTable<Integer, Integer> lockTable)
    {
        this.lockTable = lockTable;
    }

    public boolean isNotCompleted()
    {
        return !execStack.isEmpty();
    }

    public PrgState oneStep()
    {
        if (execStack.isEmpty())
            throw new RuntimeException("Empty stack.");
        Statement statement = execStack.pop();
        return statement.execute(this);
    }

    @Override
    public String toString()
    {
        StringBuffer buff = new StringBuffer();
        buff.append(ID);
        buff.append(execStack);
        buff.append(symbolT);
        buff.append(list);
        buff.append(heap);
        buff.append("\n");
        return buff.toString();
    }
}
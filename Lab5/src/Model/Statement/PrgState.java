/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Statement;

import Model.File.*;
import Model.*;
import Model.Heap.*;


public class PrgState
{
    private IExecStack<Statement> execStack;
    private IDictionary<String,Integer> symbolT;
    private IList<Integer> list;
    private Statement statement;
    private FileTable<Integer,FileData> ft;
    private IHeap<Integer,Integer> heap;

    public PrgState(IExecStack<Statement> s, IDictionary<String, Integer> d, IList<Integer> l, Statement st, FileTable<Integer, FileData> ftable, IHeap<Integer, Integer> hp)
    {
        execStack = s;
        symbolT = d;
        list = l;
        statement = st;
        ft = ftable;
        heap = hp;
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

    public Statement getStatement() { return statement; }

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
        this.list = l;
    }

    public FileTable<Integer, FileData> getFileTable() { return ft; }

    public void setFileTable(FileTable<Integer, FileData> flt) { ft = flt; }

    public void setStatement(Statement sta) { this.statement = sta; }

    public IHeap<Integer, Integer> getHeap()
    {
        return heap;
    }

    @Override
    public String toString()
    {
        StringBuffer buff = new StringBuffer();
        buff.append(execStack);
        buff.append(symbolT);
        buff.append(list);
        buff.append(statement);
        buff.append(heap);
        buff.append("\n");
        return buff.toString();
    }
}
package Model;

public class PrgState
{
    private IExecStack<Statement> execStack;
    private IDictionary<String,Integer> symbolT;
    private IList<Integer> list;
    private Statement rootP;
    public PrgState(IExecStack<Statement> s, IDictionary<String, Integer> d, IList<Integer> l, Statement statem)
    {
        execStack = s;
        symbolT = d;
        list = l;
        rootP = statem;
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

    public Statement getRootP()
    {
        return rootP;
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
        this.list = l;
    }

    public void setRootP(Statement rootP)
    {
        this.rootP = rootP;
    }

    @Override
    public String toString()
    {
        StringBuffer buff = new StringBuffer();
        buff.append(execStack);
        buff.append(symbolT);
        buff.append(list);
        buff.append(rootP);
        buff.append('\n');
        return buff.toString();
    }
}
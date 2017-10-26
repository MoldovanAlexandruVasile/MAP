package Model;

public class CompStmt implements Statement
{
    private Statement first, second;
    public CompStmt(Statement f, Statement s)
    {
        first = f;
        second = s;
    }

    public PrgState execute(PrgState state)
    {
        state.getExecStack().push(second);
        state.getExecStack().push(first);
        return state;
    }

    @Override
    public String toString()
    {
        return "" + first + second;
    }
}

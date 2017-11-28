/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Statement;

public class CompStmt implements Statement
{
    private Statement first, second;
    public CompStmt(Statement f, Statement s)
    {
        first = f;
        second = s;
    }

    @Override
    public PrgState execute(PrgState state)
    {
        state.getExecStack().push(first);
        state.getExecStack().push(second);
        return state;
    }

    @Override
    public String toString()
    {
        return "" + first + second;
    }
}

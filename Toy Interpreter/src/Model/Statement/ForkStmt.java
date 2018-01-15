/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Statement;

import Model.ExeStack;
import Model.IDictionary;
import Model.IExecStack;

public class ForkStmt implements Statement
{
    private Statement statement;
    private int number;

    public ForkStmt(Statement s) {statement = s;}

    @Override
    public PrgState execute(PrgState prgState)
    {
        IDictionary<String,Integer> dict = prgState.getSymbolT().makeCopy();
        IExecStack<Statement> stack = new ExeStack<>();
        stack.push(statement);
        number++;
        PrgState fork = new PrgState(stack, dict, prgState.getList(), prgState.getFileTable(), prgState.getHeap(),prgState.getID()*10);
        return fork;
    }

    private int getNumber()
    {
        return number;
    }

    @Override
    public String toString() {
        return "ForkStmt("+statement+")";
    }
}

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

    public ForkStmt(Statement s) {statement = s;}

    @Override
    public PrgState execute(PrgState prgState)
    {
        IDictionary<String,Integer> dict = prgState.getSymbolT().makeCopy();
        IExecStack<Statement> stack = new ExeStack<>();
        stack.push(statement);
        PrgState fork = new PrgState(stack, dict, prgState.getList(), prgState.getFileTable(), prgState.getHeap(),prgState.getID()*10);
        return fork;
    }

    @Override
    public String toString() {
        return "ForkStmt("+statement+")";
    }
}

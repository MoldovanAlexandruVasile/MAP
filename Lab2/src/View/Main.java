/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package View;
import Model.*;
import Controller.*;
import Repository.*;

public class Main
{
    public static void main(String arg[])
    {
        Statement s = new CompStmt(new AssignStmt("v", new ConstExpr(4)),new PrintStmt(new VarExpr("v")));
        Statement s2 = new AssignStmt("x", new ArithmeticExpr('+', new ConstExpr(3),new ConstExpr(5)));
        Statement s3 =new AssignStmt("y", new ArithmeticExpr('*', new ConstExpr(25), new VarExpr("a")));
        Statement s4 = new AssignStmt("z", new ArithmeticExpr('"', new ConstExpr(3),new ConstExpr(5)));
        IExecStack<Statement> execStack = new ExeStack<>();
        IDictionary<String,Integer> dict = new Dictionary<>();
        IList<Integer> l = new outputList<>();
        execStack.push(s);
        execStack.push(s2);
        execStack.push(s3);
        execStack.push(s4);
        PrgState state = new PrgState(execStack, dict, l, s);
        IPrgStateRepo repo = new PrgStateRepo();
        Controller c = new Controller(repo);
        repo.addPrgState(state);
        c.executeAll();
    }
}

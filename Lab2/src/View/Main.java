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
        //Example 1
        Statement s = new CompStmt(new AssignStmt("v", new ConstExpr(2)),new PrintStmt(new VarExpr("v")));


        //Example 2
        //Statement s = new AssignStmt("a", new ArithmeticExpr('+', new ConstExpr(2),new ArithmeticExpr('*', new ConstExpr(3), new ConstExpr(5))));
        //Statement s2 = new AssignStmt("b", new ArithmeticExpr('-', new VarExpr("a"), new ArithmeticExpr('+', new ArithmeticExpr('/', new ConstExpr(4), new ConstExpr(2)), new ConstExpr(7))));


        //Example 3
        //Statement s = new AssignStmt( "a", new ArithmeticExpr('-', new ConstExpr(2), new ConstExpr(2)));
        //Statement s2 = new CompStmt(new IfStmt(new VarExpr("a"), new AssignStmt("v",new ConstExpr(2)), new AssignStmt("v",new ConstExpr(3))), new PrintStmt(new VarExpr("v")));


        IExecStack<Statement> execStack = new ExeStack<>();
        IDictionary<String,Integer> dict = new Dictionary<>();
        IList<Integer> l = new outputList<>();
        execStack.push(s);

        //execStack.push(s2);

        PrgState state = new PrgState(execStack, dict, l, s);
        IPrgStateRepo repo = new PrgStateRepo();
        Controller c = new Controller(repo);
        repo.addPrgState(state);
        c.executeOneStep();
        //c.executeOneStep();
        //c.executeAll();
    }
}

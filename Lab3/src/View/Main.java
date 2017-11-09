/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package View;
import Expression.*;
import Model.*;
import Controller.*;
import Repository.*;
import Statement.*;
import File.*;

public class Main 
{
    public static void main(String arg[])
    {
        IPrgStateRepo repository1 = new PrgStateRepo(prg1(), "prg1.txt");
        Controller controller1 = new Controller(repository1);
        IPrgStateRepo repository2 = new PrgStateRepo(prg2(), "prg2.txt");
        Controller controller2 = new Controller(repository2);
        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1", prg1().getStatement().toString(), controller1));
        menu.addCommand(new RunExample("2", prg2().getStatement().toString(), controller2));
        menu.show();
    }

    private static PrgState prg1()
    {
        //a=5;
        //if (a-5) then
        //    print(1);
        //else
        //    print(2);
        //print((5+7)a);

        Statement ex1 = new CompStmt(
                new AssignStmt("a", new ConstExpr(5)),
                new CompStmt(
                        new IfStmt(
                                new ArithmeticExpr(
                                        '-',
                                        new VarExpr("a"),
                                        new ConstExpr(5)
                                ),
                                new PrintStmt(new ConstExpr(1)),
                                new PrintStmt(new ConstExpr(2))
                        ),
                        new PrintStmt(
                                new ArithmeticExpr(
                                        '*',
                                        new ArithmeticExpr(
                                                '+',
                                                new ConstExpr(5),
                                                new ConstExpr(7)
                                        ),
                                        new VarExpr("a")
                                )
                        )
                )
        );
        IExecStack<Statement> stack = new ExeStack<>();
        IDictionary<String, Integer> dict = new Dictionary<>();
        IList<Integer> l = new outputList<>();
        FileTable ft = new FileTable();
        stack.push(ex1);
        PrgState state = new PrgState(stack, dict, l, ex1, ft);
        return state;
    }

    private static PrgState prg2()
    {
        /*
        a=2-2;
        If a Then
            v=2
        Else
            v=3;
        Print(v)
         */
        Statement ex2 = new CompStmt(
                new AssignStmt("a",
                        new ArithmeticExpr('-',
                                new ConstExpr(2),
                                new ConstExpr(2))),
                new CompStmt(
                        new IfStmt(
                                new VarExpr("a"),
                                new AssignStmt("v",
                                        new ConstExpr(2)),
                                new AssignStmt("v",
                                        new ConstExpr(3))),
                        new PrintStmt(
                                new VarExpr("v"))));
        IExecStack<Statement> stack = new ExeStack<>();
        IDictionary<String, Integer> dict = new Dictionary<>();
        IList<Integer> l = new outputList<>();
        FileTable ft = new FileTable();
        stack.push(ex2);
        PrgState state = new PrgState(stack, dict, l, ex2, ft);
        return state;
    }
}

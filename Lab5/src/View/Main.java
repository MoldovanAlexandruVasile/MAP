/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package View;
import Model.Command.*;
import Model.Expression.*;
import Model.Heap.*;
import Model.*;
import Controller.*;
import Repository.*;
import Model.Statement.*;
import Model.File.*;

public class Main {

    public static void main(String arg[])
    {
        IPrgStateRepo repository1 = new PrgStateRepo(prg1(), "prg1.txt");
        Controller controller1 = new Controller(repository1);
        IPrgStateRepo repository2 = new PrgStateRepo(prg2(), "prg2.txt");
        Controller controller2 = new Controller(repository2);
        IPrgStateRepo repository3 = new PrgStateRepo(prg3(), "prg3.txt");
        Controller controller3 = new Controller(repository3);
        /PrgStateRepo repository4 = new PrgStateRepo(prg4(), "prg4.txt");
        Controller controller4 = new Controller(repository4);
        IPrgStateRepo repository5 = new PrgStateRepo(prg5(), "prg5.txt");
        Controller controller5 = new Controller(repository5);
        IPrgStateRepo repository6 = new PrgStateRepo(prg6(), "prg6.txt");
        Controller controller6 = new Controller(repository6);
        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "Exit"));
        menu.addCommand(new RunExample("1", prg1().getStatement().toString(), controller1));
        menu.addCommand(new RunExample("2", prg2().getStatement().toString(), controller2));
        menu.addCommand(new RunExample("3", prg3().getStatement().toString(), controller3));
        menu.addCommand(new RunExample("4", prg4().getStatement().toString(), controller4));
        menu.addCommand(new RunExample("5", prg5().getStatement().toString(), controller5));
        menu.addCommand(new RunExample("6", prg3().getStatement().toString(), controller6));
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
        stack.push(ex1);
        PrgState state = new PrgState(stack, dict, l, ex1, new FileTable<>(), new Heap<>());
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
        stack.push(ex2);
        PrgState state = new PrgState(stack, dict, l, ex2, new FileTable<>(), new Heap<>());
        return state;
    }

    private static PrgState prg3()
    {
        //v = 10;
        //newH(v,20);
        //newH(a,22);
        //wH(a,30);
        //print(a);
        //print(rH(a));
        //a = 0

        Statement ex3 = new CompStmt(
                            new CompStmt(
                                    new CompStmt(
                                            new AssignStmt("v", new ConstExpr(10)),
                                            new NewHeap("v", new ConstExpr(20))
                                    ),
                                    new CompStmt(
                                            new NewHeap("a", new ConstExpr(22)),
                                            new WriteHeap("a", new ConstExpr(30))
                                    )
                            ),
                            new CompStmt(
                                    new CompStmt(
                                            new PrintStmt(new VarExpr("a")),
                                            new PrintStmt(new ReadHeap("a"))
                                    ),
                                    new AssignStmt("a", new ConstExpr(0))
                            )
        );
        IExecStack<Statement> stack = new ExeStack<>();
        IDictionary<String, Integer> dict = new Dictionary<>();
        IList<Integer> l = new outputList<>();
        stack.push(ex3);
        PrgState state = new PrgState(stack, dict, l, ex3, new FileTable<>(), new Heap<>());
        return state;
    }

    private static PrgState prg4()
    {
        //open(a,"a.txt")
        //open(b,"b.txt")
        //open(c,"c.txt")
        //open(d,"d.txt")
        //open(e,"e.txt")
        //open(f,"f.txt")
        //open(g,"g.txt")
        //read(g,h)

        Statement ex4 = new CompStmt(
                                new CompStmt(
                                        new OpenFile("a", "a.txt"),
                                        new OpenFile("b", "b.txt")
                                ),
                                new CompStmt(
                                        new OpenFile("c", "c.txt"),
                                        new OpenFile("d", "d.txt")
                                )
                        );

        IExecStack<Statement> stack = new ExeStack<>();
        IDictionary<String, Integer> dict = new Dictionary<>();
        IList<Integer> l = new outputList<>();
        stack.push(ex4);
        PrgState state = new PrgState(stack, dict, l, ex4, new FileTable<>(), new Heap<>());
        return state;
    }

    private static PrgState prg5()
    {
        // v=6;
        // (while (v!=4) print(v);v=v-1);
        // print(v)

        Statement ex5 = new CompStmt(
                            new CompStmt(
                                    new AssignStmt("v", new ConstExpr(6)),
                                    new WhileStmt(
                                            new DifferentExpr(
                                                    new VarExpr("v"),
                                                    new ConstExpr(4)),
                                            new CompStmt(
                                                    new PrintStmt(new VarExpr("v")),
                                                    new AssignStmt("v",
                                                            new ArithmeticExpr('-',
                                                                    new VarExpr("v"),
                                                                    new ConstExpr(1)))
                                            )
                                    )
                            ),
                            new PrintStmt(new VarExpr("v"))
        );
        IExecStack<Statement> stack = new ExeStack<>();
        IDictionary<String, Integer> dict = new Dictionary<>();
        IList<Integer> l = new outputList<>();
        stack.push(ex5);
        PrgState state = new PrgState(stack, dict, l, ex5, new FileTable<>(), new Heap<>());
        return state;
    }
    private static PrgState prg6()
    {
        // x = 10 + (2<6) it should evaluate the statement to 11

        Statement ex6 = new AssignStmt("x",
                            new ArithmeticExpr('+',
                                    new ConstExpr(10),
                                    new LessExpr(
                                            new ConstExpr(2),
                                            new ConstExpr(6))));
        IExecStack<Statement> stack = new ExeStack<>();
        IDictionary<String, Integer> dict = new Dictionary<>();
        IList<Integer> l = new outputList<>();
        stack.push(ex6);
        PrgState state = new PrgState(stack, dict, l, ex6, new FileTable<>(), new Heap<>());
        return state;
    }
}


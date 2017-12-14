/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package View;
import Model.*;
import Controller.*;
import Model.Command.*;
import Model.Heap.Heap;
import Model.Heap.NewHeap;
import Model.Heap.ReadHeap;
import Model.Heap.WriteHeap;
import Repository.*;
import Model.Statement.*;
import Model.File.*;
import Model.Expression.*;

public class Main {

    public static void main(String arg[])
    {
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(prg1());
        IPrgStateRepo repository1 = new PrgStateRepo(new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 1), "prg1.txt");
        Controller controller1 = new Controller(repository1);

        IExecStack<Statement> stack2 = new ExeStack<>();
        IDictionary<String, Integer> dict2 = new Dictionary<>();
        IList<Integer> l2 = new outputList<>();
        stack2.push(prg2());
        IPrgStateRepo repository2 = new PrgStateRepo(new PrgState(stack2, dict2, l2, new FileTable<>(), new Heap<>(), 2), "prg2.txt");
        Controller controller2 = new Controller(repository2);

        IExecStack<Statement> stack3 = new ExeStack<>();
        IDictionary<String, Integer> dict3 = new Dictionary<>();
        IList<Integer> l3 = new outputList<>();
        stack3.push(prg3());
        IPrgStateRepo repository3 = new PrgStateRepo(new PrgState(stack3, dict3, l3, new FileTable<>(), new Heap<>(), 3), "prg3.txt");
        Controller controller3 = new Controller(repository3);

        IExecStack<Statement> stack4 = new ExeStack<>();
        IDictionary<String, Integer> dict4 = new Dictionary<>();
        IList<Integer> l4 = new outputList<>();
        stack4.push(prg4());
        IPrgStateRepo repository4 = new PrgStateRepo(new PrgState(stack4, dict4, l4, new FileTable<>(), new Heap<>(), 4), "prg4.txt");
        Controller controller4 = new Controller(repository4);

        IExecStack<Statement> stack5 = new ExeStack<>();
        IDictionary<String, Integer> dict5 = new Dictionary<>();
        IList<Integer> l5 = new outputList<>();
        stack5.push(prg5());
        IPrgStateRepo repository5 = new PrgStateRepo(new PrgState(stack5, dict5, l5, new FileTable<>(), new Heap<>(), 5), "prg5.txt");
        Controller controller5 = new Controller(repository5);

        IExecStack<Statement> stack6 = new ExeStack<>();
        IDictionary<String, Integer> dict6 = new Dictionary<>();
        IList<Integer> l6 = new outputList<>();
        stack6.push(prg6());
        IPrgStateRepo repository6 = new PrgStateRepo(new PrgState(stack6, dict6, l6, new FileTable<>(), new Heap<>(), 6), "prg6.txt");
        Controller controller6 = new Controller(repository6);

        IExecStack<Statement> stack7 = new ExeStack<>();
        IDictionary<String, Integer> dict7 = new Dictionary<>();
        IList<Integer> l7 = new outputList<>();
        stack7.push(prg7());
        IPrgStateRepo repository7 = new PrgStateRepo(new PrgState(stack7, dict7, l7, new FileTable<>(), new Heap<>(), 7), "prg7.txt");
        Controller controller7 = new Controller(repository7);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "Exit"));
        menu.addCommand(new RunExample("1", prg1().toString(), controller1));
        menu.addCommand(new RunExample("2", prg2().toString(), controller2));
        menu.addCommand(new RunExample("3", prg3().toString(), controller3));
        menu.addCommand(new RunExample("4", prg4().toString(), controller4));
        menu.addCommand(new RunExample("5", prg5().toString(), controller5));
        menu.addCommand(new RunExample("6", prg6().toString(), controller6));
        menu.addCommand(new RunExample("7", prg7().toString(), controller7));
        menu.show();
    }

    private static Statement prg1()
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
        return ex1;
    }

    private static Statement prg2()
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
        return ex2;
    }

    private static Statement prg3()
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
        return ex3;
    }

    private static Statement prg4()
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
        return ex4;
    }

    private static Statement prg5()
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
        return ex5;
    }

    private static Statement prg6()
    {
        // x = 10 + (2<6) it should evaluate the statement to 11

        Statement ex6 = new AssignStmt("x",
                            new ArithmeticExpr('+',
                                    new ConstExpr(10),
                                    new LessExpr(
                                            new ConstExpr(2),
                                            new ConstExpr(6))));
        return ex6;
    }

    private static Statement prg7()
    {
        //v=10;
        //newH(a,22);
        //fork(wH(a,30);v=32;print(v);print(rH(a)));
        //print(v);
        //print(rH(a))

        Statement ex7 = new CompStmt(
                new CompStmt(
                        new CompStmt(
                                new AssignStmt("v",new ConstExpr(10)),
                                new NewHeap("a",new ConstExpr(22))
                        ),
                        new ForkStmt(
                                new CompStmt(
                                        new CompStmt(
                                                new WriteHeap("a", new ConstExpr(30)),
                                                new AssignStmt("v",new ConstExpr(32))
                                        ),
                                        new CompStmt(
                                                new PrintStmt(new VarExpr("v")),
                                                new PrintStmt(new ReadHeap("a"))
                                        )
                                )
                        )
                ),
                new CompStmt(
                        new PrintStmt(new VarExpr("v")),
                        new PrintStmt(new ReadHeap("a"))
                )
        );
        return ex7;
    }
}


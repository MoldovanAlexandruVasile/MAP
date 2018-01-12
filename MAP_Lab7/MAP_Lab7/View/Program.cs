using MAP_Lab7.Model;
using MAP_Lab7.Statements;
using MAP_Lab7.Expressions;
using MAP_Lab7.Repository;
using MAP_Lab7.ControllerFile;
using MAP_Lab7.Commands;
using MAP_Lab7.View;
using MAP_Lab7.Files;

namespace MAP_Lab7
{
    class Program
    {
        static void Main(string[] args)
        {
            IPrgStateRepo repository1 = new ProgStateRepo(prg1(), "E:\\Programe\\Visual Studio\\Programe\\MAP_Lab7\\prg1.txt");
            Controller controller1 = new Controller(repository1);
            IPrgStateRepo repository2 = new ProgStateRepo(prg2(), "E:\\Programe\\Visual Studio\\Programe\\MAP_Lab7\\prg2.txt");
            Controller controller2 = new Controller(repository2);
            IPrgStateRepo repository3 = new ProgStateRepo(prg3(), "E:\\Programe\\Visual Studio\\Programe\\MAP_Lab7\\prg3.txt");
            Controller controller3 = new Controller(repository3);
            IPrgStateRepo repository4 = new ProgStateRepo(prg4(), "E:\\Programe\\Visual Studio\\Programe\\MAP_Lab7\\prg4.txt");
            Controller controller4 = new Controller(repository4);
            TextMenu menu = new TextMenu();
            menu.AddCommand(new ExitCommand("0", ". Exit"));
            menu.AddCommand(new RunCommand("1", ". " + prg1().Stmt.ToString(), controller1));
            menu.AddCommand(new RunCommand("2", ". " + prg2().Stmt.ToString(), controller2));
            menu.AddCommand(new RunCommand("3", ". " + prg3().Stmt.ToString(), controller3));
            menu.AddCommand(new RunCommand("4", ". " + prg4().Stmt.ToString(), controller4));
            menu.Show();
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
            IExeStack<Statement> stack = new ExeStack<Statement>();
            IDictionaryy<string, int> dict = new Dictionaryy<string, int>();
            IListt<int> l = new outputList<int>();
            FileTable<int, FileData> ft = new FileTable<int, FileData>();
            stack.PushS(ex1);
            PrgState state = new PrgState(dict, stack, l, ex1, ft);
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
            IExeStack<Statement> stack = new ExeStack<Statement>();
            IDictionaryy<string, int> dict = new Dictionaryy<string, int>();
            IListt<int> l = new outputList<int>();
            FileTable<int, FileData> ft = new FileTable<int, FileData>();
            stack.PushS(ex2);
            PrgState state = new PrgState(dict, stack, l, ex2, ft);
            return state;
        }
        private static PrgState prg3()
        {
            //a = 2 + 3 * 5
            //b = a + 1
            //Print(b)
            Statement ex3 = new CompStmt(
                                    new CompStmt(new AssignStmt("a", 
                                                                new ArithmeticExpr('+',
                                                                new ConstExpr(2), 
                                                                new ArithmeticExpr('*', 
                                                                                   new ConstExpr(3), 
                                                                                   new ConstExpr(5)
                                                                ))), 
                                                new AssignStmt("b", 
                                                               new ArithmeticExpr('+', 
                                                                                  new VarExpr("a"),
                                                                                  new ConstExpr(1)))), 
                                    new PrintStmt(new VarExpr("b")));
            IExeStack<Statement> stack = new ExeStack<Statement>();
            IDictionaryy<string, int> dict = new Dictionaryy<string, int>();
            IListt<int> l = new outputList<int>();
            FileTable<int, FileData> ft = new FileTable<int, FileData>();
            stack.PushS(ex3);
            PrgState state = new PrgState(dict, stack, l, ex3, ft);
            return state;
        }
        private static PrgState prg4()
        {
            //open(a,"a.txt")
            //open(b,"b.txt")
            //open(c,"c.txt")
            //open(d,"d.txt")

            Statement ex4 = new CompStmt(
                                    new CompStmt(
                                            new OpenFile("a", "E:\\Programe\\Visual Studio\\Programe\\MAP_Lab7\\a.txt"),
                                            new OpenFile("b", "E:\\Programe\\Visual Studio\\Programe\\MAP_Lab7\\b.txt")
                                    ),
                                    new CompStmt(
                                            new OpenFile("c", "E:\\Programe\\Visual Studio\\Programe\\MAP_Lab7\\c.txt"),
                                            new OpenFile("d", "E:\\Programe\\Visual Studio\\Programe\\MAP_Lab7\\d.txt")
                                    )
                            );
            IExeStack<Statement> stack = new ExeStack<Statement>();
            IDictionaryy<string, int> dict = new Dictionaryy<string, int>();
            IListt<int> l = new outputList<int>();
            FileTable<int, FileData> ft = new FileTable<int, FileData>();
            stack.PushS(ex4);
            PrgState state = new PrgState(dict, stack, l, ex4, ft);
            return state;
        }
    }
}

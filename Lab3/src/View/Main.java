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

import java.io.BufferedReader;
import java.io.FileReader;

public class Main
{
    public static void main(String arg[])
    {
        try
        {
            //LAB 2
            //Example 1
            // v = 2
            // Print(v)
            //Statement s = new CompStmt(new AssignStmt("v", new ConstExpr(2)),new PrintStmt(new VarExpr("v")));


            //Example 2
            // a = 2 + 3 * 5;
            // b = a - 4 / 2 + 7
            //Statement s = new AssignStmt("a", new ArithmeticExpr('+', new ConstExpr(2),new ArithmeticExpr('*', new ConstExpr(3), new ConstExpr(5))));
            //Statement s2 = new AssignStmt("b", new ArithmeticExpr('-', new VarExpr("a"), new ArithmeticExpr('+', new ArithmeticExpr('/', new ConstExpr(4), new ConstExpr(2)), new ConstExpr(7))));


            //Example 3
            // a = 2 - 2
            // IF (a) THEN v = 2 ELSE v = 3
            //Statement s = new AssignStmt( "a", new ArithmeticExpr('-', new ConstExpr(2), new ConstExpr(2)));
            //Statement s2 = new CompStmt(new IfStmt(new VarExpr("a"), new AssignStmt("v",new ConstExpr(2)), new AssignStmt("v",new ConstExpr(3))), new PrintStmt(new VarExpr("v")));


            //Inexistent Symbol exception
            //Statement s = new AssignStmt("a", new ArithmeticExpr(',', new ConstExpr(2), new ConstExpr(3)));


            //Div by zero exception
            //Statement s = new AssignStmt("a", new ArithmeticExpr('/', new ConstExpr(2), new ConstExpr(0)));





            //LAB 3
            /*
            openRFile(var_f,"test.in");
            readFile(var_f,var_c);
            print(var_c);
            if var_c then
                readFile(var_f,var_c);
                print(var_c);
            else
                print(0);
            closeRFile(var_f);
            */

            IExecStack<Statement> execStack = new ExeStack<>();
            IDictionary<String,Integer> dict = new Dictionary<>();
            IList<Integer> l = new outputList<>();
            FileTable ft = new FileTable();
            Statement s = new CompStmt(
                    new OpenFile("var_f", "test.in"),
                    new CompStmt(
                            new readFile(
                                    new VarExpr("var_f"),"var_c"),
                            new CompStmt(
                                    new PrintStmt(new VarExpr("var_c")),
                                    new CompStmt(
                                            new IfStmt(
                                                    new VarExpr("var_c"),
                                                    new CompStmt(
                                                            new readFile(new VarExpr("var_f"), "var_c"),
                                                            new PrintStmt(new VarExpr("var_c"))
                                                    ),
                                                    new PrintStmt(new ConstExpr(0))
                                            ),
                                            new closeFile(new VarExpr("var_f"))
                                    )
                            )
                    )
            );


            execStack.push(s);
            //execStack.push(s2);


            PrgState state = new PrgState(execStack, dict, l, s, ft);
            IPrgStateRepo repo = new PrgStateRepo("E:\\Programe\\IntelliJ IDEA 2017.2.5\\Projects\\Lab3\\Expressions.txt");
            repo.addPrgState(state);
            Controller c = new Controller(repo);
            //c.executeOneStep();
            //c.executeOneStep();
            c.executeAll();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

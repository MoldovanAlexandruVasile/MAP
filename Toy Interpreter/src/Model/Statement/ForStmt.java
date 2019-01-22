package Model.Statement;

import Model.Exception.DivByZeroException;
import Model.Exception.EvaluationException;
import Model.Exception.InexistentSymbolException;
import Model.Expression.Expression;
import Model.Expression.LessExpr;


public class ForStmt implements Statement {
    private Statement statement;
    private Expression expr1,expr2,expr3,expr4;
    public ForStmt(Expression e1,Expression e2, Expression e3, Expression e4, Statement s)
    {
        statement = s;
        expr1 = e1;
        expr2 = e2;
        expr3 = e3;
        expr4 = e4;
    }

    @Override
    public PrgState execute(PrgState p)
    {
        try
        {
            if(expr3.Eval(p.getSymbolT(),p.getHeap()) != 0)
            {
                p.getExecStack().push(new CompStmt(new AssignStmt(expr1.toString(),expr2),
                                                    new WhileStmt(new LessExpr(expr1,expr3),
                                                                    new CompStmt(statement,
                                                                                new AssignStmt(expr1.toString(),expr4)))));
                return null;
            }
        }
        catch(InexistentSymbolException | DivByZeroException | EvaluationException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String toString()
    {
        return "For("+expr1.toString()+" = "+expr2.toString()+"; "+expr2.toString()+" < "+statement.toString()+"; "+statement.toString()+" = "+expr3.toString()+");";
    }
}

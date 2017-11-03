package Model;

import Expression.Expression;
import Statement.*;
import Exception.DivByZeroException;
import Exception.EvaluationException;
import Exception.InexistentSymbolException;


public class IfStmt implements Statement {

    private Expression exp;
    private Statement thenS;
    private Statement elseS;

    public IfStmt(Expression _exp, Statement _thenS, Statement _elseS) {
        exp = _exp;
        thenS = _thenS;
        elseS = _elseS;
    }

    @Override
    public PrgState execute(PrgState state) {
        IDictionary<String, Integer> dict = state.getSymbolT();
        IExecStack<Statement> stack = state.getExecStack();
        try
        {
            int val = exp.Eval(dict);

            if (val != 0)
                stack.push(thenS);
            else
                stack.push(elseS);

            return state;
        }
        catch( EvaluationException | DivByZeroException | InexistentSymbolException e)
        {
            System.out.println(e.getMessage());
            return state;
        }
    }

    @Override
    public String toString() {
        return "IF(" + exp + ")THEN(" + thenS + ")ELSE(" + elseS + ") ;";
    }
}
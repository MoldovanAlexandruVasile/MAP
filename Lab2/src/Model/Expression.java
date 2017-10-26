package Model;

public interface Expression
{
    public int Eval(IDictionary<String, Integer> d) throws EvaluationException, DivByZeroException, InexistentSymbolException;
}

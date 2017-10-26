package Model;

public class VarExpr implements Expression
{
    private String x;
    public VarExpr(String str)
    {
        x = str;
    }

    public int Eval(IDictionary<String, Integer> d) throws EvaluationException
    {
        if(d.contains(x))
            return d.get(x);
        throw new EvaluationException("Can not be evaluated " + x + " !");
    }

    @Override
    public String toString()
    {
        return "" + x;
    }
}

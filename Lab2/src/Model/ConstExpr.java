
package Model;

public class ConstExpr implements Expression
{
    private int value;
    public ConstExpr(int v)
    {
        value = v;
    }
    public int Eval(IDictionary<String, Integer> d)
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "" + value;
    }
}

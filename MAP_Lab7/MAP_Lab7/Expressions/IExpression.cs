using MAP_Lab7.Model;

namespace MAP_Lab7.Expressions
{
    public interface IExpression
    {
        int Eval(IDictionaryy<string, int> dict);
    }
}

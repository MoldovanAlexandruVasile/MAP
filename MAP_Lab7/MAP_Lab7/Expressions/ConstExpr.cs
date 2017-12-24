using MAP_Lab7.Model;

namespace MAP_Lab7.Expressions
{
    public class ConstExpr : IExpression
    {
        private int cnst;

        public ConstExpr(int c)
        {
            cnst = c;
        }

        public int Eval(IDictionaryy<string, int> dict)
        {
            return cnst;
        }

        public override string ToString()
        {
            return " " + cnst;
        }
    }
}

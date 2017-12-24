using MAP_Lab7.Model;

namespace MAP_Lab7.Expressions
{
    class VarExpr : IExpression
    {
        private string var;

        public VarExpr(string v)
        {
            var = v;
        }

        public int Eval(IDictionaryy<string, int> dict)
        {
            return dict.Get(var);
        }

        public override string ToString()
        {
            return var;
        }
    }
}
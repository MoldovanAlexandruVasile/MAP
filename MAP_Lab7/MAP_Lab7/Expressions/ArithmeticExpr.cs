using MAP_Lab7.Exceptions;
using MAP_Lab7.Model;
using System;

namespace MAP_Lab7.Expressions
{
    public class ArithmeticExpr : IExpression
    {
        private IExpression left;
        private IExpression right;
        private char op;

        public ArithmeticExpr(char o, IExpression l, IExpression r)
        {
            left = l;
            right = r;
            op = o;
        }

        public int Eval(IDictionaryy<string, int> dict)
        {
            try
            {
                int l = left.Eval(dict);
                int r = right.Eval(dict);

                if (op == '+')
                    return l + r;
                if (op == '-')
                    return l - r;
                if (op == '*')
                    return l * r;
                else
                {
                    if (r == 0)
                        throw new DivByZeroException("Division by zero !");
                    else
                        return l / r;
                }
                throw new InexistentSymbolException("Inexistent symbol error !");
            }
            catch (DivByZeroException e)
            {
                Console.WriteLine(e.Message);
            }
            catch (EvaluationException e2)
            {
                Console.WriteLine(e2.Message);
            }
            catch (InexistentSymbolException e3)
            {
                Console.WriteLine(e3.Message);
            }
            return -1;
        }

        public override string ToString()
        {
            return "" + left + ' ' + op + ' ' + right;
        }
    }
}


using System;
using MAP_Lab7.Expressions;
using MAP_Lab7.Statements;
using MAP_Lab7.Exceptions;

namespace MAP_Lab7.Files
{
    public class CloseFile
    {
        private IExpression expr;

        public CloseFile(IExpression e)
        {
            expr = e;
        }

        public PrgState Execute(PrgState state)
        {
            int ID = expr.Eval(state.Dict);

            if (!state.FileTable.Exists(ID))
                throw new FileException("Can not close the file !");

            state.FileTable.Get(ID).Sw.Close();
            state.FileTable.Delete(ID);

            return state;
        }

        public override string ToString()
        {
            return "CloseFile (" + expr + ")";
        }
    }
}

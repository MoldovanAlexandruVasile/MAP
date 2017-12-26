namespace MAP_Lab7.Statements
{
    public class CompStmt:Statement
    {
        private Statement first, second;
        public CompStmt(Statement f, Statement s)
        {
            first = f;
            second = s;
        }

        public PrgState Execute(PrgState state)
        {
            state.ExeStack.PushS(second);
            state.ExeStack.PushS(first);
            return state;
        }

        public override string ToString()
        {
            return "" + first + second;
        }
    }
}

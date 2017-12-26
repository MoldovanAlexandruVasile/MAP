using MAP_Lab7.Files;
using MAP_Lab7.Model;
using System.Text;

namespace MAP_Lab7.Statements
{
    public class PrgState
    {
        private IDictionaryy<string, int> dict;
        private IExeStack<Statement> stack;
        private IListt<int> outputList;
        private Statement stmt;
        private FileTable<int, FileData> fileTable;

        public PrgState(IDictionaryy<string, int> d, IExeStack<Statement> exes, IListt<int> ol, Statement s, FileTable<int, FileData> ft)
        {
            dict = d;
            stack = exes;
            outputList = ol;
            stmt = s;
            fileTable = ft;
        }

        public IDictionaryy<string, int> Dict
        {
            get { return dict; }
            set { dict = value; }
        }

        public Statement Stmt
        {
            get { return stmt; }
            set { stmt = value; }
        }

        public FileTable<int, FileData> FileTable
        {
            get { return fileTable; }
            set { fileTable = value; }
        }

        public IExeStack<Statement> ExeStack
        {
            get { return stack; }
            set { stack = value; }
        }

        public IListt<int> OutputList
        {
            get { return outputList; }
            set { outputList = value; }
        }

        public override string ToString()
        {
            StringBuilder buff = new StringBuilder();
            buff.Append(Dict);
            buff.Append(ExeStack);
            buff.Append(OutputList);
            buff.Append(Stmt);
            buff.Append("\n");
            return buff.ToString();
        }

    }
}

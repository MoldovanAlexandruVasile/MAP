using MAP_Lab7.Statements;
using System;
using System.IO;
using MAP_Lab7.Exceptions;

namespace MAP_Lab7.Files
{
    public class OpenFile : Statement
    {
        private string varName;
        public string fileName;
        private static int ID = 0;

        public OpenFile(string vn, string fn)
        {
            varName = vn;
            fileName = fn;
        }

        public PrgState Execute(PrgState state)
        {
            foreach (FileData i in state.FileTable.AllValues())
                if (i.fileName == fileName)
                    throw new FileException("File is already opened !");

            if (!File.Exists(fileName))
                throw new FileException("File does not exist !");

            StreamReader sw = new StreamReader(fileName, true);
            state.FileTable.Add(ID, new FileData(fileName, sw));
            state.Dict.Update(varName, ID++);

            return state;

        }

        public override string ToString()
        {
            return "Open(" + fileName + ")";

        }
    }
}

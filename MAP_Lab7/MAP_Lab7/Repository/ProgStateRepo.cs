using System.IO;
using System.Collections.Generic;
using MAP_Lab7.Statements;
using MAP_Lab7.Files;

namespace MAP_Lab7.Repository
{
    public class ProgStateRepo : IPrgStateRepo
    {
        private string fileName;

        public ProgStateRepo(PrgState state, string fn)
        {
            fileName = fn;
            Add(state);
        }

        private List<PrgState> myList = new List<PrgState>();

        public void Add(PrgState st)
        {
            myList.Add(st);
        }
        public PrgState GetCurrentProgram()
        {
            return myList[0];
        }

        public void logPrgStateExec()
        {
            using (StreamWriter sw = File.AppendText(fileName))
            {
                PrgState state = GetCurrentProgram();
                sw.WriteLine("\nExeStack: ");
                foreach (var i in state.ExeStack)
                {
                    sw.WriteLine(i);
                }

                sw.WriteLine("\nDictionary: ");
                foreach (KeyValuePair<string, int> kvp in state.Dict)
                {
                    sw.WriteLine(kvp.Key + " --> " + kvp.Value);
                }

                sw.WriteLine("\nOutputList: ");
                foreach (var i in state.OutputList)
                {
                    sw.WriteLine(i);
                }

                sw.WriteLine("\nFileTable: ");
                foreach (KeyValuePair<int, FileData> kvp in state.FileTable)
                {
                    sw.WriteLine(kvp.Key + " --> " + kvp.Value.fName);
                }

                sw.WriteLine("\n\n\n");
            }
        }

    }
}

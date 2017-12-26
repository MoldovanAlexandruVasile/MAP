using System.IO;
using System.Collections.Generic;
using MAP_Lab7.Statements;
using MAP_Lab7.Files;
using System;

namespace MAP_Lab7.Repository
{
    public class ProgStateRepo : IPrgStateRepo
    {
        private string fileName;

        public ProgStateRepo(PrgState state, string fn)
        {
            fileName = fn;
            myList.Add(state);
        }

        private List<PrgState> myList = new List<PrgState>();

        public void AddPrgState(PrgState st)
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
                Console.WriteLine("\nExeStack: ");
                foreach (var i in state.ExeStack)
                {
                    sw.WriteLine(i);
                    Console.WriteLine(i);
                }
                Console.WriteLine("\nDictionary: ");
                sw.WriteLine("\nDictionary: ");
                foreach (KeyValuePair<string, int> i in state.Dict)
                {
                    sw.WriteLine(i.Key + " --> " + i.Value);
                    Console.WriteLine(i.Key + " --> " + i.Value);
                }

                sw.WriteLine("\nOutputList: ");
                Console.WriteLine("\nOutputList: ");
                foreach (var i in state.OutputList)
                {
                    sw.WriteLine(i);
                    Console.WriteLine(i);
                }

                Console.WriteLine("\nFile Table: ");
                sw.WriteLine("\nFileTable: ");
                foreach (KeyValuePair<int, FileData> i in state.FileTable)
                {
                    sw.WriteLine(i.Key + " --> " + i.Value.fName);
                    Console.WriteLine(i.Key + " --> " + i.Value.fName);
                }

                sw.WriteLine("------------------------------------------------");
            }
        }

    }
}

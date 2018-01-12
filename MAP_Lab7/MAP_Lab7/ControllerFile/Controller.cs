using MAP_Lab7.Statements;
using MAP_Lab7.Repository;
using MAP_Lab7.Model;
using MAP_Lab7.Exceptions;
using System;

namespace MAP_Lab7.ControllerFile
{
    public class Controller
    {
        private IPrgStateRepo repo;

        public Controller(IPrgStateRepo r)
        {
            repo = r;
        }
        
        public void executeOneStep()
        {
            PrgState ps = repo.GetCurrentProgram();
            IExeStack<Statement> ex = ps.ExeStack;
            if (!ex.IsEmpty())
            {
                Statement stmt = ex.PopS();
                stmt.Execute(ps);
            }
            Console.WriteLine("----------------------------------------------\n\n");
        }

        public void executeAll()
        {
            PrgState ps = repo.GetCurrentProgram();
            IExeStack<Statement> es = ps.ExeStack;
            while (!es.IsEmpty())
            {
                try
                {
                    executeOneStep();
                    repo.logPrgStateExec();
                }
                catch(FileException e)
                {
                    Console.WriteLine(e.Message);
                } 
            }
            Console.WriteLine("----------------------------------------------\n\n");
        }
    }
}
using MAP_Lab7.Statements;
using MAP_Lab7.Repository;
using MAP_Lab7.Model;
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
                executeOneStep();
                repo.logPrgStateExec();
            }
            Console.WriteLine("----------------------------------------------\n\n");
        }
    }
}
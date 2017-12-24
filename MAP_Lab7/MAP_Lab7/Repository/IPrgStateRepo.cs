using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MAP_Lab7.Statements;

namespace MAP_Lab7.Repository
{
    public interface IPrgStateRepo
    {
        void Add(PrgState st);
        PrgState GetCurrentProgram();
        void logPrgStateExec();
    }
}

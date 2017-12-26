using MAP_Lab7.Statements;

namespace MAP_Lab7.Repository
{
    public interface IPrgStateRepo
    {
        void AddPrgState(PrgState st);
        PrgState GetCurrentProgram();
        void logPrgStateExec();
    }
}

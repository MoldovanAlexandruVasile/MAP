package Repository;
import Model.Statement.PrgState;

public interface IPrgStateRepo
{
    void addPrgState(PrgState st);
    PrgState getCurrentProgram();
    void logPrgStateExec();
}

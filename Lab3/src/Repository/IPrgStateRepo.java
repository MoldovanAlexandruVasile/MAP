package Repository;
import Statement.PrgState;
import Exception.*;

public interface IPrgStateRepo
{
    void addPrgState(PrgState st);
    PrgState getCurrentProgram();
    void logPrgStateExec() throws InterpretorException;
}

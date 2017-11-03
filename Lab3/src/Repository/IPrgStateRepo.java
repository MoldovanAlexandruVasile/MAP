package Repository;
import Statement.PrgState;
import Exception.*;

public interface IPrgStateRepo
{
    public void addPrgState(PrgState st);
    public PrgState getCurrentProgram();
    public void logPrgStateExec() throws InterpretorException;

}

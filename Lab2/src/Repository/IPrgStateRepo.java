package Repository;
import Statement.PrgState;

public interface IPrgStateRepo
{
    public void addPrgState(PrgState st);
    public PrgState getCurrentProgram();

}

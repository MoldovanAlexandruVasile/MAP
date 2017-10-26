package Repository;
import Model.*;

public interface IPrgStateRepo
{
    public void addPrgState(PrgState st);
    public PrgState getCurrentProgram();

}

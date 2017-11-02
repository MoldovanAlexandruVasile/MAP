package Repository;
import Statement.PrgState;

import java.util.ArrayList;
import java.util.List;

public class PrgStateRepo implements IPrgStateRepo
{
    private List<PrgState> myList = new ArrayList<>();
    public void addPrgState(PrgState st)
    {
        myList.add(st);
    }
    public PrgState getCurrentProgram()
    {
        return myList.get(0);
    }
}

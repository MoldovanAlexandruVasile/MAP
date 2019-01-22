/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Repository;
import Model.Statement.PrgState;
import javafx.collections.ObservableList;

import java.util.List;

public interface IPrgStateRepo
{
    void addPrgState(PrgState st);
    PrgState getCurrentProgram();
    void logPrgStateExec(PrgState prgState);
    List<PrgState> getPrgList();
    void setPrgList(List<PrgState> list);
    ObservableList<String> getIDs();
}

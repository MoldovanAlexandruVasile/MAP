/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Controller;

//import Model.Heap.IHeap;
//import java.util.Map;
import Repository.*;
import Model.Statement.PrgState;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Controller
{
    private IPrgStateRepo repo;
    private ExecutorService executor;
    public Controller(IPrgStateRepo r){repo = r;}

/*
    private Map<Integer, Integer> conservativeGarbageCollector(List<PrgState> list)
    {
        return list.get(0).getHeap().getContent().entrySet().stream()
                .filter(e -> {
                            for (PrgState prgState : list)
                            {
                                if (prgState.getSymbolT().getValues().contains(e.getKey()))
                                    return true;
                            }
                            return false;
                        }
                )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
*/

    private List<PrgState> removeCompletedPrg(List<PrgState> inPrgList)
    {
        return inPrgList.stream()
                .filter(p -> p.isNotCompleted())
                .collect(Collectors.toList());
    }

    private void oneStepForAllPrg(List<PrgState> prgList)
    {

        List<Callable<PrgState>> callList = prgList.stream()
                .map((PrgState p) -> (Callable<PrgState>) (p::oneStep))
                .collect(Collectors.toList());
        try
        {
            List<PrgState> newPrgList = executor.invokeAll(callList).stream()
                    .map(future ->
                    {
                        try
                        {
                            return future.get();
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                        return null;
                    })
                    .filter(p -> p != null)
                    .collect(Collectors.toList());

            prgList.addAll(newPrgList);
            prgList.forEach(prg ->repo.logPrgStateExec(prg));
            repo.setPrgList(prgList);
        }
        catch(Exception e){System.out.println(e.getMessage());}
    }

    public void allSteps()
    {
        executor = Executors.newFixedThreadPool(2);
        List<PrgState> prgList = removeCompletedPrg(repo.getPrgList());

        while(prgList.size() > 0)
        {
            oneStepForAllPrg(prgList);
            prgList = removeCompletedPrg(repo.getPrgList());
        }
        oneStepForAllPrg(prgList);
        prgList = removeCompletedPrg(repo.getPrgList());

        executor.shutdownNow();
        repo.setPrgList(prgList);
    }

}
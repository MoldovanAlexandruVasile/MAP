package Controller;
import Repository.*;
import Model.*;
import Model.Statement.*;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller
{
    private IPrgStateRepo ipsr;
    public Controller(IPrgStateRepo ip)
    {
        ipsr = ip;
    }

    Map<Integer, Integer> garbageCollector(Collection<Integer> systemTable, Map<Integer, Integer> heap)
    {
        return heap.entrySet().stream()
                .filter(e -> systemTable.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void executeOneStep()
    {
        PrgState ps = ipsr.getCurrentProgram();
        IExecStack<Statement> ex = ps.getExecStack();
        if(! ex.isEmpty())
        {
            Statement instr = ex.pop();
            instr.execute(ps);
            System.out.println(ps);

        }
        System.out.println("----------------------------------------------");
    }
    public void executeAll()
    {
        PrgState ps = ipsr.getCurrentProgram();
        IExecStack<Statement> es = ps.getExecStack();
        while(! es.isEmpty())
        {
            executeOneStep();
            ps.getHeap().setContent(garbageCollector(ps.getSymbolT().getValues(), ps.getHeap().getContent()));
            ipsr.logPrgStateExec();
        }
        System.out.println("=======================================================");
    }

    public void add(PrgState prgState){
        ipsr.addPrgState(prgState);
    }
}
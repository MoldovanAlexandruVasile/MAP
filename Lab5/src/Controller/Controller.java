package Controller;

import Model.File.closeFile;
import Repository.*;
import Model.*;
import Model.Statement.*;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller
{
    private IPrgStateRepo ipsr;
    public Controller(IPrgStateRepo ip)
    {
        ipsr = ip;
    }

    private Map<Integer, Integer> garbageCollector(Collection<Integer> systemTable, Map<Integer, Integer> heap)
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
        try
        {
            while (!es.isEmpty())
            {
                executeOneStep();
                ps.getHeap().setContent(garbageCollector(ps.getSymbolT().getValues(), ps.getHeap().getContent()));
                ipsr.logPrgStateExec();
            }
        }
        catch(EmptyStackException e)
        {
            System.out.println("");
        }
        finally
        {
            ps.getFileTable().getValues().forEach(e ->
            {
                try
                {
                    e.getHeader().close();
                }
                catch (IOException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            );
        }

        System.out.println("=======================================================");
    }

    public void add(PrgState prgState){
        ipsr.addPrgState(prgState);
    }
}
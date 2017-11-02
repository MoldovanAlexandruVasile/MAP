package Repository;

import Statement.*;
import Model.*;
import Exception.*;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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


    private String fileName;
    public void logPrgStateExec() throws InterpretorException
    {
        PrgState state = getCurrentProgram();
        try (PrintWriter log = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));)
        {
            log.println("ExeStack:");
            for(Statement st: state.getExecStack().getAll())
                log.println(st);

            log.println("Symbol table: ");
            IDictionary<String, Integer> dict = state.getSymbolT();
            for(String key: dict.getAll())
                log.println(key + "->" + dict.get(key));
            log.println("Output list: ");
            for(it v : state.getOutputList().getAll())
                log.println(v);
        }
        catch(IOException ex) {throw new InterpretorException(ex.toString());}
    }
}

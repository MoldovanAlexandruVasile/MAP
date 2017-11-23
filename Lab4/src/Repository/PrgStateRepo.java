package Repository;

import Model.IDictionary;
import Model.Statement.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public PrgStateRepo(PrgState program, String fName)
    {
        fileName = fName;
        myList.add(program);
    }

    public void logPrgStateExec()
    {
        PrgState state = getCurrentProgram();
        try (PrintWriter log = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true))))
        {
            log.print("\nExecStack:\n");
            for (Statement s : state.getExecStack().getAll())
            {
                log.print(s+"\n");
            }

            log.print("\nSymbolTable:\n");
            IDictionary<String,Integer> dict = state.getSymbolT();
            for (String s : dict.getKeys())
            {
                log.print(s+"-->"+dict.get(s)+"\n");
            }

            log.print("\nOutputList:\n");
            for (Integer s : state.getList().getAll())
            {
                log.print(s+"\n");
            }

            log.print("\nHeap:\n");
            for (Map.Entry<Integer,Integer> entry : state.getHeap().getContent().entrySet())
            {
                log.print(entry.getKey()+"-->"+entry.getValue()+"\n");
            }

            log.print("----------------------------------------------------------------------------");

        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}

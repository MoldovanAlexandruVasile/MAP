/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Repository;

import Model.Exception.FileException;
import Model.File.OpenFile;
import Model.IDictionary;
import Model.Statement.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgStateRepo implements IPrgStateRepo
{
    private String fileName;

    private List<PrgState> myList = new ArrayList<>();

    public void addPrgState(PrgState st)
    {
        myList.add(st);
    }
    public PrgState getCurrentProgram()
    {
        return myList.get(0);
    }

    public PrgStateRepo() { }

    public PrgStateRepo(String fname)
    {
        fileName = fname;
    }

    public PrgStateRepo(PrgState program, String fName)
    {
        fileName = fName;
        myList.add(program);
    }

    public ObservableList<String> getIDs(){
        ObservableList<String> items = FXCollections.observableArrayList();
        for(PrgState prgs : getPrgList())
            items.add(String.valueOf(prgs.getID()));
        return items;
    }

    @Override
    public List<PrgState> getPrgList()
    {
        return myList;
    }

    @Override
    public void setPrgList(List<PrgState> list) {
        myList = list;
    }

    public void logPrgStateExec(PrgState prgState)
    {
        try
        {
            if(!new File(fileName).exists())
                throw new FileException("The file does not exist !");

            PrintWriter log = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            log.print("ID:");
            log.print(prgState.getID()+"\n");
            log.print("ExeStack:\n");
            for (Statement s : prgState.getExecStack().getAll())
            {
                log.print(s + "\n");
            }

            log.print("Symbol Table:\n");
            IDictionary<String,Integer> st = prgState.getSymbolT();
            for (String s : st.getKeys())
            {
                log.print(s + "-->" + st.get(s) + "\n");
            }

            log.print("OutputList:\n");
            for (Integer s : prgState.getList().getAll())
            {
                log.print(s + "\n");
            }

            log.print("Heap:\n");
            for (Map.Entry<Integer,Integer> entry : prgState.getHeap().getContent().entrySet())
            {
                log.print(entry.getKey()+ "-->" + entry.getValue() + "\n");
            }

            log.print("LockTable:\n");
            for (Map.Entry<Integer,Integer> entry : prgState.getLockTable().getContent().entrySet())
            {
                log.print(entry.getKey()+ "-->" + entry.getValue() + "\n");
            }
            log.print("=============================================\n");
            log.close();
        }

        catch(IOException | FileException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}

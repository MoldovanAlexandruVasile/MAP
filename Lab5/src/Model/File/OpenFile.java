/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.File;
import Model.Statement.*;
import Model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenFile implements Statement
{
    private String fileName;
    private String varName;
    public OpenFile(String fl, String vn)
    {
        fileName = fl;
        varName = vn;
    }

    public PrgState execute(PrgState state)
    {
        if(!isOpen(state))
            try
            {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                FileData fd = new FileData(fileName, br);
                int id = IDGenerator.generate_ID();
                state.getFileTable().add(id,fd);
                IDictionary<String, Integer> dict = state.getSymbolT();
                if(dict.contains(varName))
                {
                    dict.update(varName, id);
                }
                else dict.add(varName, id);
            }
            catch(IOException ex)
            {
                System.out.println(ex.toString());
            }
        return state;
    }

    private boolean isOpen(PrgState prg)
    {
        //if (prg.getFileTable())
        for(FileData crt : prg.getFileTable().getValues())
            if(crt.getFileName().equals(fileName))
                return true;
        return false;
    }

    @Override
    public String toString() {
        return "OpenFile{" + "fileName='" + fileName + '\'' + ", varName='" + varName + '\'' + '}';
    }
}
/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.File;
import Model.Exception.FileException;
import Model.Statement.*;
import Model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class OpenFile implements Statement
{
    private String fileName;
    private String varName;
    public OpenFile(String vn, String fl)
    {
        fileName = fl;
        varName = vn;
    }

    @Override
    public PrgState execute(PrgState state)
    {
        if(!isOpen(state))
            try
            {
                if(!new File(fileName).exists())
                    throw new FileException("The file does not exist !");

                BufferedReader br = new BufferedReader(new FileReader(fileName));
                FileData fd = new FileData(fileName, br);
                int id = IDGenerator.generate_ID();
                state.getFileTable().add(id, fd);
                IDictionary<String, Integer> dict = state.getSymbolT();
                if(dict.contains(varName))
                {
                    dict.update(varName, id);
                }
                else dict.add(varName, id);
            }
            catch(IOException | FileException ex)
            {
                System.out.println(ex.getMessage());
            }
        return state;
    }

    private boolean isOpen(PrgState prg)
    {
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
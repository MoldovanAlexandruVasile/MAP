/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package File;
import Statement.*;
import Exception.*;
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

    public PrgState execute(PrgState state) throws InterpretorException
    {
        if(isOpen(state))
            throw new InterpretorException("Interpretor exception !");
        else
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
            catch(IOException ex) {throw new InterpretorException(ex.toString());}
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
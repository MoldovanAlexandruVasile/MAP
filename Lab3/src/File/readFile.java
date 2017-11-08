/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package File;
import Statement.*;
import Expression.*;
import Exception.*;
import jdk.jshell.EvalException;

import java.io.IOException;

public class readFile implements Statement {
    private Expression fileID;
    private String varName;

    public readFile(Expression fID, String vName) {
        fileID = fID;
        varName = vName;
    }

    @Override
    public PrgState execute(PrgState prgState)
    {
        String line;
        try
        {
            line = prgState.getFileTable().find(fileID.Eval(prgState.getSymbolT())).getHeader().readLine();
            if (line == null) {
                prgState.getSymbolT().add(varName, 0);
                return prgState;
            }
            prgState.getSymbolT().add(varName, Integer.parseInt(line));
            return prgState;
        }
        catch (IOException | NullPointerException | EvaluationException | DivByZeroException | InexistentSymbolException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "readFile(" + fileID + "," + varName + ')';

    }
}

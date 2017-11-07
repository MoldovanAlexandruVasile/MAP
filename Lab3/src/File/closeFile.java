/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package File;
import Statement.*;
import Exception.*;
import Expression.*;
import java.io.IOException;

public class closeFile implements Statement {

    private Expression fileID;

    public closeFile(Expression fID) {
        fileID = fID;
    }

    public PrgState execute(PrgState prgState) throws InterpretorException {
        try {
            int exp = fileID.Eval(prgState.getSymbolT());
            if (prgState.getFileTable().contains(exp)) {
                prgState.getFileTable().find(exp).getHeader().close();
                prgState.getFileTable().remove(exp);
            } else
                throw new RuntimeException();
        }
        catch (IOException | DivByZeroException | InexistentSymbolException | EvaluationException e){
            throw new RuntimeException();
        }
        return prgState;
    }

    @Override
    public String toString() { return "closeFile("+fileID +')'; }
}


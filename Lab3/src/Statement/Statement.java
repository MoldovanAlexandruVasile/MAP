/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Statement;
import Exception.*;

public interface Statement
{
    public PrgState execute(PrgState p) throws InterpretorException;
}

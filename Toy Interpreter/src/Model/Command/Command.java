/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model.Command;

public abstract class Command
{
    private String key,description;

    public Command(String k, String descr)
    {
        key = k;
        description = descr;
    }

    public abstract void execute();

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }
}

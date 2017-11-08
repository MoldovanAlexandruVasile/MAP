/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model;

public class ExitCommand extends Command {

    public ExitCommand(String key, String description)
    {
        super(key, description);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}

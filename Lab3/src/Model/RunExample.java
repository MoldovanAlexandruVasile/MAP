/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model;

import Controller.*;

public class RunExample extends Command
{
    private Controller controller;

    public RunExample(String key, String description, Controller ctrl)
    {
        super(key, description);
        this.controller = ctrl;
    }

    @Override
    public void execute()
    {
        try
        {
            controller.executeAll();
        }
        catch(RuntimeException e)
        {
            System.out.println("Runtime error !");
        }
    }
}

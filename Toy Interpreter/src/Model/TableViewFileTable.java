/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableViewFileTable
{
    private SimpleIntegerProperty key;
    private SimpleStringProperty name;

    public TableViewFileTable(Integer k, String n)
    {
        key =  new SimpleIntegerProperty(k);
        name =  new SimpleStringProperty(n);
    }

    public int getKey()
    {
        return key.get();
    }

    public SimpleIntegerProperty keyProperty()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key.set(key);
    }

    public String getName()
    {
        return name.get();
    }

    public SimpleStringProperty nameProperty()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name.set(name);
    }
}

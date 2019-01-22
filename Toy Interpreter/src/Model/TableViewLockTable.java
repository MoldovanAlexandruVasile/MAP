/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model;

import javafx.beans.property.SimpleIntegerProperty;

public class TableViewLockTable
{
    private SimpleIntegerProperty identifier;
    private SimpleIntegerProperty value;

    public TableViewLockTable(Integer i, Integer v)
    {
        identifier =  new SimpleIntegerProperty(i);
        value =  new SimpleIntegerProperty(v);
    }

    public int getIdentifier() { return identifier.get(); }

    public SimpleIntegerProperty identifierProperty() { return identifier; }

    public void setIdentifier(int identifier) { this.identifier.set(identifier); }

    public int getValue() { return value.get(); }

    public SimpleIntegerProperty valueProperty() { return value; }

    public void setValue(int value) { this.value.set(value); }
}
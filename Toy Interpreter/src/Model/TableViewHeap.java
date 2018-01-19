/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/
package Model;
import javafx.beans.property.SimpleIntegerProperty;

public class TableViewHeap
{
    private SimpleIntegerProperty address;
    private SimpleIntegerProperty value;

    public TableViewHeap(Integer addr, Integer val)
    {
        address =  new SimpleIntegerProperty(addr);
        value =  new SimpleIntegerProperty(val);
    }

    public int getAddress()
    {
        return address.get();
    }

    public SimpleIntegerProperty addressProperty()
    {
        return address;
    }

    public void setAddress(int address)
    {
        this.address.set(address);
    }

    public int getValue()
    {
        return value.get();
    }

    public SimpleIntegerProperty valueProperty()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value.set(value);
    }
}

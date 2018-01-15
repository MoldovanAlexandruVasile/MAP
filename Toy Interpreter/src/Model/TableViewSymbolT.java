/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class TableViewSymbolT
{
    private SimpleStringProperty varName;
    private SimpleIntegerProperty value;

    public TableViewSymbolT(String vname, Integer val)
    {
        varName =  new SimpleStringProperty(vname);
        value =  new SimpleIntegerProperty(val);
    }

    public String getVarName()
    {
        return varName.get();
    }

    public SimpleStringProperty varNameProperty()
    {
        return varName;
    }

    public void setVarName(String varName)
    {
        this.varName.set(varName);
    }

    public int getValue() {
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

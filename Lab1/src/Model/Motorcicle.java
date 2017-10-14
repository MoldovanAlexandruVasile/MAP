package Model;

public class Motorcicle extends Vehicule
{
    public String name, color;

    public Motorcicle(int cost, String name, String color)
    {
        super(cost);
        this.name = name;
        this.color = color;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public String toString()
    {
        return "\t\tMotorcicle{" + "cost=" + getCost() +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int getCost()
    {
        return super.getCost();
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Motorcicle)
        {
            Motorcicle m = (Motorcicle) obj;
            return m.color.equals(color) && m.name.equals(name);
        }
        return false;
    }
}

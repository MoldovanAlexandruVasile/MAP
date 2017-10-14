package Model;

public class Truck extends Vehicule
{
    private String name, color;

    public Truck(int cost, String name, String color)
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
    public int getCost()
    {
        return super.getCost();
    }

    @Override
    public String toString()
    {
        return "\t\tTruck{" + "cost=" + getCost() +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Truck)
        {
            Truck t = (Truck) obj;
            return t.color.equals(color) && t.name.equals(name);
        }
        return false;
    }
}

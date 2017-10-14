package Model;

public class Car extends Vehicule
{
    private String name, color;

    public Car(int cost, String name, String color)
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
        return "\t\tCar{" + "cost=" + getCost() +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Car)
        {
            Car c = (Car) obj;
            return c.getColor().equals(this.getColor()) && c.getName().equals(this.getName());
        }
        return false;
    }
}

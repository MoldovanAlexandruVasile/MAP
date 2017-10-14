package Model;

public abstract class Vehicule
{
    private int cost;

    public Vehicule(int cost)
    {
        this.cost = cost;
    }

    public int getCost()
    {
        return this.cost;
    }
}

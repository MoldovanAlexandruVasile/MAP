package Controller;

import Model.*;
import Repository.*;

public class Controller
{
    private VehiculeRepository repo;

    public Controller(VehiculeRepository r) { repo = r; }

    public void addVehiculeC(Vehicule v) { repo.addVehicule(v); }

    public void removeVehiculeC(Vehicule v)
    {
        try
        {
            repo.removeVehicule(v);
        }
        catch(DeleteException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Vehicule[] getVehicule() { return repo.getVehicules(); }

    public void displayByCost(int cost)
    {
        Vehicule[] vector = repo.getVehicules();
        for(int i = 0; i < repo.getSize(); i++)
            if (vector[i].getCost() >= 1000)
            System.out.println(vector[i].toString());
    }
}

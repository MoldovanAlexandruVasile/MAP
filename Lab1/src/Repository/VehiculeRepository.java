package Repository;
import Model.*;

public interface VehiculeRepository
{
    public Vehicule[] getVehicules();
    public void addVehicule(Vehicule v);
    public void removeVehicule(Vehicule v) throws DeleteException;
    public int getSize();
}

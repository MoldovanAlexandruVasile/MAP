package Repository;
import Model.*;

public class ArrayVehiculeRepository implements VehiculeRepository {
    private Vehicule vector[];
    private int size;

    public ArrayVehiculeRepository() {
        vector = new Vehicule[100];
        size = 0;
    }

    public void addVehicule(Vehicule v) {
        if (size == vector.length)
            resize();
        vector[size++] = v;
    }

    public void removeVehicule(Vehicule v) throws DeleteException {
        for (int i = 0; i < size; i++)
            if (vector[i].equals(v))
            {
                vector[i] = vector[size - 1];
                size--;
                return;
            }
        throw new DeleteException("\n\tThe vehicule does not exist in the repair list !");
    }

    private void resize() {
        Vehicule nvector[] = new Vehicule[2 * size];
        for (int i = 0; i < getSize(); i++)
        {
            nvector[i] = vector[i];
        }
        vector = nvector;
    }

    public Vehicule[] getVehicules() {
        Vehicule[] nvector = new Vehicule[getSize()];
        for (int i = 0; i < getSize(); i++)
        {
            nvector[i] = vector[i];
        }
        return nvector;
    }

    public int getSize()
    {
        return size;
    }
}


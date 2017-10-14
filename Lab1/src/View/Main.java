package View;

import Model.*;
import Controller.*;
import Repository.*;

public class Main
{
    private static void testAddToRepo(Controller ctrl)
    {
        //Add some items to the repo
        Vehicule v = new Car(950, "Audi", "Red");
        ctrl.addVehiculeC(v);
        Vehicule v1 = new Truck(3000, "Man", "Grey");
        ctrl.addVehiculeC(v1);
        Vehicule v2 = new Motorcicle(1000, "Yamaha", "Yellow and White");
        ctrl.addVehiculeC(v2);
        Vehicule v3 = new Car(500, "BMW", "Light Blue");
        ctrl.addVehiculeC(v3);
        Vehicule v4 = new Truck(5000, "Mercedes", "Black");
        ctrl.addVehiculeC(v4);
        Vehicule v5 = new Motorcicle(1263, "BMW", "Yellow");
        ctrl.addVehiculeC(v5);
        Vehicule v6 = new Car(9999, "Volvo", "Grey");
        ctrl.addVehiculeC(v6);
        Vehicule v7 = new Car(10000, "Porche", "Black");
        ctrl.addVehiculeC(v7);
        Vehicule v8 = new Truck(999, "MAN", "White");
        ctrl.addVehiculeC(v8);
        Vehicule v9 = new Motorcicle(1263, "Honda", "White");
        ctrl.addVehiculeC(v9);
    }

    private static void testRemoveFromRepo(Controller ctrl)
    {
        //Trying to delete an inexistent item
        Vehicule v20 = new Motorcicle(1000, "Kawasaki", "Black and White");
        System.out.println("\n\n\tTrying to delete a vehicule that was not added to the repair list. For example:");
        System.out.println(v20.toString());
        ctrl.removeVehiculeC(v20);
    }

    public static void main(String[] a)
    {
        VehiculeRepository repo = new ArrayVehiculeRepository();
        Controller ctrl = new Controller(repo);

        testAddToRepo(ctrl);

        //Display all the items with a bigger cost than 1000
        System.out.println("\n\tVehicules with 1000 or a bigger amount of repair are:\n");
        ctrl.displayByCost(1000);

        testRemoveFromRepo(ctrl);
    }
}
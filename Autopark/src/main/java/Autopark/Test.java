package Autopark;

import java.awt.*;

/**
 * Created by Dmitry on 16.11.2016.
 */
public class Test {
    public static void main(String args[]) {
        AutoPark cars = new AutoPark();
        Vehicle v1 = new Vehicle(1.0, 750, "Lada", 1989);
        Vehicle v2 = new Vehicle(1.1, 2500, "Mazda", 2002);
        Vehicle v3 = new Vehicle(1.2, 3000, "Toyota", 2004);
        Vehicle v4 = new Vehicle(1.3, 2750, "Jeep", 1999);
        Vehicle v5 = new Vehicle(1.4, 5000, "BMW", 2007);
        cars.putCar(v1);
        cars.putCar(v2);
        cars.putCar(v3);
        cars.putCar(v4);
        cars.putCar(v5);
        cars.getCars();
    }
}


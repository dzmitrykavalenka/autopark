package Autopark;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dmitry on 16.11.2016.
 */
public class Test{
    public static void main(String args[]) {
        AutoPark cars = new AutoPark();
        CarWriterClass cars1 = new CarWriterClass();
        Vehicle v1 = new Vehicle(1.0, 750, "Lada", 1989);
        Vehicle v2 = new Vehicle(1.3, 2750, "Jeep", 1999);
        Vehicle v3 = new Vehicle(1.1, 2500, "Mazda", 2002);
        Vehicle v4 = new Vehicle(1.2, 3000, "Toyota", 2004);
        Vehicle v5 = new Vehicle(1.4, 5000, "BMW", 2007);
        cars.putCar(v1);
        cars.putCar(v2);
        cars.putCar(v3);
        cars.putCar(v4);
        cars.putCar(v5);
        //cars.getCars();
        //cars.getCarById(1.3);
        //cars.getCarByYear(1989, 1999);
        //cars.getCarByPrice(30,200000);
        //cars.deleteCarById(1.1);
        //cars.getCars();
        cars1.writeVehicleData(v1, "2.txt");
        cars1.writeVehicleData(v2, "2.txt");
        cars1.writeVehicleData(v3, "2.txt");
        cars1.writeVehicleData(v4, "2.txt");
        cars1.writeVehicleData(v5, "2.txt");
        cars1.writeVehicleDataToJson(v1, "1.JSON");
        cars1.writeVehicleDataToJson(v2, "1.JSON");
        cars1.writeVehicleDataToJson(v3, "1.JSON");
        cars1.writeVehicleDataToJson(v4, "1.JSON");
        cars1.writeVehicleDataToJson(v5, "1.JSON");
    }
}

package runner;

import Autopark.AutoPark;
import Autopark.Vehicle;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 11.12.2016.
 */
public class TestAutoPark {
    AutoPark cars1;
    Vehicle vehicle;
    Vehicle vehicle1;
    Vehicle vehicle2;
    @BeforeClass()
    public void setUp() {
        cars1 = new AutoPark();
        vehicle = new Vehicle(1.0, 750, "Lada", 1989);
        vehicle1 = new Vehicle(1.3, 2750, "Jeep", 1999);
        vehicle2 = new Vehicle(1.4, 3500, "Jeep", 2002);
    }
    @AfterMethod
    public void afterTest() {
        cars1.deleteCar(vehicle);
        cars1.deleteCar(vehicle1);
        cars1.deleteCar(vehicle2);
    }


}

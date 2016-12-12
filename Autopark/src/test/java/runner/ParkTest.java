package runner;

import Autopark.AutoPark;
import Autopark.IncorrectValueException;
import Autopark.Vehicle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by Dmitry on 11.12.2016.
 */
public class ParkTest extends TestAutoPark {
    @Test()
    public void getInfo() {
        Vehicle vehicle = new Vehicle(1.0, 750, "Lada", 1989);
        vehicle.getInfo();
        Assert.assertEquals(vehicle.getInfo(), "[CarID] 1.0 [Model] Lada [Year] 1989 [Price] 750;");
    }

    @Test()
    public void putCar() {
        AutoPark cars1 = new AutoPark();
        Vehicle vehicle = new Vehicle(1.0, 750, "Lada", 1989);
        cars1.putCar(vehicle);
        Assert.assertSame(true, cars1.getCars().contains(vehicle));
    }

    @Test()
    public void showCars() {
        AutoPark cars1 = new AutoPark();
        Vehicle vehicle = new Vehicle(1.0, 750, "Lada", 1989);
        Vehicle vehicle1 = new Vehicle(1.2, 750, "Lada", 1989);
        cars1.putCar(vehicle);
        cars1.putCar(vehicle1);
        cars1.showCars();
        Assert.assertEquals(cars1.showCars().get(1).getInfo(), vehicle1.getInfo());
    }

    @Test
    public void deleteCar() {
        AutoPark cars1 = new AutoPark();
        Vehicle vehicle = new Vehicle(1.0, 750, "Lada", 1989);
        cars1.putCar(vehicle);
        cars1.deleteCar(vehicle);
        Assert.assertEquals(cars1.getCars().contains(vehicle), false);
    }

    @Test(dataProvider = "CarID")
    public void getCarById(double a, String expected) throws IncorrectValueException {
        AutoPark cars1 = new AutoPark();
        Vehicle vehicle = new Vehicle(1.0, 750, "Lada", 1989);
        Vehicle vehicle1 = new Vehicle(1.3, 2750, "Jeep", 1999);
        cars1.putCar(vehicle);
        cars1.putCar(vehicle1);
        cars1.getCarById(a);
        Assert.assertEquals(cars1.getCarById(a).getInfo(), expected);
    }


    @Test(expectedExceptions = IncorrectValueException.class, expectedExceptionsMessageRegExp = ".*Incorrect car ID")
    public void IncorrectValueException() throws IncorrectValueException {
        AutoPark cars1 = new AutoPark();
        cars1.getCarById(1.8);
    }

    @Test(dataProvider = "byYear")
    public void getCarByYear(int a, int b) throws IncorrectValueException {
        AutoPark cars1 = new AutoPark();
        Vehicle vehicle = new Vehicle(1.0, 750, "Lada", 1989);
        Vehicle vehicle1 = new Vehicle(1.3, 2750, "Jeep", 1999);
        Vehicle vehicle2 = new Vehicle(1.4, 2750, "Mazda", 2005);
        cars1.putCar(vehicle);
        cars1.putCar(vehicle1);
        cars1.putCar(vehicle2);
        cars1.getCarByYear(a, b);
        Assert.assertEquals(cars1.getCarByYear(a, b).contains(vehicle1), true);
    }

    @Test
    public void deleteCarByID() throws IncorrectValueException {
        AutoPark cars1 = new AutoPark();
        Vehicle vehicle = new Vehicle(1.0, 750, "Lada", 1989);
        Vehicle vehicle1 = new Vehicle(1.3, 2750, "Jeep", 1999);
        Vehicle vehicle2 = new Vehicle(1.4, 2750, "Mazda", 2005);
        cars1.putCar(vehicle);
        cars1.putCar(vehicle1);
        cars1.putCar(vehicle2);
        cars1.deleteCarById(1.3);
        Assert.assertEquals(cars1.getCars().contains(vehicle1), false);
    }

    @Test(dataProvider = "byPrice")
    public void getCarByPrice(int a, int b) throws IncorrectValueException {
        AutoPark cars1 = new AutoPark();
        Vehicle vehicle = new Vehicle(1.0, 750, "Lada", 1989);
        Vehicle vehicle1 = new Vehicle(1.3, 2750, "Jeep", 1999);
        Vehicle vehicle2 = new Vehicle(1.4, 4000, "Mazda", 2005);
        cars1.putCar(vehicle);
        cars1.putCar(vehicle1);
        cars1.putCar(vehicle2);
        cars1.getCarByPrice(a, b);
        Assert.assertEquals(true, cars1.getCarByPrice(a, b).contains(vehicle));
    }


    @DataProvider(name = "CarID")
    public Object[][] CarID() {
        return new Object[][]{
                {1.0, "[CarID] 1.0 [Model] Lada [Year] 1989 [Price] 750;"},
                {1.3, "[CarID] 1.3 [Model] Jeep [Year] 1999 [Price] 2750;"}
        };
    }

    @DataProvider(name = "byYear")
    public Object[][] Year() {
        return new Object[][]{
                {1989, 2000},
                {2000, 2007}
        };
    }

    @DataProvider(name = "byPrice")
    public Object[][] Price() {
        return new Object[][]{
                {500, 2000},
                {2000, 5000}
        };
    }
}



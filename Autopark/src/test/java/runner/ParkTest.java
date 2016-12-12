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
    @Test(priority = 0)
    public void getInfo() {
        Assert.assertEquals(vehicle.getInfo(), "[CarID] 1.0 [Model] Lada [Year] 1989 [Price] 750;");
    }

    @Test(priority = 1)
    public void putCar() {
        cars1.putCar(vehicle);
        Assert.assertSame(cars1.getCars().contains(vehicle), true);
    }

    @Test(priority = 2)
    public void showCars() {
        cars1.putCar(vehicle);
        cars1.putCar(vehicle1);
        Assert.assertEquals(cars1.showCars().get(0).getInfo(), vehicle.getInfo());
    }

    @Test(priority = 3)
    public void deleteCar() {
        cars1.putCar(vehicle1);
        cars1.deleteCar(vehicle1);
        Assert.assertEquals(cars1.getCars().contains(vehicle1), false);
    }

    @Test(dataProvider = "CarID", priority = 4)
    public void getCarById(double a, String expected) throws IncorrectValueException {
        cars1.putCar(vehicle);
        cars1.putCar(vehicle1);
        Assert.assertEquals(cars1.getCarById(a).getInfo(), expected);
    }


    @Test(priority = 5, expectedExceptions = IncorrectValueException.class, expectedExceptionsMessageRegExp = ".*Incorrect car ID")
    public void IncorrectValueException() throws IncorrectValueException {
        cars1.getCarById(1.8);
    }

    @Test(priority = 6, dataProvider = "byYear")
    public void getCarByYear(int a, int b, Vehicle v) throws IncorrectValueException {
        cars1.putCar(vehicle);
        cars1.putCar(vehicle1);
        cars1.putCar(vehicle2);
        Assert.assertEquals(cars1.getCarByYear(a, b).contains(v), true);
    }

    @Test(priority = 7, dataProvider = "deleteById")
    public void deleteCarByID(double a, Vehicle v) throws IncorrectValueException {
        cars1.putCar(vehicle);
        cars1.deleteCarById(a);
        cars1.putCar(vehicle1);
        cars1.deleteCarById(a);
        cars1.putCar(vehicle2);
        cars1.deleteCarById(a);
        Assert.assertEquals(cars1.getCars().contains(v), false);
    }

    @Test(priority = 8, dataProvider = "byPrice")
    public void getCarByPrice(int a, int b, Vehicle v) throws IncorrectValueException {
        cars1.putCar(vehicle);
        cars1.putCar(vehicle1);
        cars1.putCar(vehicle2);
        Assert.assertEquals(cars1.getCarByPrice(a, b).contains(v), true);
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
                {1989, 1995, vehicle},
                {1995, 2000, vehicle1},
                {2000, 2007, vehicle2}
        };
    }

    @DataProvider(name = "byPrice")
    public Object[][] Price() {
        return new Object[][]{
                {0, 1000, vehicle},
                {2000, 3000, vehicle1},
                {3000, 5000, vehicle2}
        };
    }

    @DataProvider(name = "deleteById")
    public Object[][] deleteCarID() {
        return new Object[][]{
                {1.0, vehicle},
                {1.3, vehicle1},
                {1.4, vehicle2}
        };
    }

}



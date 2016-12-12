package Autopark;

import com.google.gson.JsonElement;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dzmitry_Kavalenka on 11/17/2016.
 */
public class AutoPark {


    protected List<Vehicle> cars;

    public AutoPark() {
        cars = new ArrayList<>();
    }

    public void putCar(Vehicle car) {
        cars.add(car);
    }

    public List<Vehicle> getCars() {
        return cars;
    }

    public List<Vehicle> showCars() {
        List<Vehicle> cars1 = new ArrayList<>();
        for (Vehicle v : cars) {
            cars1.add(v);
            System.out.println(v.getInfo());
        }
        return cars1;
    }

    public void deleteCar(Vehicle car) {
        cars.remove(car);
    }

    public Vehicle getCarById(double a) throws IncorrectValueException {
        double e = 1.0;
        double e1 = 1.4;
        if (a < e || a > e1) {
            throw new IncorrectValueException("Incorrect car ID");
        } else
            for (Vehicle v : cars) {
                if (a == v.getCarID()) {
                    System.out.println(v.getInfo());
                    return v;
                }
            }
        return null;
    }

    public List<Vehicle> getCarByYear(int a, int b) throws IncorrectValueException {
        List<Vehicle> cars1 = new ArrayList<>();
        int e = 1989;
        int e1 = 2007;
        if ((a < e || a > e1) || (b > e1 || b < e) || a > b) {
            throw new IncorrectValueException("Check the correctness of parameters");
        } else
            for (Vehicle v1 : cars) {
                if (a >= e && b <= e1 && a <= v1.getYear() && b >= v1.getYear()) {
                  System.out.println(v1.getInfo());
                    cars1.add(v1);
                }
            }
        return cars1;
    }


    public List<Vehicle> getCarByPrice(int a, int b) throws IncorrectValueException {
        List<Vehicle> cars1 = new ArrayList<>();
        int e = 0;
        int e1 = 5000;
        if (a > e1 || b < e || a > b) {
            throw new IncorrectValueException("Incorrect price range");
        } else
            for (Vehicle v : cars)

                if (a <= v.getPrice() && b >= v.getPrice()) {
                    System.out.println(v.getInfo());
                    cars1.add(v);
                }
                return  cars1;
    }

    public Vehicle deleteCarById(double a) throws IncorrectValueException {
        double e = 1.0;
        double e1 = 1.4;
        if (a < e || a > e1) {
            throw new IncorrectValueException("Incorrect car ID");
        } else
            for (Vehicle v : cars)

                if (a == v.getCarID()) {
                    deleteCar(v);
                    //break;
                    return v;
                }
                return null;
    }
}






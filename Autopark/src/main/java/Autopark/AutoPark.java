package Autopark;

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


    public void getCars() {
        for (Vehicle v : cars) {
            System.out.println(v.getInfo());
        }
    }

    public void deleteCar(Vehicle car) {
        cars.remove(car);
    }

    public void getCarById(double a) {
        double e = 1.0;
        double e1 = 1.4;
        for (Vehicle v : cars) {
            try {
                if (a < e || a > e1) {
                    throw new IncorrectValueException("Incorrect car ID");
                }
                if (a == v.getCarID()) {
                    System.out.println(v.getInfo());
                }
            } catch (IncorrectValueException exc) {
                System.out.println(exc);
            }
        }
    }

    public void getCarByYear(int a, int b) {
        List<Vehicle> cars1 = new ArrayList<>();
        int e = 1989;
        int e1 = 2007;
        for (Vehicle v : cars)
            try {
                if ((a < e || a > e1) || (b > e1 || b < e) || a > b) {
                    throw new IncorrectValueException("Check the correctness of parameters");
                }
                if (a >= e && b <= e1 && a <= v.getYear() && b >= v.getYear()) {
                    System.out.println(v.getInfo());
                    cars1.add(v);
                }
            } catch (IncorrectValueException exc) {
                System.out.println(exc);
            }
    }


    public void getCarByPrice(int a, int b) {
        List<Vehicle> cars1 = new ArrayList<>();
        int e = 750;
        int e1 = 5000;
        for (Vehicle v : cars)
            try {
                if (a > e1 || b < e || a > b) {
                    throw new IncorrectValueException("Incorrect price range");
                }
                if (a <= v.getPrice() && b >= v.getPrice()) {
                    System.out.println(v.getInfo());
                    cars1.add(v);
                }
            } catch (IncorrectValueException exc) {
                System.out.println(exc);
            }
    }

    public void deleteCarById(double a) {
        double e = 1.0;
        double e1 = 1.4;
        for (Vehicle v : cars)
            try {
                if (a < e || a > e1) {
                    throw new IncorrectValueException("Incorrect car ID");
                }
                if (a == v.getCarID()) {
                    deleteCar(v);
                    break;
                }
            } catch (IncorrectValueException exc) {
                System.out.println(exc);
            }
    }

}





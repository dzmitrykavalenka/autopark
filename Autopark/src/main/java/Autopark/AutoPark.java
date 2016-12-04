package Autopark;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dzmitry_Kavalenka on 11/17/2016.
 */
public class AutoPark {

    private List<Vehicle> cars;

    public AutoPark() {
        cars = new ArrayList<>();
    }

    Scanner sc = new Scanner(System.in);

    public void putCar(Vehicle car) {
        cars.add(car);
    }


    public void getCars() {
        for (Vehicle v : cars) {
            System.out.println(v.getInfo());
        }
    }

    public void byID() {
        System.out.println("Please, enter the ID of the car: ");
        double a = sc.nextDouble();
        for (Vehicle v : cars) {
            try {
                if (a < 1.0 || a > 1.5) {
                    throw new IncorrectValueException(a);
                }
                if (a == v.getCarID()) {
                    System.out.println("The car you're looking for is: " + v.getInfo());
                }
            } catch (IncorrectValueException exc) {
                System.out.println(exc);
            }
        }
    }

    public void byYear() {
        System.out.println("Please, choose the interval of years you want to see cars in: ");
        System.out.println("From: ");
        int a = sc.nextInt();
        System.out.println("To: ");
        int b = sc.nextInt();
        for (Vehicle v : cars) {
            try {
                if (a < 1989 || b > 2007) {
                    throw new IncorrectValueException(a, b);
                }
                if (a >= 1989 && b <= 2007 && a <= v.getYear() && b >= v.getYear()) {
                    System.out.println("The cars you are looking for : " + v.getInfo());
                }
            } catch (IncorrectValueException exc) {
                System.out.println(exc);
            }
        }
    }

    public void byPrice() {
        System.out.println("Please, choose the price range: ");
        System.out.println("From: ");
        int a = sc.nextInt();
        System.out.println("To: ");
        int b = sc.nextInt();
        for (Vehicle v : cars)
            try {
                if (a < 750 || b > 5000) {
                    throw new IncorrectValueException(a, b);
                }
                if (a >= 750 && b <= 5000 && a <= v.getPrice() && b >= v.getPrice()) {
                    System.out.println("The cars you are looking for : " + v.getInfo());

                }
            } catch (IncorrectValueException exc) {
                System.out.println(exc);
            }
    }

}




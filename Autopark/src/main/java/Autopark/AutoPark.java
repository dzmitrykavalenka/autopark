package Autopark;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dzmitry_Kavalenka on 11/17/2016.
 */
public class AutoPark {

    private List<Vehicle> cars;

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

}


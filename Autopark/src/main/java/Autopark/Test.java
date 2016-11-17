package Autopark;

import java.awt.*;

/**
 * Created by Dmitry on 16.11.2016.
 */
public class Test {
    public static void main(String args[]){
        Vehicle v1 = new Vehicle(1.0, 750, "Lada", 1989);
        Vehicle v2 = new Vehicle(1.1, 2500, "Mazda", 2002);
        System.out.println (v1.getInfo());
        System.out.println (v2.getInfo());

    }
}


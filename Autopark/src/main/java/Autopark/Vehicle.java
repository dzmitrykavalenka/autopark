package Autopark;

/**
 * Created by Dmitry on 16.11.2016.
 */
public class Vehicle extends Transport {
    private double carID;
    private int price;

    public Vehicle(double carID, int price, String model, int year) {
        super(model, year);
        this.carID = carID;
        this.price = price;
    }


    public String getInfo() {
        return "[CarID] " + carID + " [Model] " + super.getModel() + " [Year] " + super.getYear() + " [Price] " + price + ";";
    }

    public int getPrice() {
        return price;
    }

    public double getCarID() {

        return carID;
    }
}

